package com.p4.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public abstract class AstNode {
    String type;
    /*
    public void accept(Visitor vistor) {
        visitor.visit(this);
    }
    */
}

abstract class DclNode<T> extends AstNode {
    String id;
    String type;
    T value;

    public DclNode(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public T getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

abstract class LiteralNode<T> extends AstNode{
    T Value;
    public LiteralNode(T value){
        Value = value;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T value) {
        Value = value;
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

class IntegerDclNode extends DclNode<Integer>{
    public IntegerDclNode(String id){
        super(id);
        super.type = "Float";
    }
}

class FloatDclNode extends DclNode<Float>{
    public FloatDclNode(String id){
        super(id);
        super.type = "Float";
    }
}

class PinDclNode extends DclNode<Integer>{
    public PinDclNode(String id){
        super(id);
        super.type = "Pin";
    }
}

class LongDclNode extends DclNode<Long>{

    public LongDclNode(String id){
        super(id);
        super.type = "Long";
    }
}

class CharDclNode extends DclNode<Character>{
    public CharDclNode(String id){
        super(id);
        super.type = "Char";
    }
}


class IdNode extends AstNode implements Parameters{

}

class IntegerNode extends LiteralNode<Integer>{
    public IntegerNode(Integer value){
        super(value);
    }
}

class FloatNode extends LiteralNode<Float>{
    public FloatNode(Float value){
        super(value);
    }
}

class PinNode extends LiteralNode<Integer>{
    public PinNode(Integer value){
        super(value);
    }
}

class LongNode extends LiteralNode<Long>{
    public LongNode(Long value){
        super(value);
    }
}

class CharNode extends LiteralNode<Character>{
    public CharNode(char value){
        super(value);
    }
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

    public AddNode(AstNode Left, AstNode Right){
        super.Left = Left;
        super.Right = Right;
    }

    @Override
    public void setLeft(AstNode left) {
        super.setLeft(left);
    }

    @Override
    public void setRight(AstNode right) {
        super.setRight(right);
    }

    @Override
    public AstNode getLeft() {
        return super.getLeft();
    }

    @Override
    public AstNode getRight() {
        return super.getRight();
    }
}

class SubNode extends InfixAstNode{


    SubNode(AstNode Left, AstNode Right){
        super.Left = Left;
        super.Right = Right;
    }

    @Override
    public void setLeft(AstNode left) {
        super.setLeft(left);
    }

    @Override
    public void setRight(AstNode right) {
        super.setRight(right);
    }

    @Override
    public AstNode getLeft() {
        return super.getLeft();
    }

    @Override
    public AstNode getRight() {
        return super.getRight();
    }
}

class MultNode extends InfixAstNode{

    MultNode(AstNode Left, AstNode Right){
        super.Left = Left;
        super.Right = Right;
    }

    @Override
    public void setLeft(AstNode left) {
        super.setLeft(left);
    }

    @Override
    public void setRight(AstNode right) {
        super.setRight(right);
    }

    @Override
    public AstNode getLeft() {
        return super.getLeft();
    }

    @Override
    public AstNode getRight() {
        return super.getRight();
    }
}

class DivNode extends InfixAstNode{

    DivNode(AstNode Left, AstNode Right){
        super.Left = Left;
        super.Right = Right;
    }

    @Override
    public void setLeft(AstNode left) {
        super.setLeft(left);
    }

    @Override
    public void setRight(AstNode right) {
        super.setRight(right);
    }

    @Override
    public AstNode getLeft() {
        return super.getLeft();
    }

    @Override
    public AstNode getRight() {
        return super.getRight();
    }
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

class ArrayAssignNode extends AstNode{
    //Left side is the array node
    //Right side is the array expression node
    AstNode ArrayExprNode;
    AstNode ArrayNode;

    public ArrayAssignNode(AstNode arrayNode, AstNode arrayExprNode){
        ArrayNode = arrayNode;
        ArrayExprNode = arrayExprNode;
    }

    public AstNode getArrayExprNode() {
        return ArrayExprNode;
    }

    public AstNode getArrayNode() {
        return ArrayNode;
    }

    public void setArrayExprNode(AstNode arrayExprNode) {
        ArrayExprNode = arrayExprNode;
    }

    public void setArrayNode(AstNode arrayNode) {
        ArrayNode = arrayNode;
    }
}

class ArrayNode extends AstNode implements Parameters{
    String Id;
    String Type;

    public ArrayNode(String id, String type){
        Id = id;
        Type = type;
    }

    public String getId() {
        return Id;
    }

    public String getType() {
        return Type;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setType(String type) {
        Type = type;
    }
}

class ArrayExprNode extends AstNode{
    public List<AstNode> Literals;

    public ArrayExprNode(){
        List<AstNode> Literals = new ArrayList<AstNode>();
    }

    public List<AstNode> getLiterals() {
        return Literals;
    }

    public void setLiterals(List<AstNode> literals) {
        Literals = literals;
    }
}

class FuncNode extends AstNode{
    String id;
    String returnType;
    ParamNode paramNode;
    BlkNode blkNode;

    public String getId() {
        return id;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}

class BlkNode extends AstNode{
    //blk: LEFT_BRACE ( dcl | stmt | return_exp)* RIGHT_BRACE;
}

class StmtNode extends AstNode{
    // stmt: ( assign SEMICOLON | expr SEMICOLON | func_call SEMICOLON | selection | iterative )+;
}

class ReturnExpNode extends AstNode{

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
