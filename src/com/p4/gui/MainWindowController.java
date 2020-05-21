package com.p4.gui;

import com.p4.CliExec;
import com.p4.codegen.CodeVisitor;
import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.symbols.SymbolTable;
import com.p4.syntaxSemantic.*;
import com.p4.syntaxSemantic.nodes.ProgNode;
import com.p4.syntaxSemantic.visitors.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainWindowController {


    public String fileName;

    public String filePath;

    public String newFilePath;

    public String dirPath;

    @FXML
    public TextField chosenFilePath;

    @FXML
    public Button outputFileButton;

    @FXML
    public Button compileButton;

    @FXML
    public TextField chosenOutputPath;

    @FXML
    public ImageView imageView;

    @FXML
    private TextArea console;
    private static PrintStream printStreamLog;

    @FXML
    private TextArea ArduinoConsole;
    private static PrintStream printStreamArduino;

    @FXML
    public ProgressIndicator spinner;

    public void initialize() throws FileNotFoundException {
        printStreamLog = new PrintStream(new Console(console));
        printStreamArduino = new PrintStream(new Console(ArduinoConsole));
        FileInputStream inputstream = new FileInputStream(System.getProperty("user.dir") + "\\icon.png");
        Image image = new Image(inputstream);
        imageView.setImage(image);
    }

    public void CompileButtonAction(ActionEvent actionEvent) {
        //Clear the log
        console.clear();

        //Create the errorbag
        ErrorBag errors = new ErrorBag();
        if (fileName != null){
            try {
                print("Compiling C* to Arduino C code... ", false);
                System.setOut(printStreamLog);
                System.setErr(printStreamLog);
                //Get the contents of the file
                Path inputSource = Paths.get(filePath);
                CharStream inputStream = CharStreams.fromPath(inputSource);



                //Gets a parse tree for making the AST
                ParseTree tree = syntaxPhase(inputStream, errors);

                //Enters if there were no errors when parsing or scanning
                if (!errors.containsErrors()) {
                    //Creates the AST
                    CStarBaseVisitor<?> visitor = new AstVisitor<>();
                    ProgNode ast = (ProgNode) visitor.visit(tree);

                    //AstTreeVisitor astTreeVisitor = new AstTreeVisitor();
                    //astTreeVisitor.visit(0, ast);

                    //Creates the symbol table
                    SymbolTable symbolTable = symbolTableSetup(ast, errors);

                    //Type checks and scope checks the AST
                    SemanticsVisitor semanticsVisitor = new SemanticsVisitor(symbolTable, errors);
                    semanticsVisitor.visit(ast);

                    //Enters if no errors were found when type/scope checking
                    if (!errors.containsErrors()) {
                        codeGenerationPhase(symbolTable, ast, errors);
                        print("OK!", true);

                        //Creates the command line interface
                        CliExec cli = new CliExec(errors, true);
                        cli.arduinoSelection();
                        cli.compileAndUpload();


                    }
                    else {
                        print("Failed!", true);
                    }
                }
                else {
                    print("Failed!", true);
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
        errors.display();
    }

    public static ParseTree syntaxPhase(CharStream inputStream, ErrorBag errors) {
        //Scans the source code
        CStarLexer lexer = new CStarLexer(inputStream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new LexerErrorListener(errors));
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

        //Parses the source source code
        CStarParser parser = new CStarParser(commonTokenStream);
        parser.setBuildParseTree(true);
        parser.setErrorHandler(new CStarErrorStrategy());
        parser.removeErrorListeners();
        parser.addErrorListener(new ParserErrorListener(errors));

        return parser.prog();
    }

    public static SymbolTable symbolTableSetup(ProgNode ast, ErrorBag errors) {
        //Visits functions and adds their declaration into the symbol table
        SymbolTable symbolTable = new SymbolTable();
        FuncVisitor funcVisitor = new FuncVisitor(symbolTable, errors);
        funcVisitor.visit(ast);

        //Enters if the setup and loop functions haven't been declared in the source code
        if (!symbolTable.isSetupAndLoopDefined()) {
            errors.addEntry(ErrorType.MISSING_ARDUINO_FUNCTION,
                "Both the functions 'void setup()' and 'void loop()' are required by Arduino");
        }
        //Adds variable declarations in the symbol table
        SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor(symbolTable, errors);
        symbolTableVisitor.visit(ast);

        return symbolTable;
    }

    public void codeGenerationPhase(SymbolTable symbolTable, ProgNode ast, ErrorBag errors) {
        //Generates the Arduino C code equivalent to the CStar code
        CodeVisitor codeVisitor = new CodeVisitor(symbolTable);
        codeVisitor.visit(ast);
    }



    public void ChooseInputFileButtonAction(ActionEvent actionEvent) throws IOException {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter cstarExtensionFilter = new FileChooser.ExtensionFilter("CStar - Source file", "*.cstar");
        fc.getExtensionFilters().add(cstarExtensionFilter);
        File selected = fc.showOpenDialog(null);


        if (selected != null){
            chosenFilePath.setText(selected.getAbsolutePath());
            fileName = selected.getName();
            fileName = fileName.substring(0,fileName.length() - 6);

            StringBuilder stringBuilder = new StringBuilder(selected.getAbsolutePath());
            stringBuilder.replace(stringBuilder.length() - 6, stringBuilder.length(), "");

            this.dirPath = stringBuilder.toString() + "/";

            stringBuilder.append("/").append(fileName).append(".ino");

            newFilePath = stringBuilder.toString();
            filePath = selected.getAbsolutePath();

            chosenOutputPath.setText(newFilePath);
        }
    }

    private void createDir(String dirPath){
        File directory = new File(dirPath);

        //Enters if there is not directory
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public void ChooseOutputFileButtonAction(ActionEvent actionEvent) {
        if (fileName == null){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a file before choosing the output folder", ButtonType.OK);
            alert.showAndWait();
        } else {
            DirectoryChooser fc = new DirectoryChooser();
            File selected = fc.showDialog(null);

            if (selected != null) {
                String dirPath = selected.getAbsolutePath();
                this.dirPath = dirPath;
                createDir(dirPath);
                String newFile = new File(dirPath).getName();
                String filePath = dirPath + "/" + newFile + ".ino";
                chosenOutputPath.setText(filePath);
            }
        }
    }

    public static void print(String text, boolean skipNewline) {
        if (skipNewline) {
            printStreamLog.println(text);
        }
        else {
            printStreamLog.print(text);
        }
    }
    public static void showStage() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getClassLoader().getResource("AdvancedOptions.fxml"));
        Parent root = loader.load();
        Stage dialog = new Stage();

        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setTitle("Select Arduino board");
        dialog.setScene(new Scene(root));

        dialog.showAndWait();
    }

}
