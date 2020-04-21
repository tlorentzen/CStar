package com.p4;

import com.p4.codegen.CodeVisitor;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.*;
import com.p4.parser.nodes.ProgNode;
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

        Path inputSource = null;
        ErrorBag errors = new ErrorBag();

        if(args.length == 1){
            inputSource = Paths.get(args[0]);

            System.out.println("####  The C* Parser ####");
            System.out.println("File: "+inputSource.getFileName());
            System.out.println("Path: "+inputSource.toAbsolutePath());

            if(Files.exists(inputSource)){

                String ext = getFileExtension(new File(args[0]));
                System.out.println("Ext:  "+ext);
                System.out.println("");

                if(ext.equals("cstar")){
                    try{
                        CharStream inputStream = CharStreams.fromPath(inputSource);

                        var symbolTable = new SymbolTable();

                        /*
                        errors.addEntry(ErrorType.TYPE_ERROR, "Error here!", 1);
                        errors.addEntry(ErrorType.TYPE_ERROR, "Warning here!", 1);
                        errors.addEntry(ErrorType.TYPE_ERROR, "Information here!",1);
                        errors.addEntry(ErrorType.WARNING, "Warning here!", 1);
                        errors.addEntry(ErrorType.WARNING, "Warning here!", 1);
                        errors.addEntry(ErrorType.WARNING, "Information here!",1);
                        errors.addEntry(ErrorType.INFORMATION, "Error here!", 1);
                        errors.addEntry(ErrorType.INFORMATION, "Warning here!", 1);
                        errors.addEntry(ErrorType.INFORMATION, "Information here!",1);
                        */

                        CStarLexer lexer = new CStarLexer(inputStream);
                        lexer.removeErrorListeners();
                        lexer.addErrorListener(new LexerErrorListener(errors));
                        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                        CStarParser parser = new CStarParser(commonTokenStream);
                        parser.setBuildParseTree(true);
                        parser.removeErrorListeners();
                        parser.addErrorListener(new ParserErrorListener(errors));
                        ParseTree tree = parser.prog();

                        if(!errors.containsErrors()){
                            CStarBaseVisitor<?> visitor = new AstVisitor<>();
                            ProgNode ast = (ProgNode) visitor.visit(tree);

                            SemanticsVisitor semanticsVisitor = new SemanticsVisitor(symbolTable, errors);
                            semanticsVisitor.visit(ast);

                            /*
                            AstTreeVisitor astTreeVisitor = new AstTreeVisitor();
                            astTreeVisitor.visit(0, ast);
                            */

                            /*
                            CodeVisitor codeVisitor = new CodeVisitor();
                            codeVisitor.visit(ast);
                            */
                        }
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }else{
                    errors.addEntry(ErrorType.WRONG_EXTENSION, "Wrong file extension, expected .cstar");
                }
            }else{
                errors.addEntry(ErrorType.SOURCE_FILE_DOES_NOT_EXIST, "Source file not found.");
            }

            errors.display();
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
