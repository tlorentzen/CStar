package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;
import com.p4.syntaxSemantic.Parameters;

public class IdNode extends AstNode implements Parameters {
    private String id;
    private boolean isNegative;
    private boolean analog;

    public IdNode(String id, boolean isNegative) {
        this.id = id;
        this.isNegative = isNegative;
    }

    public IdNode(String id, String type) {
        this.id = id;
        this.type = type;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
            
    public boolean getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(boolean isNegative) {
        this.isNegative = isNegative;
    }

    public boolean getIsAnalog() {
        return analog;
    }

    public void setIsAnalog(boolean analog) {
        this.analog = analog;
    }
    
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
