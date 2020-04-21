package com.p4.codegen;

import com.p4.parser.INodeVisitor;
import com.p4.parser.nodes.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeVisitor implements INodeVisitor{
    String filePath = System.getProperty("user.home") + "\\Desktop\\test.ino";
    StringBuilder stringBuilder = new StringBuilder();


    public void print() throws IOException {
        File f = new File(filePath);
        FileWriter fileWriter;
        BufferedWriter writer = null;
        if(!f.exists()){
            //f.createNewFile();
            //fileWriter = new FileWriter(filePath);
            writer = new BufferedWriter(new FileWriter(filePath));
        }
        else{
            writer = new BufferedWriter(new FileWriter(filePath));
            //fileWriter = new FileWriter(filePath);
        }
        StringBuilder output = new StringBuilder();

        if(stringBuilder != null){
            output = new StringBuilder(output.toString().concat(stringBuilder.toString()));
        } else{
            output = new StringBuilder(output.toString().concat("null"));
        }

        String outputString = output.toString();
        writer.append(outputString);
        System.out.println(output);
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
        if(node.type != null){
            stringBuilder.append(node.type);
        }
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
        visitChild(node.children.get(0));
        stringBuilder.append("=");
        visitChild(node.children.get(1));
    }

    @Override
    public void visit(CondNode node) {

    }

    @Override
    public void visit(ProgNode node) {
        this.visitChildren(node);
        try {
            this.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(ArrayAssignNode node) {
        //Id is index 0, the Index is at index 1, and the assigned value is at 2
        visitChild(node.children.get(0));
        stringBuilder.append("[");
        visitChild(node.children.get(1));
        stringBuilder.append("] = ");
        visitChild(node.children.get(2));
    }

    @Override
    public void visit(ArrayExprNode node) {

        for(AstNode child : node.children){
            visitChild(child);
            stringBuilder.append(",");
        }
        //Deletes leftover comma
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

    }

    @Override
    public void visit(ArrayNode node) {
        stringBuilder.append(node.type);
        stringBuilder.append(node.getId());
        stringBuilder.append("[]");
    }

    @Override
    public void visit(ArrayDclNode<?> node) {
        //int ledPins[] = {2, 7, 4, 6, 5, 3}; Arduino c
        visitChild(node.children.get(0));
        stringBuilder.append("=");
        stringBuilder.append("{");
        visitChild(node.children.get(1));
        stringBuilder.append("}");

    }

    @Override
    public void visit(ReturnExpNode node) {
        stringBuilder.append("return ");
        this.visitChild(node.children.get(0));
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
            stringBuilder.append(";\n");
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

    }

    @Override
    public void visit(FuncNode node) {
        //func: return_type ID LEFT_PAREN param? RIGHT_PAREN blk; //done
        stringBuilder.append(node.returnType);
        stringBuilder.append(node.id);

        this.visitChildren(node);
    }

    @Override
    public void visit(IntegerDclNode node) {
        visitDclNode(node);
    }

    @Override
    public void visit(IterativeNode node) {

    }

    @Override
    public void visit(LongDclNode node) {
        visitDclNode(node);
    }

    @Override
    public void visit(MultNode node) {

    }

    @Override
    public void visit(ParamNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PinDclNode node) {

    }

    @Override
    public void visit(SelectionNode node) {

    }

    @Override
    public void visit(StmtNode node) {
        visitChildren(node);
    }

    @Override
    public void visit(SubNode node) {

    }

    public void visitDclNode(DclNode node){
        stringBuilder.append(node.type);
        stringBuilder.append(node.id);
    }
}

