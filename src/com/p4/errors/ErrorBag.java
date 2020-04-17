package com.p4.errors;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;



public class ErrorBag {
    private static String OS = System.getProperty("os.name").toLowerCase();
    private List<Item> errors = new ArrayList<>();

    public void addEntry(String code, String message, ErrorType type, int lineNumber){
        this.errors.add(new Item(code, message, type, lineNumber));
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
                    System.out.print(getColor(item.code));
                    System.out.print(item.code);
                    System.out.print(Color.RESET);
                    System.out.print(": "+item.message+" ("+item.type.toString()+") on line "+item.lineNumber+"\n");
                }else{
                    System.out.println(item.code+": "+item.message+" ("+item.type.toString()+") on line "+item.lineNumber);
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
}

class Item{
    ErrorType type;
    String code;
    String message;
    int lineNumber;

    public Item(String code, String message, ErrorType type, int lineNumber){
        this.type = type;
        this.code = code;
        this.message = message;
        this.lineNumber = lineNumber;
    }
}
