package com.p4;

import com.p4.errors.ErrorBag;
import com.p4.parser.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path inputSource = null;

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
                        ErrorBag errors = new ErrorBag();

                        CStarLexer lexer = new CStarLexer(inputStream);
                        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                        CStarParser parser = new CStarParser(commonTokenStream);
                        parser.setBuildParseTree(true);

                        ParseTree tree = parser.prog();
                        CStarBaseVisitor<?> visitor = new AstVisitor<>();
                        AstNode ast = (AstNode) visitor.visit(tree);

                        //AstTreeVisitor astTreeVisitor = new AstTreeVisitor();
                        //astTreeVisitor.visit(0, ast);

                        TopDeclVisitor topDeclVisitor = new TopDeclVisitor(symbolTable, errors);
                        topDeclVisitor.visit(ast);

                        System.out.println(tree.getText());

                        errors.display();
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }else{
                    System.out.println("Invalid source file...");
                }
            }
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
