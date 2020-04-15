package com.p4.parser;

import org.antlr.v4.runtime.CommonToken;

import java.util.ArrayList;
import java.util.List;

public abstract class AstNode {
    String id;
    String type;

    List<AstNode> children = new ArrayList<>();

    public List<AstNode> getChildren() { return children; }
    public void setChildren(List<AstNode> children) { this.children = children; }

    public void accept(NodeVisitor visitor) {
        System.out.println("Visitor type: " + visitor.getClass().getName() + " and node type" + this.getClass().getName());
        visitor.visit(this);
    }
}

abstract class DclNode<T> extends AstNode {
    public DclNode(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

class IntegerDclNode extends DclNode<Integer>{
    public IntegerDclNode(String id){
        super(id);
        this.type = "integer";
    }
}

class FloatDclNode extends DclNode<Float>{
    public FloatDclNode(String id){
        super(id);
        this.type = "decimal";
    }
}

class PinDclNode extends DclNode<Integer>{
    public PinDclNode(String id){
        super(id);
        this.type = "pin";
    }
}

class LongDclNode extends DclNode<Long>{

    public LongDclNode(String id){
        super(id);
        this.type = "long";
    }
}

class CharDclNode extends DclNode<Character>{
    public CharDclNode(String id){
        super(id);
        this.type = "character";
    }
}


class IdNode extends AstNode implements Parameters{
    public IdNode(String id){
        this.id = id;
    }
    public IdNode(String id, String type){
        this.id = id;
        this.type = type;
    }
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

class ParamNode extends AstNode {

}

class AddNode extends AstNode{
    CommonToken token = new CommonToken(9);
}

class SubNode extends AstNode{
    CommonToken token = new CommonToken(10);
}

class MultNode extends AstNode{
    CommonToken token = new CommonToken(11);
}

class DivNode extends AstNode{

    CommonToken token = new CommonToken(12);

}

class AssignNode extends AstNode{
    public AssignNode(){}
}

class ArrayDclNode<T> extends DclNode<T>{
    public ArrayDclNode(String id) {
        super(id);
        this.type = "array";
    }
}

class ArrayNode extends AstNode implements Parameters{
    public ArrayNode(String id, String type){
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
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

class ArrayAssignNode extends AstNode{
    public ArrayAssignNode(){}
}

class FuncNode extends AstNode{
    String id;
    String returnType;

    public String getId() { return id; }

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
    CommonToken token = new CommonToken(29);
}

class SelectionNode extends AstNode{

}

class IterativeNode extends AstNode{

}

class FuncCallNode extends AstNode{
    //index 0 is ID, Everything that follows is parameter values
    public FuncCallNode(){}
}

class CondNode extends AstNode{
    private String operator;

    public String getOperator() { return operator; }

    public void setOperator(String operator) { this.operator = operator; }
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
