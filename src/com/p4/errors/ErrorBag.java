package com.p4.errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorBag {
    final private static String OS = System.getProperty("os.name").toLowerCase();
    final private List<Item> errors = new ArrayList<>();
    private boolean hasErrors = false;

    //Used when there is an error for the entire program
    public void addEntry(ErrorType type, String message) {
        this.addEntry(type, message, 0, 0);
    }

    //Used in the visitors
    public void addEntry(ErrorType type, String message, int lineNumber) {
        this.addEntry(type, message, lineNumber, 0);
    }

    //Used in lexer error to display the token position
    public void addEntry(ErrorType type, String message, int lineNumber, int column) {
        List<String> lines = new ArrayList<>();
        this.addEntry(type, message, lineNumber, column, lines);

        setHasErrors(type);
    }

    //Used in parser error list to print arrows that shows position of error
    public void addEntry(ErrorType type, String message, int lineNumber, int column, List<String> lines){
        //Enters if the error has not been added to the error list yet
        if (shouldBeAdded(type, message)) {
            this.errors.add(new Item(type, message, lineNumber, column, lines));

            setHasErrors(type);
        }
    }

    private void setHasErrors(ErrorType type) {
        //Enters if an error was reported
        if (type.toString().startsWith("E")) {
            hasErrors = true;
        }
    }

    private boolean shouldBeAdded(ErrorType type, String message) {
        //Enters if the error is of an undeclared function
        if (type == ErrorType.UNDECLARED_FUNCTION_WARNING) {
            //Extracts the function name from the error message
            String calledFunction = message.split("'", 3)[1];

            for (Item error : errors) {

                //Enters if the undeclared function has already been added to the error list of errors
                if (error.type == ErrorType.UNDECLARED_FUNCTION_WARNING &&
                    calledFunction.equals(error.message.split("'", 3)[1])) {
                   return false;
                }
            }
        }
        return true;
    }


    public void display() {
        boolean isEmpty = this.errors.isEmpty();

        //Enters if errors have occurred
        if(!isEmpty){

            System.out.println("Something went wrong... Found " + errorGrammar());
            System.out.println("-----------------------");

            printErrorMessages();
        }
    }

    //Creates the string containing number of errors and warnings for the error message
    private String errorGrammar() {
        int numberOfWarnings = 0;
        int numberOfErrors;
        String errorGrammar;
        String warningGrammar;

        //Finds the number of warnings in the error list
        for (Item error : errors) {
            if (error.type.toString().startsWith("W")) {
                numberOfWarnings++;
            }
        }
        //Finds the number of errors in the error list
        numberOfErrors = errors.size() - numberOfWarnings;

        //Writes word in singular if there is only one
        errorGrammar = (numberOfErrors == 1 ? " error" : " errors");
        warningGrammar = (numberOfWarnings == 1 ? " warning" : " warnings");

        //Returns the correct error message depending on whether errors and warnings are present
        if (numberOfErrors > 0 && numberOfWarnings > 0) {
            return numberOfErrors + errorGrammar + " and " + numberOfWarnings + warningGrammar;
        }
        else if (numberOfErrors > 0) {
            return numberOfErrors  + errorGrammar;
        }
        else if (numberOfWarnings > 0) {
            return numberOfWarnings + warningGrammar;
        }
        else {
            return "We made  mistake";
        }
    }

    private void printErrorMessages() {
        boolean isNotWindows = !(OS.contains("win") && System.console() != null);

        //Prints error messages for all errors and warnings
        for (Item error : errors) {
            if (isNotWindows) {
                System.out.print(getColor(error.type.toString()));
                System.out.print(error.type);
                System.out.print(Color.RESET);
                System.out.print(": " + error.message + " (" + error.type.name() + ")");
                System.out.print(error.lineNumber > 0 ? " on line " + error.lineNumber + "\n" : "\n");
            }
            else {
                System.out.println(error.type.toString()+": "+error.message+" ("+error.type.name()+")" +
                        (error.lineNumber > 0 ? " on line "+error.lineNumber : ""));
            }

            //Enters if the error message is on multiple lines
            if (error.lines.size() > 0) {
                //Creates spaces, so the lines are aligned
                String indent = " ".repeat(error.type.toString().length());

                for (String line : error.lines) {
                    //Enters if line contains other characters than just spaces
                    if (line.trim().length() > 0) {
                        System.out.println(indent + "| " + line);
                    }
                }
                System.out.println();
            }
        }
    }

    //Returns the correct color depending on the type of error
    private Color getColor(String code){
        if (code.startsWith("E")) {
            return Color.RED_BOLD;
        }
        else if (code.startsWith("W")) {
            return Color.YELLOW_BOLD;
        }
        else if(code.startsWith("I")) {
            return Color.BLUE_BOLD;
        }

        return Color.WHITE;
    }

    public boolean containsErrors(){
        return hasErrors;
    }
}
//One item corresponds to one error/warning
class Item {
    ErrorType type;
    String message;
    int lineNumber;
    int column;
    List<String> lines;

    public Item(ErrorType type, String message, int lineNumber, int column, List<String> lines) {
        this.type = type;
        this.message = message;
        this.lineNumber = lineNumber;
        this.column = column;
        this.lines = lines;
    }
}
