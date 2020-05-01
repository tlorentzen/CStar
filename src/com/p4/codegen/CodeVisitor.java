package com.p4.codegen;
import com.p4.parser.nodes.*;
import com.p4.parser.visitors.INodeVisitor;
import com.p4.symbols.PinAttributes;
import com.p4.symbols.SymbolTable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CodeVisitor implements INodeVisitor{
    //FilePath is used to specify the location for the compiled Arduino file
    String filePath = System.getProperty("user.dir") + "/compile-out/compile-out.ino";

    //The string builder is used to construct the Arduino file
    StringBuilder stringBuilder = new StringBuilder();
    SymbolTable symbolTable;

    public CodeVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    /**
     * Prints the content of the string builder to the file.
     * @throws IOException thrown if anything doing the write fails.
     */
    public void print() throws IOException {

        //Instantiates new File object
        File f = new File(filePath);

        //Instantiates new FileOutPutStream
        FileOutputStream oS = new FileOutputStream(f);

        //Writes the string builder to the file, handling potential creation as well
        oS.write(stringBuilder.toString().getBytes());
    }

    /**
     * Visits the children of the given node.
     * @param node the node which children should be visited.
     */

    @Override
    public void visitChildren(AstNode node) {
        for(AstNode child : node.children){
            child.accept(this);
        }
    }

    /**
     * Calls the accept method on the node given.
     * @param node the node to run accept on.
     */
    public void visitChild(AstNode node) {
        node.accept(this);
    }

    /**
     * Converts the logical operator id to the actual logical operator '&&' or '||'.
     * Only handles AND and OR.
     * @param node is the logical node to be handled.
     */
    @Override
    public void visit(PrintNode node){
        if(node.formatString.size() > 1){
            for(AstNode element : node.formatString){
                stringBuilder.append("Serial.print(");
                this.visitChild(element);
                stringBuilder.append(");\n");
            }
            stringBuilder.append("Serial.println()");
        } else {
            stringBuilder.append("Serial.println(");
            this.visitChild(node.formatString.get(0));
            stringBuilder.append(");\n");
        }

    }

    @Override
    public void visit(FloatNode node){
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(ConstantNode node) {
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(ModNode node){
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        this.visitChild(leftChild);
        stringBuilder.append(" % ");
        this.visitChild(rightChild);
    }

    @Override
    public void visit(NumberNode node){
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(BooleanNode node){
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(BooleanDclNode node){
        visitDclNode(node);
    }

    @Override
    public void visit(SmallDclNode node){
        visitDclNode(node);
    }

    @Override
    public void visit(StringNode node){
        stringBuilder.append(node.value);
    }

    @Override
    public void visit(LogicalNode node){

        //Left operand
        this.visitChild(node.children.get(0));

        //Operator
        switch (node.getOperator()){
            case 6:
                stringBuilder.append(" || ");
                break;
            case 7:
                stringBuilder.append(" && ");
                break;
        }
        //Right operand
        this.visitChild(node.children.get(1));
    }

    /**
     * Adds the id of the node to the string builder.
     * @param node is the id node to be handled.
     */
    @Override
    public void visit(IdNode node) {

        switch (node.id){
            case "sleep":
                stringBuilder.append("delay");
                break;
            default:
                stringBuilder.append(node.id);
                break;
        }
    }

    /**
     * Adds the value of the node to the string builder.
     * @param node is the pin node to be handled.
     */
    @Override
    public void visit(PinNode node) {
        stringBuilder.append(convertIntToPinValue(node));
    }

    /**
     * Adds the value of the node to the string builder.
     * @param node is the char node to be handled.
     */
    @Override
    public void visit(CharNode node) {
        stringBuilder.append(node.value);
    }

    /**
     * Handles assignments and calls methods to handle pins when necessary.
     * Format in Arduino C: i = 10
     * @param node is the assign node to be handled.
     */
    @Override
    public void visit(AssignNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
            this.visitChild(leftChild);
            stringBuilder.append(" = ");
            this.visitChild(rightChild);
            stringBuilder.append(";\n");
    }

    private String convertIntToPinValue(AstNode node) {
        return (node instanceof PinNode ? "A" + ((((PinNode) node).value * -1) - 1) : ((NumberNode) node).value.toString());
    }

    /**
     * Converts the operator id to the actual logical operator '<', '>', '==', or '!='.
     * Only handles '>', '<', 'IS', and 'ISNOT'.
     * @param node is the conditional node to be handled.
     */
    @Override
    public void visit(CondNode node) {
        //Left operand
        this.visitChild(node.children.get(0));

        //Operator
        switch (node.getOperator()){
            case 2:
                stringBuilder.append(" < ");
                break;
            case 3:
                stringBuilder.append(" > ");
                break;
            case 4:
                stringBuilder.append(" == ");
                break;
            case 5:
                stringBuilder.append(" != ");
                break;
        }
        //Right operand
        this.visitChild(node.children.get(1));
    }

    /**
     * Just visits the children of the program node, as no information should be added to the generated file.
     * @param node is the program node to be handled.
     */
    @Override
    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    /**
     * Creates an array assign
     * First child is ID, second is the index value of the array, and third is the value to be assigned to.
     * Format in Arduino C: intArray[0] = 10;
     * @param node is the array assign node to be handled.
     */
    @Override
    public void visit(ArrayAccessNode node) {
        //Id is index 0, the Index is at index 1, and the assigned value is at 2
        visitChild(node.children.get(0));
        stringBuilder.append("[");
        visitChild(node.children.get(1));
        //Deletes semicolon and new line if its found
        int length = stringBuilder.length();
        if(stringBuilder.charAt( length - 2) == ';'){
            stringBuilder.delete(length -2, length);

        }
        stringBuilder.append("]");
    }

    /**
     * Creates an array expr (array elements)
     * All children are elements of an array
     * @param node is the array expr node to be handled.
     */
    @Override
    public void visit(ArrayExprNode node) {
        for(AstNode child : node.children){
            visitChild(child);
            stringBuilder.append(", ");
        }
        //Deletes leftover comma and whitespace
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }

    /**
     * The array id of an array
     * Format in Arduino C: int i[]
     * @param node is the array node to be handled.
     */
    @Override
    public void visit(ArrayNode node) {
        stringBuilder.append(getTargetType(node.type));
        stringBuilder.append(" ");
        stringBuilder.append(node.getId());
        stringBuilder.append("[]");
    }

    /**
     * Creates an array dcl
     * First child is the array ID, second is the array expr (array elements)
     * Format in Arduino C: int i[] = {1, 2, 3};
     * @param node is the array dcl node to be handled.
     */
    @Override
    public void visit(ArrayDclNode<?> node) {
        visitChild(node.children.get(0));
        stringBuilder.append(" = ");
        stringBuilder.append("{");
        visitChild(node.children.get(1));
        stringBuilder.append("}");
        stringBuilder.append(";\n");
    }

    /**
     * Creates an return expr
     * Format in Arduino C: return i + 10;
     * @param node is the return expr node to be handled.
     */
    @Override
    public void visit(ReturnExpNode node) {
        stringBuilder.append("return ");
        this.visitChild(node.children.get(0));
        stringBuilder.append(";\n");
    }

    /**
     * Creates an add operation.
     * First child is left side, second is right side
     * Format in Arduion C: 10 + 20
     * @param node is the add node to be handled.
     */
    @Override
    public void visit(AddNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
        this.visitChild(leftChild);
        stringBuilder.append(" + ");
        this.visitChild(rightChild);
    }

    /**
     * Creates a block with all its children
     * Format in Arduino C:
     * {
     *     int i = 0;
     * }
     * @param node is the blk node to be handled.
     */
    @Override
    public void visit(BlkNode node) {

        stringBuilder.append("{\n");
        for(AstNode child : node.children){
            stringBuilder.append("    ");
            this.visitChild(child);
            if(child.getClass().getName().equals("com.p4.parser.nodes.FuncCallNode")){
                stringBuilder.append(";\n");
            }
        }

        stringBuilder.append("\n}\n");
    }

    /**
     * Creates a char declaration
     * Format in Arduino C: char i;
     * @param node is the char node to be handled.
     */
    @Override
    public void visit(CharDclNode node) {
        visitDclNode(node);
    }

    /**
     * Creates a division operation.
     * First child is left side, second is right side
     * Format in Arduion C: 10 / 20
     * @param node is the division node to be handled.
     */
    @Override
    public void visit(DivNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
        this.visitChild(leftChild);
        stringBuilder.append(" / ");
        this.visitChild(rightChild);
    }

    /**
     * Creates a float declaration
     * Format in Arduino C: float i;
     * @param node is the float node to be handled.
     */
    @Override
    public void visit(FloatDclNode node) {
        visitDclNode(node);
    }

    /**
     * Creates a function call. First child is the ID, all subsequent children are parameters.
     * Format in Arduino C: modulo(10, 20);
     * @param node is the func call node to be handled.
     */
    @Override
    public void visit(FuncCallNode node) {

        AstNode id = node.children.get(0);
        AstNode firstParam = null;

        //Checks if the node has more than 1 child and sets the second child it as the first parameter,
        //as the first child is the ID of the node
        if(node.children.size() > 1){
            firstParam = node.children.get(1);
        }

        //Splits the function ID on '.' to check for read and write functions
        String[] funcIDSplit = ((IdNode)id).id.split("\\.");

        //Checks if the string contained a '.'
        if(funcIDSplit.length > 1){
            this.handlePinReadAndWrite(firstParam, funcIDSplit);
        }else{
            //Handle functions that are not pin read or write
            this.visitChild(id);
            stringBuilder.append("(");

            //Adds the parameters of the function to the call
            int counter = node.children.size() - 1;
            for(AstNode child : node.children.subList( 1, node.children.size())){
                this.visitChild(child);
                counter--;
                if(counter > 0){
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(")");
        }
    }

    /**
     * Handles code generation for the pin.read and pin.write functions
     * @param firstParam the first parameter of the function call
     * @param funcIDSplit the ID of the function split on '.' into an array
     */
    private void handlePinReadAndWrite(AstNode firstParam, String[] funcIDSplit) {
        if(funcIDSplit[1].equals("read")){
            //The call is assumed to be a pin read
            if(((PinAttributes)this.symbolTable.lookup(funcIDSplit[0])).analog){
                //The pin is instantiated as an analog pin
                stringBuilder.append("analogRead(");
                stringBuilder.append(funcIDSplit[0]);
            } else{
                //The pin is instantiated as a digital pin
                stringBuilder.append("digitalRead(");
                stringBuilder.append(funcIDSplit[0]);
            }
        }else if(firstParam != null && funcIDSplit[1].equals("write")){
            //The call is assumed to be a pin write
            if(firstParam instanceof NumberNode
                    || (firstParam instanceof IdNode
                    && (firstParam.type.equals("integer")
                    || firstParam.type.equals("long integer")
                    || firstParam.type.equals("small integer")
                    || firstParam.type.equals("character")
                    || firstParam.type.equals("Arduino C")))) {
                //The value to be written to the pin could be any number
                stringBuilder.append("analogWrite(");
                stringBuilder.append(funcIDSplit[0]);
                stringBuilder.append(",");
                visitChild(firstParam);
            } else if (firstParam.type.equals("constant")){
                //The value to be written to the pin is either HIGH or LOW
                stringBuilder.append("digitalWrite(");
                stringBuilder.append(funcIDSplit[0]);
                stringBuilder.append(",");
                visitChild(firstParam);
            }
        }
        stringBuilder.append(")");
    }

    /**
     * Creates a function declaration.
     * Children are parameters and a block.
     * Format in Arduino C: void main(char argv[]){ }
     * @param node is the func node to be handled.
     */
    @Override
    public void visit(FuncDclNode node) {
        stringBuilder.append(node.returnType);
        stringBuilder.append(" ");
        stringBuilder.append(node.id);
        if(node.children.size() == 1){
            stringBuilder.append("()");
        }
        this.visitChildren(node);
    }

    /**
     * Creates an integer declaration
     * Format in Arduino C: int i;
     * @param node is the integer node to be handled.
     */
    @Override
    public void visit(IntegerDclNode node) {
        visitDclNode(node);
    }

    /**
     * Creates an iterative while loop
     * First child is logical expression, second is a block.
     * Format in Arduino C: while(10 < 20){ int i = 0; }
     * @param node is the iterative node to be handled.
     */
    @Override
    public void visit(IterativeNode node) {
        stringBuilder.append("while(");
        this.visitChild(node.children.get(0));
        stringBuilder.append(")");
        this.visitChild(node.children.get(1));
    }

    /**
     * Creates a long declaration
     * Format in Arduino C: long i;
     * @param node is the long dcl node to be handled.
     */
    @Override
    public void visit(LongDclNode node) {
        visitDclNode(node);
    }

    /**
     * Creates a multiply operation
     * First child is left side, second is right side
     * Format in Arduino C: 10 * 20
     * @param node is the return expr node to be handled.
     */
    @Override
    public void visit(MultNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
        this.visitChild(leftChild);
        stringBuilder.append(" * ");
        this.visitChild(rightChild);
    }

    /**
     * Creates parameters for functions
     * All children are different parameters.
     * Format in Arduino C: void main(int i, long j){ }
     * @param node is the parameter node to be handled.
     */
    @Override
    public void visit(ParamNode node) {
        stringBuilder.append("(");
        for(AstNode child : node.children){
            stringBuilder.append(getTargetType(child.type)).append(" ");
            this.visitChild(child);
            stringBuilder.append(", ");
        }
        //Deletes leftover comma and whitespace
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(")");
    }

    /**
     * Makes a pin declaration.
     * Format in Arduino C: int pinName;
     * @param node is the pin dcl node to be handled.
     */
    @Override
    public void visit(PinDclNode node) {
        stringBuilder.append("int ");
        stringBuilder.append(node.id);
    }

    /**
     * Creates a selection if else.
     * First child is a logical expr, second is a block, third is also a block
     * Format in Arduino C: if(10 < 20){ int i = 0; } else { int i = 1; }
     * @param node is the selection node to be handled.
     */
    @Override
    public void visit(SelectionNode node) {
        stringBuilder.append("if(");
        this.visitChild(node.children.get(0));
        stringBuilder.append(")");
        visitChild(node.children.get(1));
        if(node.children.size() > 2){
            stringBuilder.append("else");
            visitChild(node.children.get(2));
        }
    }

    /**
     * Creates a subtraction operation
     * First child is left side, second is right side
     * Format in Arduino C: 10 - 20
     * @param node is the subtraction node to be handled.
     */
    @Override
    public void visit(SubNode node) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
        this.visitChild(leftChild);
        stringBuilder.append(" - ");
        this.visitChild(rightChild);
    }

    /**
     * Makes a general declaration for types.
     * Format in Ardunio C: int i
     * @param node is the dcl node to be handled.
     */
    public void visitDclNode(DclNode<?> node){
        stringBuilder.append(getTargetType(node.type));
        stringBuilder.append(" ");
        stringBuilder.append(node.id);
    }

    /**
     * Converts CStar types to Arduino C types
     * @param type is the CStar type
     * @return Arduino C type
     */
    private String getTargetType(String type){
        switch (type){
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
}
