package com.p4.symbols;

public class PinAttributes extends Attributes {
    private boolean analog;
    private boolean isOutput = false;

    public PinAttributes (String kind, String variableType) {
        super(kind, variableType);
    }

    public PinAttributes (String kind, String variableType, int length) {
        super(kind, variableType, length);
    }

    public boolean getAnalog() {
        return analog;
    }

    public void setAnalog(boolean analog) {
        this.analog = analog;
    }

    public boolean getIsOutput() {
        return isOutput;
    }

    public void setIsOutput(boolean isOutput) {
        this.isOutput = isOutput;
    }
}
