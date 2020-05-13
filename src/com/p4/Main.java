package com.p4;

import com.p4.codegen.CodeVisitor;
import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.syntaxSemantic.*;
import com.p4.syntaxSemantic.nodes.ProgNode;
import com.p4.syntaxSemantic.visitors.*;
import com.p4.symbols.SymbolTable;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path inputSource;
        ErrorBag errors = new ErrorBag();

        if (args.length == 1) {
            inputSource = Paths.get(args[0]);

            printStartInfo(inputSource);

            //Enters if the path for the source code does not exist
            if (!Files.exists(inputSource)) {
                errors.addEntry(ErrorType.SOURCE_FILE_DOES_NOT_EXIST, "Source file not found");
            }
            else {
                String extension = getFileExtension(new File(args[0]));
                System.out.println("Ext:  " + extension);
                System.out.println();

                //Enters if the program being compiled is not in a cstar format
                if (!extension.equals("cstar")) {
                    errors.addEntry(ErrorType.WRONG_EXTENSION, "Wrong file extension, expected .cstar");
                }
                else {
                    try {
                        //Get the contents of the file
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
                            SymbolTable symbolTable = symbolTableSetup(ast,  errors);

                            //Type checks and scope checks the AST
                            SemanticsVisitor semanticsVisitor = new SemanticsVisitor(symbolTable, errors);
                            semanticsVisitor.visit(ast);

                            //Enters if no errors were found when type/scope checking
                            if (!errors.containsErrors()) {
                               codeGenerationPhase(symbolTable, ast, errors);
                            }
                        }
                    }
                    catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
            errors.display();
        }
    }

    private static void printStartInfo(Path inputSource) {
        System.out.println(" ██████╗███████╗████████╗ █████╗ ██████╗ \n" +
                           "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗\n" +
                           "██║     ███████╗   ██║   ███████║██████╔╝\n" +
                           "██║     ╚════██║   ██║   ██╔══██║██╔══██╗\n" +
                           "╚██████╗███████║   ██║   ██║  ██║██║  ██║\n" +
                           " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝");
        System.out.println();
        System.out.println("File: " + inputSource.getFileName());
        System.out.println("Path: " + inputSource.toAbsolutePath());
    }
    
    private static ParseTree syntaxPhase(CharStream inputStream, ErrorBag errors) {
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

    private static SymbolTable symbolTableSetup(ProgNode ast, ErrorBag errors) {
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

    private static void codeGenerationPhase(SymbolTable symbolTable, ProgNode ast, ErrorBag errors) {
        //Generates theArduino C code equivalent to the CStar code
        CodeVisitor codeVisitor = new CodeVisitor(symbolTable);
        codeVisitor.visit(ast);

        //Creates the command line interface
        CliExec cli = new CliExec(errors, true);
        cli.arduinoSelection();
        cli.compileAndUpload();
    
        try {
            codeVisitor.print();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();

        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        else {
            return "";
        }
    }
}
