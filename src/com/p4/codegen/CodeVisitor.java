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
        //Debug print Todo: delete
        //System.out.println(stringBuilder.toString());
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

        //If pin appears on the right side, either declaration or write should be performed
        if(leftChild.type.equals("pin")){
            pinValueOnLeftSide(leftChild, rightChild);
        //If pin appears on the left side, read should be performed
        } else if (rightChild.type.equals("pin")){
            pinValueOnRightSide(leftChild, rightChild);

        //If no pin is involved, generate normal assign of left child to right child
        } else{
            this.visitChild(leftChild);
            stringBuilder.append(" = ");
            this.visitChild(rightChild);
            stringBuilder.append(";\n");
        }
    }

    /**
     * Handles the assignment of a pin, conversion between the value and the actual Arduino pin number,
     * and write type.
     * @param leftChild lhs of the assignment.
     * @param rightChild rhs of the assignment.
     */
    private void pinValueOnLeftSide(AstNode leftChild, AstNode rightChild) {

        //Handles assigning a value to a pin at declaration
        if(leftChild instanceof PinDclNode){
            PinDclNode pinDclNode = (PinDclNode) leftChild;

            //Converts the value of the pin node to analog and digital pin numbers
            String pinNum = convertIntToPinValue(rightChild);

            //Declares the pin number as an int
            stringBuilder.append("int ");
            stringBuilder.append(pinDclNode.id);
            stringBuilder.append(" = ");
            visitChild(rightChild);
            stringBuilder.append(";\n");
        } else{
            //Sets the pin mode of the pin
            stringBuilder.append("pinMode(");
            visitChild(leftChild);
            stringBuilder.append(", OUTPUT);\n");

            //Handles assigning a value to a pin after declaration, by using digital or analog write.
            if(rightChild.type.equals("integer")){
                stringBuilder.append("analogWrite("); //Todo: maybe handle the value of rightChild to use digitalWrite. However, the value is not available for IdNode
            }

            //Ends the write statement with the pin and value
            this.visitChild(leftChild);
            stringBuilder.append(", ");
            this.visitChild(rightChild);
            stringBuilder.append(");\n");
        }
    }

    private String convertIntToPinValue(AstNode node) {
        return (node instanceof PinNode ? "A" + ((((PinNode) node).value * -1) - 1) : ((NumberNode) node).value.toString());
    }

    /**
     * Handles the assignment to a variable with a pin on the right side of the assignment.
     * PinMode and the correct read function is handled within this function.
     * @param leftChild lhs of the assignment.
     * @param rightChild rhs of the assignment.
     */
    private void pinValueOnRightSide(AstNode leftChild, AstNode rightChild) {
        stringBuilder.append("pinMode(");
        this.visitChild(rightChild);
        stringBuilder.append(", INPUT);\n");
        this.visitChild(leftChild);
        stringBuilder.append(" = ");
        stringBuilder.append("digitalRead("); //Todo: update
        this.visitChild(rightChild);
        stringBuilder.append(");\n");
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
        stringBuilder.append(" ");
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
        if(node.children.size() > 1){
            firstParam = node.children.get(1);
        }
        String[] funcIDSplit = ((IdNode)id).id.split("\\.");

        if(firstParam != null && funcIDSplit.length > 1){
            if(funcIDSplit[1].equals("read")){
                if(((PinAttributes)this.symbolTable.lookup(funcIDSplit[0])).analog){
                    stringBuilder.append("analogRead(");
                    stringBuilder.append(funcIDSplit[0]);
                    stringBuilder.append(")");
                } else{
                    stringBuilder.append("digitalRead(");
                    stringBuilder.append(funcIDSplit[0]);
                    stringBuilder.append(")");
                }
            }else if(funcIDSplit[1].equals("write")){
                if(node.children.get(1) instanceof NumberNode){
                    stringBuilder.append("analogWrite(");
                    stringBuilder.append(funcIDSplit[0]);
                    stringBuilder.append(",");
                    visitChild(node.children.get(1));
                } else if(node.children.get(1) instanceof IdNode){
                    if (firstParam.type.equals("integer") || firstParam.type.equals("long integer") || firstParam.type.equals("small integer") || firstParam.type.equals("character")) {
                        stringBuilder.append("analogWrite(");
                        stringBuilder.append(funcIDSplit[0]);
                        stringBuilder.append(",");
                        visitChild(node.children.get(1));
                    } else if (firstParam.type.equals("")) //Todo: finish
                        stringBuilder.append("digitalWrite(");
                        stringBuilder.append(funcIDSplit[0]);
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append(")");
        }else{
            this.visitChild(id);
            stringBuilder.append("(");

            int counter = node.children.subList( 1, node.children.size()).size();

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
     * Creates a function declaration.
     * Children are parameters and a block.
     * Format in Arduino C: void main(char argv[]){ }
     * @param node is the func node to be handled.
     */
    @Override
    public void visit(FuncDclNode node) {
        //func: return_type ID LEFT_PAREN param? RIGHT_PAREN blk; //done
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
        stringBuilder.append(" ");
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
        stringBuilder.append(" ");
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
