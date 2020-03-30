package com.p4.parser;

import java.util.List;

public abstract class AstNode {
    public void accept(Visitor vistor) {
        visitor.visit(this);
    }
}

abstract class InfixAstNode extends AstNode{
    public ExprNode Left;
    public ExprNode Right;

    public void setLeft(ExprNode left) {
        Left = left;
    }

    public void setRight(ExprNode right) {
        Right = right;
    }

    public ExprNode getLeft() {
        return Left;
    }

    public ExprNode getRight() {
        return Right;
    }

}

class IntegerDclNode extends AstNode{

}

class FloatDclNode extends AstNode{

}

class PinDclNode extends AstNode{

}

class LongDclNode extends AstNode{

}

class CharDclNode extends AstNode{

}

class ArrayNode extends AstNode implements Parameters{

}

class IdNode extends AstNode implements Parameters{

}

class IntegerNode extends AstNode implements Parameters{

}

class FloatNode extends AstNode implements Parameters{

}

class PinNode extends AstNode implements Parameters{

}

class LongNode extends AstNode implements Parameters{
    long value;
}

class CharNode extends AstNode implements Parameters{

}

class ExprNode<T> extends AstNode {
    T expr;
}

class ParamNode extends AstNode{
    List<Parameters> params;
}

class CallNode extends AstNode{
    IdNode id;
    ParamNode params;
}

class AddNode extends InfixAstNode{

}

class SubNode extends InfixAstNode{

}

class MultNode extends InfixAstNode{

}

class DivNode extends InfixAstNode{

}

class AssignNode extends InfixAstNode{

}


- FuncNode
- ExprNode (Arithm | Cond | Func)
- TypeNode
- ReturnNode
- FactorNode
- ParamNode
- BlkNode
- SelectionNode
- IterativeNode

    term: factor ( ( MULT | DIVISION ) factor )*;
    factor:	ID | val | array_call | LEFT_PAREN expr RIGHT_PAREN;

    array_assign: ARRAY ID ASSIGN_OP array_expr ;
    array_expr: LEFT_BRACE val (COMMA val)* RIGHT_BRACE ;

    func: return_type ID LEFT_PAREN param RIGHT_PAREN blk;
    param: (TYPE ID (COMMA param)*)*;
    func_call: (ID DOT)? ID LEFT_PAREN ((ID | val) (COMMA (ID | val))*)? RIGHT_PAREN;

    stmt: ( assign SEMICOLON | expr SEMICOLON | func_call SEMICOLON | selection | iterative )+;

    val: INT_LITERAL | LONG_LITERAL | FLOAT_LITERAL | CHAR_LITERAL | PIN_LITERAL ;

    array_call: ID LEFT_BRACE val RIGHT_BRACE (ASSIGN_OP val)? ;

    return_type: TYPE | VOID;
