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
import com.p4.gui.GUI;

public class Main {
    public static void main(String[] args) {

        GUI.main(args);
    }

}
