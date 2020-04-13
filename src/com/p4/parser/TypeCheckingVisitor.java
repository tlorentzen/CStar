package com.p4.parser;

import java.util.List;

public class TypeCheckingVisitor extends CStarBaseVisitor {
    public void visit(AstNode node){
        if(node != null){
            for (AstNode childNode : node.getChildren()){
                this.visit(childNode);
            }
        }
    }
    public void visit(IntegerDclNode node){
        if(node != null){
            List<AstNode> children = node.getChildren();
            if(true){
                System.out.println("Nah");
            }
            for (AstNode childNode : node.getChildren()){
                this.visit(childNode);
            }
        }
    }
}
