package com.p4.errors;

import java.nio.file.Path;
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
        this.errors.add(new Item(type, message, lineNumber, column));

        if(type.toString().startsWith("E")){
            hasErrors = true;
        }
    }

    public boolean isEmpty(){
        return this.errors.isEmpty();
    }

    public void display(){
        if(!isEmpty()){
            boolean displayColors = !(OS.contains("win") && System.console() != null);

            System.out.println("Something went wrong...");
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

    public Item(ErrorType type, String message, int lineNumber){
        this(type, message, lineNumber, 0);
    }

    public Item(ErrorType type, String message, int lineNumber, int column){
        this.type = type;
        this.message = message;
        this.lineNumber = lineNumber;
        this.column = column;
    }
}
