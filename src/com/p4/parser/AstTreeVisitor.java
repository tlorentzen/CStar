package com.p4.parser;

import java.util.List;

public class AstTreeVisitor {
    public void visit(int localIndent, AstNode node){
        if(node != null){
            switch (node.getClass().toString()){
                case "class com.p4.parser.CondNode":
                    this.print(localIndent, node.getClass().toString() + " with the operator: " + ((CondNode)node).getOperator());
                    break;
                case "class com.p4.parser.IntegerDclNode":
                    this.print(localIndent, node.getClass().toString() + " with the ID: " + ((IntegerDclNode)node).getId());
                    break;
                case "class com.p4.parser.FloatDclNode":
                    this.print(localIndent, node.getClass().toString() + " with the ID: " + ((FloatDclNode)node).getId());
                    break;
                case "class com.p4.parser.IntegerNode":
                    this.print(localIndent, node.getClass().toString() + " with the value: " + ((IntegerNode)node).Value + "with isNegative set to " + ((IntegerNode)node).IsNegative);
                    break;
                case "class com.p4.parser.FloatNode":
                    this.print(localIndent, node.getClass().toString() + " with the value: " + ((FloatNode)node).Value);
                    break;
                default:
                    this.print(localIndent, node.getClass().toString());
                    break;
            }

            for (AstNode childNode : node.getChildren()){
                this.visit(localIndent + 1, childNode);
            }
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
