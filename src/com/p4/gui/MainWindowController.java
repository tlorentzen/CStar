package com.p4.gui;

import com.p4.CliExec;
import com.p4.CmdPrint;
import com.p4.Main;
import com.p4.SystemInfo;
import com.p4.errors.ErrorBag;
import com.p4.symbols.SymbolTable;
import com.p4.syntaxSemantic.nodes.ProgNode;
import com.p4.syntaxSemantic.visitors.AstVisitor;
import com.p4.syntaxSemantic.visitors.CStarBaseVisitor;
import com.p4.syntaxSemantic.visitors.SemanticsVisitor;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainWindowController {


    public String fileName;

    public String filePath;

    @FXML
    public TextField chosenFilePath;

    @FXML
    public Button outputFileButton;

    @FXML
    public Button compileButton;

    @FXML
    public CheckBox overrideOutputPath;

    @FXML
    public TextField chosenOutputPath;

    @FXML
    private TextArea console;
    private PrintStream ps;

    @FXML
    public ProgressIndicator spinner;

    public void initialize() {
        ps = new PrintStream(new Console(console)) ;
    }

    public void CompileButtonAction(ActionEvent actionEvent) {
        if (fileName != null){
            try {
                System.setOut(ps);
                System.setErr(ps);
                //Get the contents of the file
                Path inputSource = Paths.get(filePath);
                CharStream inputStream = CharStreams.fromPath(inputSource);

                //Create the errorbag
                ErrorBag errors = new ErrorBag();

                //Gets a parse tree for making the AST
                ParseTree tree = Main.syntaxPhase(inputStream, errors);

                //Enters if there were no errors when parsing or scanning
                if (!errors.containsErrors()) {
                    //Creates the AST
                    CStarBaseVisitor<?> visitor = new AstVisitor<>();
                    ProgNode ast = (ProgNode) visitor.visit(tree);

                    //AstTreeVisitor astTreeVisitor = new AstTreeVisitor();
                    //astTreeVisitor.visit(0, ast);

                    //Creates the symbol table
                    SymbolTable symbolTable = Main.symbolTableSetup(ast, errors);

                    //Type checks and scope checks the AST
                    SemanticsVisitor semanticsVisitor = new SemanticsVisitor(symbolTable, errors);
                    semanticsVisitor.visit(ast);

                    //Enters if no errors were found when type/scope checking
                    if (!errors.containsErrors()) {
                        Main.codeGenerationPhase(symbolTable, ast, errors);
                        CmdPrint.printOk();

                        //Creates the command line interface
                        CliExec cli = new CliExec(errors, true);
                        cli.arduinoSelection();
                        cli.compileAndUpload();
                    }
                    else {
                        CmdPrint.printFailed();
                    }
                }
                else {
                    CmdPrint.printFailed();
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public void ChooseInputFileButtonAction(ActionEvent actionEvent) throws IOException {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter cstarExtensionFilter = new FileChooser.ExtensionFilter("CStar - Source file", "*.cstar");
        File selected = fc.showOpenDialog(null);


        if (selected != null){
            chosenFilePath.setText(selected.getAbsolutePath());
            filePath = selected.getAbsolutePath();
            fileName = selected.getName();
            getOutputPath(selected.getAbsolutePath());
        }
    }

    private void getOutputPath(String filePath){

        String dirPath = filePath.substring(0, filePath.length() - 6);

        createDir(dirPath);

        String newFilePath = dirPath + "/" + fileName.substring(0, fileName.length() - 6) + ".ino";
        chosenOutputPath.setText(newFilePath);
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
                createDir(dirPath);
                String newFile = new File(dirPath).getName();
                String filePath = dirPath + "/" + newFile + ".ino";
                chosenOutputPath.setText(filePath);
            }
        }
    }

    public void print(String text, boolean skipNewline) {
        if (skipNewline) {
            System.out.println(text + "\n");
        }
        else {
            System.out.println(text);
        }
    }

    public class Console extends OutputStream {
        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char)b));
        }
    }
}
