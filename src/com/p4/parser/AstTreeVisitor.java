package com.p4.parser;

import java.util.List;

public class AstTreeVisitor {
    public void visit(int localIndent, AstNode node){
        this.print(localIndent, node.getClass().toString());

        switch (node.getClass().toString()){
            case "class com.p4.parser.CondNode":
                this.print(localIndent, ((CondNode)node).getOperator());
                break;
            default:
                break;
        }

        for (AstNode childNode : node.getChildren()){
            this.visit(localIndent + 1, childNode);
        }
    }

    private void print(int indent, String string){
        StringBuilder output = new StringBuilder();
        output.append("\t".repeat(Math.max(0, indent)));

        if(string != null){
            output = new StringBuilder(output.toString().concat(string));
        } else{
            output = new StringBuilder(output.toString().concat("null"));
        }

        System.out.println(output);
    }
}
