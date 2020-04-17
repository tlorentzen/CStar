package com.p4.parser.nodes;

import com.p4.parser.Parameters;
import com.p4.parser.SemanticsVisitor;

public class IdNode extends AstNode implements Parameters {
    public String id;
    boolean IsNegative;

    public IdNode(String id, Boolean isNegative){
        this.id = id;
        this.IsNegative = isNegative;
    }

    public IdNode(String id, String type){
        this.id = id;
        this.type = type;
    }

    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
