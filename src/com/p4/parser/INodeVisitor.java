package com.p4.parser;

import com.p4.parser.nodes.*;

public interface INodeVisitor {

    void visitChildren(AstNode node);

    void visit(IdNode node);
    void visit(IntegerNode node);
    void visit(FloatNode node);
    void visit(PinNode node);
    void visit(LongNode node);
    void visit(CharNode node);
    void visit(AssignNode node);
    void visit(CondNode node);
    void visit(ProgNode node);
    void visit(ArrayAccessNode node);
    void visit(ArrayExprNode node);
    void visit(ArrayNode node);
    void visit(ReturnExpNode node);
    void visit(AddNode node);
    void visit(ArrayDclNode<?> node);
    void visit(BlkNode node);
    void visit(CharDclNode node);
    void visit(DivNode node);
    void visit(FloatDclNode node);
    void visit(FuncCallNode node);
    void visit(FuncNode node);
    void visit(IntegerDclNode node);
    void visit(IterativeNode node);
    void visit(LongDclNode node);
    void visit(MultNode node);
    void visit(ParamNode node);
    void visit(PinDclNode node);
    void visit(SelectionNode node);
    void visit(StmtNode node);
    void visit(SubNode node);
    void visit(LogicalNode node);
    void visit(PrintNode node);
    void visit(StringNode node);
}
