package com.p4.parser.visitors;

import com.p4.parser.CStarParser;
import com.p4.parser.nodes.AstNode;
import com.p4.parser.nodes.IdNode;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AstVisitorTest {

    @Test
    void visitProgWithProgContextWithEmptyContext(){
        AstVisitor astVisitor = new AstVisitor();
        CStarParser.ProgContext progContext = new CStarParser.ProgContext(new ParserRuleContext(),0);
        AstNode astNode = astVisitor.visitProg(progContext);
        assertEquals(0,astNode.children.size());

    }

   /* @Test
    void visitProgWithProgContextWithChildren(){
        AstVisitor astVisitor = new AstVisitor();
        CStarParser.ProgContext progContext = new CStarParser.ProgContext(new ParserRuleContext(),0);
       progContext.addChild(new CStarParser.AssignContext(new ParserRuleContext(),0));
        AstNode astNode = astVisitor.visitProg(progContext);
        assertEquals(0,astNode.children.size());

    }*/

    @Test
    void visitProgWithProgContextVisitChild(){
        AstVisitor astVisitor = new AstVisitor();
        CStarParser.AssignContext tree = new CStarParser.AssignContext(new ParserRuleContext(), 0);
        tree.addChild(new TerminalNodeImpl(new CommonToken(CStarParser.ID)));
        Object visit = astVisitor.visit(tree);
       assertNotNull(visit);
       // I need to construct a tree nodes for all the tests, a small tree that is parsable


    }
}