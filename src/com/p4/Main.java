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

        if(args.length == 2){
            inputSource = Paths.get(args[1]);

            if(Files.exists(inputSource)){

                try{
                    CharStream inputStream = CharStreams.fromPath(inputSource);

                    CStarLexer lexer = new CStarLexer(inputStream);
                    CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                    CStarParser parser = new CStarParser(commonTokenStream);


                    CStarVisitor visitor = new CStarBaseVisitor();
                    visitor.visit(parser.getContext());

                }catch (IOException e){
                    System.out.println(e);
                }

            }
        }
    }
}
