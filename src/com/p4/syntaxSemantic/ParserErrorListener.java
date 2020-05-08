package com.p4.syntaxSemantic;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import org.antlr.v4.runtime.*;
import java.util.ArrayList;
import java.util.List;

//Finds token compositions that are not recognized by the parser
public class ParserErrorListener extends BaseErrorListener {
    ErrorBag errors;

    public ParserErrorListener(ErrorBag errors) {
        this.errors = errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int lineNumber,
                            int charPositionInLine, String message, RecognitionException e) {
        //Creates the arrows that will point at the location of the error
        List<String> lineOutput = underlineError(recognizer, (Token)offendingSymbol, lineNumber, charPositionInLine);
        errors.addEntry(ErrorType.PARSER_ERROR, message, lineNumber, charPositionInLine, lineOutput);
    }

    protected List<String> underlineError(Recognizer<?, ?>  recognizer, Token offendingToken, int lineNumber, int charPositionInLine) {
        List<String> output = new ArrayList<>();
        CommonTokenStream tokens = (CommonTokenStream)recognizer.getInputStream();

        //Gets the source code
        String input = tokens.getTokenSource().getInputStream().toString();
        //Gets the line containing the error from the source code
        String errorLine = input.split("\n")[lineNumber-1];
        output.add(errorLine);

        StringBuilder pointer = new StringBuilder();
        //Appends spaces to the string that will point at the location of the error
        pointer.append(" ".repeat(Math.max(0, charPositionInLine)));

        //Gets the length of the error
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();

        //Enters if start and stop is not negative
        if (start >= 0 && stop >= 0) {
            //Adds the number of arrows that corresponds to the error length
            pointer.append("^".repeat(Math.max(0, stop - start + 1)));
        }

        output.add(pointer.toString());
        return output;
    }
}
