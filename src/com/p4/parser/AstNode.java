package com.p4.parser;

import java.util.List;

public abstract class AstNode {
    /*
    public void accept(Visitor vistor) {
        visitor.visit(this);
    }
    */
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
    String id;
    String type = "Integer";
    int value;

    public IntegerDclNode(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class FloatDclNode extends AstNode{
    String id;
    String type = "Float";
    float value;

    public FloatDclNode(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

class PinDclNode extends AstNode{
    String id;
    String type = "Pin";
    int value;

    public PinDclNode(String id){
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

class LongDclNode extends AstNode{
    long value;
    String type = "Long";
    String id;
    
    public LongDclNode(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public long getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

class CharDclNode extends AstNode{
    String id;
    String type = "Char";
    char value;

    public CharDclNode(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public char getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(char value) {
        this.value = value;
    }
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

class AssignNode extends AstNode{
    //Venstre side ID node
    //Hoejre side er en expr nod
    String Left;
    AstNode Right;
    AstNode DclNode;

    public AssignNode(String left, AstNode right){
        Left = left;
        Right = right;
    }

    public AssignNode(AstNode dclNode, AstNode right){
        DclNode = dclNode;
        Right = right;
    }

    public void setLeft(String left) {
        Left = left;
    }

    public void setRight(AstNode right) {
        Right = right;
    }

    public String getLeft() {
        return Left;
    }

    public AstNode getRight() {
        return Right;
    }

    public void setDclNode(AstNode dclNode) {
        DclNode = dclNode;
    }

    public AstNode getDclNode() {
        return DclNode;
    }


}

/*
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
*/
