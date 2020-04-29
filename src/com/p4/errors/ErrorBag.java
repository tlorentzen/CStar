package com.p4.errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorBag {
    private static String OS = System.getProperty("os.name").toLowerCase();
    private List<Item> errors = new ArrayList<>();
    private boolean hasErrors = false;

    public void addEntry(ErrorType type, String message){
        this.addEntry(type, message, 0, 0);
    }

    public void addEntry(ErrorType type, String message, int lineNumber){
        this.addEntry(type, message, lineNumber, 0);
    }

    public void addEntry(ErrorType type, String message, int lineNumber, int column){
        List<String> lines = new ArrayList<>();
        this.addEntry(type, message, lineNumber, column, lines);

        if(type.toString().startsWith("E")){
            hasErrors = true;
        }
    }

    public void addEntry(ErrorType type, String message, int lineNumber, int column, List<String> lines){
        boolean shouldBeAdded = true;

        if(type == ErrorType.UNDECLARED_FUNCTION_WARNING){
            String calledFunction = message.split("'", 3)[1];

            for (Item error: errors) {
                if(error.type == ErrorType.UNDECLARED_FUNCTION_WARNING && calledFunction.equals(error.message.split("'", 3)[1])){
                    shouldBeAdded = false;
                    //Todo: possibly add additional line numbers
                    break;
                }
            }
        } if(shouldBeAdded){
            this.errors.add(new Item(type, message, lineNumber, column, lines));

            if(type.toString().startsWith("E")){
                hasErrors = true;
            }
        }
    }

    public boolean isEmpty(){
        return this.errors.isEmpty();
    }

    public void display(){
        if(!isEmpty()){
            boolean displayColors = !(OS.contains("win") && System.console() != null);

            System.out.println("Something went wrong... Found "+errors.size()+ " errors");
            System.out.println("-----------------------");

            for (Item item : errors) {
                if(displayColors){
                    System.out.print(getColor(item.type.toString()));
                    System.out.print(item.type);
                    System.out.print(Color.RESET);
                    System.out.print(": "+item.message+" ("+item.type.name()+")");
                    System.out.print(item.lineNumber > 0 ? " on line "+item.lineNumber+"\n" : "\n");
                }else{
                    System.out.println(item.type.toString()+": "+item.message+" ("+item.type.name()+")" + (item.lineNumber > 0 ? " on line "+item.lineNumber : ""));
                }

                if(item.lines.size() > 0){
                    String indent = " ".repeat(item.type.toString().length());
                    for (String line : item.lines){
                        if(line.trim().length() > 0){
                            System.out.println(indent+"| "+line);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    private Color getColor(String code){
        if(code.startsWith("E")){
            return Color.RED_BOLD;
        }else if(code.startsWith("W")){
            return Color.YELLOW_BOLD;
        }else if(code.startsWith("I")){
            return Color.BLUE_BOLD;
        }

        return Color.WHITE;
    }

    public boolean containsErrors(){
        return hasErrors;
    }
}

class Item{
    ErrorType type;
    String message;
    int lineNumber = 0;
    int column = 0;
    List<String> lines;

    public Item(ErrorType type, String message, int lineNumber, List<String> lines){
        this(type, message, lineNumber, 0, lines);
    }

    public Item(ErrorType type, String message, int lineNumber, int column, List<String> lines){
        this.type = type;
        this.message = message;
        this.lineNumber = lineNumber;
        this.column = column;
        this.lines = lines;
    }
}
