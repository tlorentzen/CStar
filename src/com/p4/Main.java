package com.p4;

import com.p4.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {



        Path inputSource = null;

        if(args.length == 1){
            inputSource = Paths.get(args[0]);

            System.out.println("File: "+inputSource.getFileName());
            System.out.println("Path: "+inputSource.toAbsolutePath());

            if(Files.exists(inputSource)){

                try{
                    CharStream inputStream = CharStreams.fromPath(inputSource);

                    CStarLexer lexer = new CStarLexer(inputStream);
                    CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                    CStarParser parser = new CStarParser(commonTokenStream);
                    parser.setBuildParseTree(true);


                    ParseTree tree = parser.prog();


                    System.out.println(tree.getText());


                }catch (IOException e){
                    System.out.println(e);
                }

            }
        }

    }
}
