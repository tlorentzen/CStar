package com.p4.parser.visitors;

import com.p4.syntaxSemantic.visitors.AstVisitor;

class AstVisitorTest {

    private AstVisitor astVisitor = new AstVisitor();

    /*@Test
    void visitVal_ReceivesContextOfNegativeNumber_ReturnsCorrectValNode(){
        //Arrange
        var valContext = new CStarParser.ValContext(new ParserRuleContext(), 0);
        valContext.NUMBER() = (CStarParser.NUMBER);

        //Act
        var astNode = astVisitor.visitProg(progContext);
        var result = astNode.children.get(0);

        //Assert
        assert(result instanceof CommentNode);
    }

   @Test
    void visitProgWithProgContextWithChildren(){
        AstVisitor astVisitor = new AstVisitor();
        CStarParser.ProgContext progContext = new CStarParser.ProgContext(new ParserRuleContext(),0);
        progContext.addChild(new CStarParser.AssignContext(new ParserRuleContext(),0));
        AstNode astNode = astVisitor.visitProg(progContext);
        assertEquals(0,astNode.children.size());

    }

    @Test
    void visitProgWithProgContextVisitChild(){
        AstVisitor astVisitor = new AstVisitor();
        CStarParser.AssignContext tree = new CStarParser.AssignContext(new ParserRuleContext(), 0);
        tree.addChild(new TerminalNodeImpl(new CommonToken(CStarParser.ID)));
        Object visit = astVisitor.visit(tree);
       assertNotNull(visit);
       // I need to construct a tree nodes for all the tests, a small tree that is parsable


    }*/
}