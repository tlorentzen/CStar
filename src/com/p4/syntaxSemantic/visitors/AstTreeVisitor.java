package com.p4.syntaxSemantic.visitors;

import com.p4.syntaxSemantic.nodes.*;

public class AstTreeVisitor {
    public void visit(int localIndent, AstNode node){
        if(node != null){
            switch (node.getClass().toString()){
                case "class com.p4.syntaxSemantic.nodes.CondNode":
                    this.print(localIndent, node.getClass().toString() + " with the operator: " + ((CondNode)node).getToken());
                    break;
                case "class com.p4.syntaxSemantic.nodes.LogicalNode":
                    this.print(localIndent, node.getClass().toString() + " with the operator: " + ((LogicalNode)node).getToken());
                    break;
                case "class com.p4.syntaxSemantic.nodes.IntegerDclNode":
                    this.print(localIndent, node.getClass().toString() + " with the ID: " + ((IntegerDclNode)node).getId());
                    break;
                case "class com.p4.syntaxSemantic.nodes.FloatDclNode":
                    this.print(localIndent, node.getClass().toString() + " with the ID: " + ((FloatDclNode)node).getId());
                    break;
                case "class com.p4.syntaxSemantic.nodes.IntegerNode":
                    this.print(localIndent, node.getClass().toString() + " with the value: " + ((NumberNode)node).getValue());
                    break;
                case "class com.p4.syntaxSemantic.nodes.FloatNode":
                    this.print(localIndent, node.getClass().toString() + " with the value: " + ((FloatNode)node).getValue());
                    break;
                case "class com.p4.syntaxSemantic.nodes.IdNode":
                    this.print(localIndent, node.getClass().toString() + " with the name: " + ((IdNode)node).getId());
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
