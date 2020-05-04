package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.parser.nodes.ProgNode;
import com.p4.symbols.SymbolTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FuncVisitorTest {

    private final FuncVisitor visitor = new FuncVisitor(new SymbolTable(), new ErrorBag());
    private ProgNode ast = new ProgNode();

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void visitChildren() {

    }

    @Test
    void visitFuncCall() {
    }

    @Test
    void visitFuncDcl() {
    }
}