package com.p4.codegen;

import com.p4.parser.INodeVisitor;
import com.p4.parser.nodes.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeVisitor implements INodeVisitor{
    String filePath = System.getProperty("user.home") + "\\Desktop\\test.ino";
    StringBuilder stringBuilder = new StringBuilder();
    private Map<String, Boolean> pinDeclared = new HashMap<>();

    public void print() throws IOException {
        File f = new File(filePath);
        FileOutputStream oS = new FileOutputStream(f);
        oS.write(stringBuilder.toString().getBytes());
        //Debug print
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void visitChildren(AstNode node) {
        for(AstNode child : node.children){
            child.accept(this);
        }
    }

    public void visitChild(AstNode node) {
        node.accept(this);
    }

    @Override
    public void visit(IdNode node) {
        stringBuilder.append(node.id);
    }

    @Override
    public void visit(IntegerNode node) {
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(FloatNode node) {
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(PinNode node) {
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(LongNode node) {
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(CharNode node) {
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(AssignNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
        leftChild.type = "pin";
        if(leftChild.type.equals("pin")){
            if(leftChild instanceof PinDclNode pinDclNode){
                String pinNum = (rightChild instanceof PinNode ? "A" + ((((PinNode) rightChild).value * -1) - 1) : ((IntegerNode) rightChild).value.toString());
                stringBuilder.append("int ").append(pinDclNode.id);
                stringBuilder.append(" = ");
                stringBuilder.append(pinNum);
                stringBuilder.append(";\n");
            } else{
                if(true){
                    stringBuilder.append("analogWrite(");
                } else{
                    stringBuilder.append("digitalWrite(");
                }
                this.visitChild(leftChild);
                stringBuilder.append(", ");
                this.visitChild(rightChild);
                stringBuilder.append(");\n");
            }
        } else{
            this.visitChild(leftChild);
            stringBuilder.append(" = ");
            this.visitChild(rightChild);
            stringBuilder.append(";\n");
        }
    }

    @Override
    public void visit(CondNode node) {
        this.visitChild(node.children.get(0));
        switch (node.getOperator()){
            case 2:
                stringBuilder.append(" < ");
                break;
            case 3:
                stringBuilder.append(" > ");
                break;
            case 4:
                stringBuilder.append(" == ");
                break;
            case 5:
                stringBuilder.append(" != ");
                break;
            case 6:
                stringBuilder.append(" || ");
                break;
            case 7:
                stringBuilder.append(" && ");
                break;
        }
        this.visitChild(node.children.get(1));
    }

    @Override
    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayAssignNode node) {
        //Id is index 0, the Index is at index 1, and the assigned value is at 2
        visitChild(node.children.get(0));
        stringBuilder.append("[");
        visitChild(node.children.get(1));
        stringBuilder.append("] = ");
        visitChild(node.children.get(2));
        stringBuilder.append(";\n");
    }

    @Override
    public void visit(ArrayExprNode node) {

        for(AstNode child : node.children){
            visitChild(child);
            stringBuilder.append(", ");
        }
        //Deletes leftover comma and whitespace
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);


    }

    @Override
    public void visit(ArrayNode node) {
        stringBuilder.append(node.type);
        stringBuilder.append(" ");
        stringBuilder.append(node.getId());
        stringBuilder.append("[]");
    }

    @Override
    public void visit(ArrayDclNode<?> node) {
        visitChild(node.children.get(0));
        stringBuilder.append(" = ");
        stringBuilder.append("{");
        visitChild(node.children.get(1));
        stringBuilder.append("}");
        stringBuilder.append(";\n");

    }

    @Override
    public void visit(ReturnExpNode node) {
        stringBuilder.append("return ");
        this.visitChild(node.children.get(0));
        stringBuilder.append(";\n");
    }

    @Override
    public void visit(AddNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
        this.visitChild(leftChild);
        stringBuilder.append(" + ");
        this.visitChild(rightChild);
    }

    @Override
    public void visit(BlkNode node) {
        //blk: LEFT_BRACE ( dcl | stmt | return_exp)* RIGHT_BRACE;
        stringBuilder.append("{\n");
        for(AstNode child : node.children){
            this.visitChild(child);
        }

        stringBuilder.append("\n}\n");
    }

    @Override
    public void visit(CharDclNode node) {
        visitDclNode(node);
    }

    @Override
    public void visit(DivNode node) {
        AstNode leftChild = node.children.get(0);
        stringBuilder.append(" ");
        AstNode rightChild = node.children.get(1);
        this.visitChild(leftChild);
        stringBuilder.append(" / ");
        this.visitChild(rightChild);
    }

    @Override
    public void visit(FloatDclNode node) {
        visitDclNode(node);
    }

    @Override
    public void visit(FuncCallNode node) {
        AstNode id = node.children.get(0);
        this.visitChild(id);
        stringBuilder.append("(");

        for(AstNode child : node.children.subList( 1, node.children.size() )){
            this.visitChild(child);
            stringBuilder.append(", ");
        }
        //Deletes leftover comma and whitespace
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(");\n");
    }

    @Override
    public void visit(FuncNode node) {
        //func: return_type ID LEFT_PAREN param? RIGHT_PAREN blk; //done
        stringBuilder.append(node.returnType);
        stringBuilder.append(" ");
        stringBuilder.append(node.id);
        this.visitChildren(node);
    }

    @Override
    public void visit(IntegerDclNode node) {
        visitDclNode(node);
    }

    @Override
    public void visit(IterativeNode node) {
        stringBuilder.append("while(");
        this.visitChild(node.children.get(0));
        stringBuilder.append(")");
        this.visitChild(node.children.get(1));
    }

    @Override
    public void visit(LongDclNode node) {
        visitDclNode(node);
    }

    @Override
    public void visit(MultNode node) {
        AstNode leftChild = node.children.get(0);
        stringBuilder.append(" ");
        AstNode rightChild = node.children.get(1);
        this.visitChild(leftChild);
        stringBuilder.append(" * ");
        this.visitChild(rightChild);
    }

    @Override
    public void visit(ParamNode node) {
        stringBuilder.append("(");
        for(AstNode child : node.children){
            stringBuilder.append(child.type).append(" ");
            this.visitChild(child);
            stringBuilder.append(", ");
        }
        //Deletes leftover comma and whitespace
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(")");
    }

    @Override
    public void visit(PinDclNode node) {
        stringBuilder.append("int ");
        stringBuilder.append(node.id);
    }

    @Override
    public void visit(SelectionNode node) {
        stringBuilder.append("if(");
        this.visitChild(node.children.get(0));
        stringBuilder.append(")");
        visitChild(node.children.get(1));
        if(node.children.size() > 2){
            stringBuilder.append("else");
            visitChild(node.children.get(2));
        }
    }

    @Override
    public void visit(StmtNode node) {
        visitChildren(node);
        stringBuilder.append(";\n");
    }

    @Override
    public void visit(SubNode node) {
        AstNode leftChild = node.children.get(0);
        stringBuilder.append(" ");
        AstNode rightChild = node.children.get(1);
        this.visitChild(leftChild);
        stringBuilder.append(" - ");
        this.visitChild(rightChild);
    }

    public void visitDclNode(DclNode<?> node){
        stringBuilder.append(node.type);
        stringBuilder.append(" ");
        stringBuilder.append(node.id);
    }
}

