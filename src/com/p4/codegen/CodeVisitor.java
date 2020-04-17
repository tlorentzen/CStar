package com.p4.codegen;

import com.p4.parser.nodes.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.p4.parser.nodes.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.p4.parser.*;

public class CodeVisitor implements INodeVisitor{
    String filePath = System.getProperty("user.home") + "\\Desktop\\test.ino";
    StringBuilder stringBuilder = new StringBuilder();


    public void print() throws IOException {
        File f = new File(filePath);
        FileWriter fileWriter;
        if(!f.exists()){
            f.createNewFile();
            fileWriter = new FileWriter(filePath);
        }
        else{
            fileWriter = new FileWriter(filePath);
        }
        StringBuilder output = new StringBuilder();

        if(stringBuilder != null){
            output = new StringBuilder(output.toString().concat(stringBuilder.toString()));
        } else{
            output = new StringBuilder(output.toString().concat("null"));
        }

        String outputString = output.toString();
        fileWriter.write(outputString);
        System.out.println(output);
    }

    @Override
    public void visitChildren(AstNode node) {
        for(AstNode child : node.children){
            child.accept(this);
        }
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

    }

    @Override
    public void visit(FloatNode node) {

    }

    @Override
    public void visit(PinNode node) {

    }

    @Override
    public void visit(LongNode node) {

    }

    @Override
    public void visit(CharNode node) {

    }

    @Override
    public void visit(AssignNode node) {

    }

    @Override
    public void visit(CondNode node) {

    }

    @Override
    public void visit(ProgNode node) {
        this.visitChildren(node);
        //this.print();
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void visit(ArrayAssignNode node) {

    }

    @Override
    public void visit(ArrayExprNode node) {

    }

    @Override
    public void visit(ArrayNode node) {

    }

    @Override
    public void visit(ReturnExpNode node) {

    }

    @Override
    public void visit(AddNode node) {

    }

    @Override
    public void visit(ArrayDclNode<?> node) {

    }

    @Override
    public void visit(BlkNode node) {
        //blk: LEFT_BRACE ( dcl | stmt | return_exp)* RIGHT_BRACE;
        stringBuilder.append("{");
        this.visitChildren(node);
        stringBuilder.append("}");
    }

    @Override
    public void visit(CharDclNode node) {

    }

    @Override
    public void visit(DivNode node) {

    }

    @Override
    public void visit(FloatDclNode node) {

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
        stringBuilder.append(node.type);
        stringBuilder.append(node.id);
        stringBuilder.append(";");
    }

    @Override
    public void visit(IterativeNode iterativeNode) {

    }

    @Override
    public void visit(LongDclNode longDclNode) {

    }

    @Override
    public void visit(MultNode multNode) {

    }

    @Override
    public void visit(ParamNode paramNode) {
        this.visitChildren(paramNode);
    }

    @Override
    public void visit(PinDclNode pinDclNode) {

    }

    @Override
    public void visit(SelectionNode selectionNode) {

    }

    @Override
    public void visit(StmtNode stmtNode) {

    }

    @Override
    public void visit(SubNode subNode) {

    }
}

