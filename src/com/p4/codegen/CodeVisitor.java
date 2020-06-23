package com.p4.codegen;

import com.p4.symbols.Attributes;
import com.p4.syntaxSemantic.CStarParser;
import com.p4.syntaxSemantic.nodes.*;
import com.p4.syntaxSemantic.visitors.INodeVisitor;
import com.p4.symbols.PinAttributes;
import com.p4.symbols.SymbolTable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Generates the Arduino code that corresponds to the CStar source code
public class CodeVisitor implements INodeVisitor {
    //FilePath is used to specify the location for the compiled Arduino file
    String filePath = System.getProperty("user.dir") + "/output/output.ino";
    //FilePath is used to specify the directory for the compiled Arduino file
    String dirPath = System.getProperty("user.dir") + "/output";

    //The string builder is used to construct the Arduino file
    StringBuilder stringBuilder = new StringBuilder();
    ArrayList<String> output = new ArrayList<>();
    SymbolTable symbolTable;
    int currentIndent = 0;

    public CodeVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    //Prints the content of the string builder to the file
    public void print() throws IOException {
        output.add(getLine());

        for (String line : output) {
            stringBuilder.append(line);
        }

        File directory = new File(dirPath);

        //Enters if there is not directory
        if (!directory.exists()) {
            directory.mkdirs();
        }
        //Instantiates new File object
        File file = new File(filePath);

        //Instantiates new FileOutPutStream
        FileOutputStream outputStream = new FileOutputStream(file);

        //Writes the string builder to the file,
        //If file not found, it will create one
        outputStream.write(stringBuilder.toString().getBytes());
    }

    @Override
    public void visit(ProgNode node) {
        //Visits all its children and puts a semicolon if a Dcl with no value is made in global scope
        for (AstNode child: node.children) {
            this.visitChild(child);

            //Enters if the string builder has not been reset yet
            if (stringBuilder.length() > 0) {
                char lastChar = stringBuilder.charAt(stringBuilder.length() - 1);
                boolean isSemicolonPresent = Character.toString(lastChar).matches(";");

                //Enters if the child is a declaration and a semicolon has not been added yet
               // if ((child instanceof DclNode || child instanceof InNode) && !isSemicolonPresent) {
                if (!(child instanceof CommentNode || child instanceof IncludeNode) && !isSemicolonPresent) {
                    stringBuilder.append(";\n");
                }
            }
        }
    }

    @Override
    public void visitChildren(AstNode node) {
        for (AstNode child : node.children) {
            child.accept(this);
        }
    }

    //Calls the accept method on the node given.
    public void visitChild(AstNode node) {
        node.accept(this);
    }

    //Format in Arduino C: int i;
    @Override
    public void visit(IntegerDclNode node) {
        visitDclNode(node);
    }

    //Format in Arduino C: long i;
    @Override
    public void visit(LongDclNode node) {
        visitDclNode(node);
    }

    @Override
    public void visit(SmallDclNode node) {
        visitDclNode(node);
    }

    //Format in Arduino C: float i;
    @Override
    public void visit(FloatDclNode node) {
        visitDclNode(node);
    }

    @Override
    public void visit(IncludeNode node) {
        stringBuilder.append(node.getInclude());
        stringBuilder.append("\n");
    }

    //Format in Arduino C: char i;
    @Override
    public void visit(CharDclNode node) {
        visitDclNode(node);
    }

    //Format in Arduino C: (i > 5 && i < 10);
    @Override
    public void visit(IntervalNode node) {
        //Left side of the interval
        stringBuilder.append("(");
        changeComparison(node, "]", ">", 1);
        //Sides are always connected with logical AND
        stringBuilder.append(" && ");
        //Right side of the interval
        changeComparison(node, "[", "<", 2);
        stringBuilder.append(")");
    }

    private void changeComparison(IntervalNode node, String bracketDirection, String compDirection, int childNumber) {
        if (node.getLeftBracket().equals(bracketDirection)) {
            visitChild(node.children.get(0));
            stringBuilder.append(" " + compDirection + " ");
            visitChild(node.children.get(childNumber));
        }
        else {
            visitChild(node.children.get(0));
            stringBuilder.append(" " + compDirection + "= ");
            visitChild(node.children.get(childNumber));
        }
    }

    //Format in Arduino C: int pinName;
    @Override
    public void visit(PinDclNode node) {
        stringBuilder.append("int ");
        stringBuilder.append(node.getId());
    }

    @Override
    public void visit(BooleanDclNode node) {
        visitDclNode(node);
    }

    //Format in Arduino C: int i
    public void visitDclNode(DclNode<?> node) {
        stringBuilder.append(getTargetType(node.type));
        stringBuilder.append(" ");
        stringBuilder.append(node.getId());
    }

    //Converts CStar types to Arduino C types
    private String getTargetType(String type) {
        switch (type) {
            case "integer":
            case "pin":
                return "int";
            case "decimal":
                return "float";
            case "long integer":
                return "long";
            case "character":
                return "char";
            case "small integer":
                return "byte";
            default:
                return type;
        }
    }

    //Format in Arduino C: i = 10
    @Override
    public void visit(AssignNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        //Gets the statement and adds it to the output
        this.visitChild(leftChild);
        stringBuilder.append(" = ");
        this.visitChild(rightChild);
        if (rightChild instanceof FuncCallNode){
            if(!(((IdNode)rightChild.children.get(0)).getId().contains(".read") || ((IdNode)rightChild.children.get(0)).getId().contains(".write"))){
                stringBuilder.append(";\n");
            }
        }
        else {
            stringBuilder.append(";\n");
        }
        output.add(getLine());
    }

    @Override
    public void visit(LogicalNode node) {
        checkParentheses(node, true);
        //Visits the left operand
        this.visitChild(node.children.get(0));

        //Converts the logical operator to the actual logical operator '&&' or '||'
        switch (node.getToken()) {
            case CStarParser.OR:
                stringBuilder.append(" || ");
                break;
            case CStarParser.AND:
                stringBuilder.append(" && ");
                break;
        }
        //Visits the right operand
        this.visitChild(node.children.get(1));
        checkParentheses(node, false);
    }

    @Override
    public void visit(CondNode node) {
        checkParentheses(node, true);
        //Visits the left operand
        this.visitChild(node.children.get(0));

        //Gets the correct operator
        switch (node.getToken()) {
            case CStarParser.LESS_THAN:
                stringBuilder.append(" < ");
                break;
            case CStarParser.GREATER_THAN:
                stringBuilder.append(" > ");
                break;
            case CStarParser.IS:
                stringBuilder.append(" == ");
                break;
            case CStarParser.ISNOT:
                stringBuilder.append(" != ");
                break;
            case CStarParser.LESS_THAN_EQ:
                stringBuilder.append(" <= ");
                break;
            case CStarParser.GREATER_THAN_EQ:
                stringBuilder.append(" >= ");
                break;
        }
        //Visits the right operand
        this.visitChild(node.children.get(1));
        checkParentheses(node, false);
    }

    @Override
    public void visit(InNode node) {
        //First child is a value and right side is an array
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        //Enters if the RHS is an id node
        if (rightChild instanceof IdNode) {
            appendInId(leftChild, rightChild);
        }
        //Enters if the RHS is an array expression
        else if (rightChild instanceof ArrayExprNode) {
            appendInExpr(leftChild, rightChild);
        }
    }

    //Checks if the right operand is an id
    private void appendInId(AstNode leftChild, AstNode rightChild) {
        Attributes array = symbolTable.lookupSymbol(((IdNode)rightChild).getId());

        stringBuilder.append("(");
        for (int elementIndex = 0; elementIndex < array.getArrayLength(); elementIndex++) {
            //Appends the value being compared with
            this.visitChild(leftChild);
            stringBuilder.append(" == ");
            //Appends the array id
            this.visitChild(rightChild);

            //Appends index
            stringBuilder.append("[");
            stringBuilder.append(elementIndex);
            stringBuilder.append("]");

            if (elementIndex != array.getArrayLength() - 1) {
                stringBuilder.append(" || ");
            }
        }
        stringBuilder.append(")");
    }

    //Checks if the right operand is an array expression
    private void appendInExpr(AstNode leftChild, AstNode rightChild) {
        ArrayExprNode arrayExprNode = (ArrayExprNode) rightChild;

        stringBuilder.append("(");
        for (AstNode child: arrayExprNode.children) {
            //Appends the value being compared with
            visitChild(leftChild);
            stringBuilder.append(" == ");
            //Appends the array id
            visitChild(child);
            stringBuilder.append(" || ");
        }
        //Deletes leftover " || "
        stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length());
        stringBuilder.append(")");
    }

    //Format in Arduino C: 10 + 20
    @Override
    public void visit(AddNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        checkParentheses(node, true);
        this.visitChild(leftChild);
        stringBuilder.append(" + ");
        this.visitChild(rightChild);
        checkParentheses(node, false);
    }

    //Format in Arduino C: 10 - 20
    public void visit(SubNode node) {
        //First child is left side, second is right side
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        checkParentheses(node, true);
        this.visitChild(leftChild);
        stringBuilder.append(" - ");
        this.visitChild(rightChild);
        checkParentheses(node, false);
    }

    //Format in Arduino C: 10 * 20
    @Override
    public void visit(MultNode node) {
        //First child is left side, second is right side
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        checkParentheses(node, true);
        this.visitChild(leftChild);
        stringBuilder.append(" * ");
        this.visitChild(rightChild);
        checkParentheses(node, false);
    }

    //Format in Arduino C: 10 / 20
    @Override
    public void visit(DivNode node) {
        //First child is left side, second is right side
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        checkParentheses(node, true);
        this.visitChild(leftChild);
        stringBuilder.append(" / ");
        this.visitChild(rightChild);
        checkParentheses(node, false);
    }

    @Override
    public void visit(ModNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        //Enters if there are parentheses present before the expression
        checkParentheses(node, true);

        //Adds the expression to the string builder
        this.visitChild(leftChild);
        stringBuilder.append(" % ");
        this.visitChild(rightChild);

        //Enters if there are parentheses present after the expression
        checkParentheses(node, false);
    }

    private void checkParentheses(ExpressionNode node, boolean isStart) {
        if (node.getParentheses() && isStart) {
            stringBuilder.append("(");
        }
        else if (node.getParentheses() && !isStart) {
            stringBuilder.append(")");
        }
    }

    //Format in Arduino C: int i[] = {1, 2, 3};
    @Override
    public void visit(ArrayDclNode<?> node) {
        //First child is the array ID
        visitChild(node.children.get(0));
        stringBuilder.append(" = ");
        stringBuilder.append("{");
        //Second child is the array expr (array elements)
        visitChild(node.children.get(1));
        stringBuilder.append("}");
        stringBuilder.append(";\n");
        output.add(getLine());
    }

    @Override
    public void visit(ArrayExprNode node) {
        //Visits the elements of an array and adds commas between them
        for (AstNode child : node.children) {
            visitChild(child);
            stringBuilder.append(", ");
        }

        //Deletes the extra comma and whitespace
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    //Format in Arduino C: i[0]
    @Override
    public void visit(ArrayAccessNode node) {
        if (node.getIsNegative()) {
            stringBuilder.append("-");
        }

        //Id is at index 0 and the Index is at index 1
        visitChild(node.children.get(0));
        stringBuilder.append("[");
        visitChild(node.children.get(1));
        stringBuilder.append("]");
    }

    //Format in Arduino C: int i[]
    @Override
    public void visit(ArrayNode node) {
        stringBuilder.append(getTargetType(node.type));
        stringBuilder.append(" ");
        stringBuilder.append(node.getId());
        stringBuilder.append("[]");
    }

    //Format in Arduino C: while(10 < 20){ int i = 0; }
    @Override
    public void visit(IterativeNode node) {
        stringBuilder.append("while(");
        //First child is logical expression
        this.visitChild(node.children.get(0));
        stringBuilder.append(")");
        //Second child is the block
        this.visitChild(node.children.get(1));
        stringBuilder.append('\n');
    }

    //Format in Arduino C: if(10 < 20){ int i = 0; } else { int i = 1; }
    @Override
    public void visit(SelectionNode node) {
        stringBuilder.append("if (");

        //First child is a logical expr
        this.visitChild(node.children.get(0));
        stringBuilder.append(")");
        //Second and third children are blocks
        visitChild(node.children.get(1));

        //Enters if there is an else block
        if (node.children.size() > 2) {
            stringBuilder.append("else ");
            visitChild(node.children.get(2));
        }
        stringBuilder.append('\n');
    }

    //Format in Arduino C:
    // {
    //    int i = 0;
    // }
    @Override
    public void visit(BlkNode node) {
        stringBuilder.append("{\n");
        output.add(getLine());
        currentIndent++;

        //Enters if there is a setup function and the print function is called
        if (node.getParentID().equals("setup") && symbolTable.calledFunctions.contains("Serial.println")) {
            stringBuilder.append("Serial.begin(9600);\n");
            output.add(getLine());
        }

        for (AstNode child : node.children) {
            this.visitChild(child);
            boolean isReadWrite = isReadWrite(child);

            //Enters if the child node is either a funcCallNode or inNode
            if ((child instanceof FuncCallNode && !isReadWrite)|| child instanceof InNode || child instanceof IntervalNode) {
                stringBuilder.append(";\n");
                output.add(getLine());
            }
        }
        stringBuilder.append("}\n");
        output.add(getLine());
        currentIndent--;
    }

    private boolean isReadWrite(AstNode node) {
        //Enters if there is a child
        if (node.children.size() > 0) {
            AstNode firstChild = node.children.get(0);

            //Enters if the child is an id node
            if (firstChild instanceof IdNode) {
                return ((IdNode)firstChild).getId().contains(".write") || ((IdNode)firstChild).getId().contains(".read");
            }
        }
        return false;
    }

    @Override
    public void visit(PrintNode node) {
        //Enters if there is more than one element in the format string
        if (node.getFormatString().size() > 1) {
            //Creates a print function for each element in the format string
            for (AstNode element : node.getFormatString()) {
                stringBuilder.append("Serial.print(");
                this.visitChild(element);
                stringBuilder.append(");\n");
            }
            stringBuilder.append("Serial.println()");
        }
        else {
            stringBuilder.append("Serial.println(");
            this.visitChild(node.getFormatString().get(0));
            stringBuilder.append(");\n");
        }
        output.add(getLine());
    }

    //Format in Arduino C: void main(char argv[]){ }
    @Override
    public void visit(FuncDclNode node) {
        symbolTable.enterScope(node.getNodeHash());
        stringBuilder.append('\n');
        stringBuilder.append(getTargetType(node.getReturnType()));
        stringBuilder.append(" ");
        stringBuilder.append(node.getId());

        //Enters if there are no parameters
        if (node.children.size() == 1) {
            stringBuilder.append("()");
        }
        this.visitChildren(node);
        symbolTable.leaveScope();
    }

    //Format in Arduino C: (int i, long j)
    @Override
    public void visit(ParamNode node) {
        stringBuilder.append("(");

        for (AstNode child : node.children) {
            stringBuilder.append(getTargetType(child.type)).append(" ");
            this.visitChild(child);
            stringBuilder.append(", ");
        }

        //Deletes the extra comma and whitespace
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        stringBuilder.append(")");
    }

    //Format in Arduino C: return i + 10;
    @Override
    public void visit(ReturnExpNode node) {
        stringBuilder.append("return ");
        this.visitChild(node.children.get(0));
        stringBuilder.append(";\n");
        output.add(getLine());
    }

    //Format in Arduino C: modulo(10, 20);
    @Override
    public void visit(FuncCallNode node) {
        //First child is the ID of the function, all subsequent children are parameters.
        AstNode id = node.children.get(0);
        AstNode firstParam = null;

        //Enters if there are parameters
        if (node.children.size() > 1) {
            firstParam = node.children.get(1);
        }
        if (node.getIsNegative()) {
            stringBuilder.append("-");
        }

        String[] funcIDSplit = ((IdNode)id).getId().split("\\.");

        //Checks if the string contains a '.'
        if (funcIDSplit.length > 1) {
            this.handleReadAndWrite(firstParam, funcIDSplit);
        }
        //Enters if functions are not pin read or write
        else {
            addParameters(node, id);
        }
    }

    //Handles code generation for the pin.read and pin.write functions
    private void handleReadAndWrite(AstNode parameter, String[] funcIDSplit) {
        //Enters if a read function has been called on the pin
        if (funcIDSplit[1].equals("read")) {
            appendPinModeIfNeeded(false, funcIDSplit[0]);
            appendReadWrite(funcIDSplit[0], "Read");
            stringBuilder.append(");\n");
            output.add(getLine());
        }
        //Enters if a write function has been called on the pin
        else if (parameter != null && funcIDSplit[1].equals("write")) {
            appendPinModeIfNeeded(true, funcIDSplit[0]);
            appendReadWrite(funcIDSplit[0], "Write");
            stringBuilder.append(", ");
            visitChild(parameter);
            stringBuilder.append(");\n");
            output.add(getLine());
        }
    }

    //Handles pin mode. Changes it to input or output if necessary
    private void appendPinModeIfNeeded(boolean isOutput, String pinId) {
        String id = (pinId.contains("[") ? pinId.split("\\[")[0] : pinId);
        PinAttributes pinAttr = (PinAttributes)symbolTable.lookupSymbol(id);

        //Enters if the output is not set yet
        if (isOutput != pinAttr.getIsOutput() || pinId.contains("[")) {
            String pinMode = "pinMode(" + pinId + ", " + (isOutput ? "OUTPUT" : "INPUT") + ");\n";
            output.add(pinMode.indent(currentIndent * 4));

            //Sets output to true if it is not already set to true
            pinAttr.setIsOutput(!pinAttr.getIsOutput());
            symbolTable.insertSymbol(pinId, pinAttr);
        }
    }

    //Appends either read of write functions depending on the readWrite parameter
    private void appendReadWrite(String pinId, String readWrite) {
        Attributes attributes = getPinAttribute(pinId);

        //Enters if the pin is analog
        if (((PinAttributes)attributes).getAnalog()) {
            stringBuilder.append("analog" + readWrite + "(");
        }
        //Enters if the pin is digital
        else {
            stringBuilder.append("digital" + readWrite + "(");
        }
        stringBuilder.append(pinId);
    }

    private Attributes getPinAttribute(String pinId) {
        //Checks if its an array access and then deletes the index to do lookup
        if (pinId.contains("[")) {
            String tempPinID = pinId.split("\\[")[0];
            return this.symbolTable.lookupSymbol(tempPinID);
        }
        else {
            return this.symbolTable.lookupSymbol(pinId);
        }
    }

    private void addParameters(AstNode node, AstNode id) {
        this.visitChild(id);
        stringBuilder.append("(");

        int parameterCounter = node.children.size() - 1;
        List<AstNode> parameters = node.children.subList( 1, node.children.size());

        //Adds the parameters of the function to the call
        for (AstNode parameter : parameters) {
            this.visitChild(parameter);
            parameterCounter--;

            //Enters if there are more than one parameter to be added
            if (parameterCounter > 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(")");
    }

    @Override
    public void visit(IdNode node) {
        //Enters if the id is the sleep function
        if (node.getId().equals("sleep")) {
            stringBuilder.append("delay");
        }
        else {
            //Enters if the id node is negative
            if (node.getIsNegative()) {
                stringBuilder.append("-");
            }
            stringBuilder.append(node.getId());
        }
    }

    @Override
    public void visit(NumberNode node) {
        if (node.getParentheses()) {
            stringBuilder.append("(");
        }

        stringBuilder.append(node.getIsNegative() ? "-" : "");
        stringBuilder.append(node.getValue());

        if (node.getParentheses()) {
            stringBuilder.append(")");
        }
    }

    @Override
    public void visit(FloatNode node) {
        //Checks if the node is negative
        stringBuilder.append(node.getIsNegative() ? "-" : "");
        stringBuilder.append(node.getValue());
    }

    @Override
    public void visit(CharNode node) {
        stringBuilder.append("'");
        stringBuilder.append(node.getValue());
        stringBuilder.append("'");
    }

    @Override
    public void visit(PinNode node) {
        stringBuilder.append(convertIntToPinValue(node));
    }

    private String convertIntToPinValue(AstNode node) {
        if (node instanceof PinNode) {
            return "A" + ((PinNode) node).getValue() * (-1);
        }
        else {
            return ((NumberNode) node).getValue().toString();
        }
    }

    @Override
    public void visit(BooleanNode node) {
        stringBuilder.append(node.getValue());
    }

    @Override
    public void visit(ConstantNode node) {
        stringBuilder.append(node.getValue());
    }

    @Override
    public void visit(StringNode node){
        stringBuilder.append(node.getValue());
    }

    @Override
    public void visit(CommentNode node) {
        stringBuilder.append(node.getComment());
    }

    //Gets the string from the string builder and resets string builder
    private String getLine(){
        String line = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());

        int indent = currentIndent;
        if (line.endsWith("}\n")) {
            indent--;
        }

        line = line.indent(indent * 4);
        return line;
    }
}
