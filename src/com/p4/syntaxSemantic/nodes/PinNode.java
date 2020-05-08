package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class PinNode extends LiteralNode<Integer> {
    private boolean output = false;
    
    public PinNode(Integer value, boolean isNegative) {
        super(value, isNegative);
    }

    public boolean getOutput() {
        return output;
    }
    
    public void setOutput(boolean output) {
        this.output = output;
    }
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
