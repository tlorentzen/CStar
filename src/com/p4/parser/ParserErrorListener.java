package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import org.antlr.v4.runtime.*;

import java.util.ArrayList;
import java.util.List;

public class ParserErrorListener extends BaseErrorListener {

    ErrorBag errors;

    public ParserErrorListener(ErrorBag errors){
        this.errors = errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        List<String> lineOutput = underlineError(recognizer, (Token)offendingSymbol, line, charPositionInLine);
        errors.addEntry(ErrorType.PARSER_ERROR, msg, line, charPositionInLine, lineOutput);
    }

    protected List<String> underlineError(Recognizer recognizer, Token offendingToken, int line, int charPositionInLine){
        List<String> output = new ArrayList<>();
        CommonTokenStream tokens = (CommonTokenStream)recognizer.getInputStream();

        String input = tokens.getTokenSource().getInputStream().toString();
        String errorLine = input.split("\n")[line-1];
        output.add(errorLine);

        StringBuilder pointer = new StringBuilder();
        pointer.append(" ".repeat(Math.max(0, charPositionInLine)));

        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();

        if(start>=0 && stop>=0){
            pointer.append("^".repeat(Math.max(0, stop - start + 1)));
        }

        output.add(pointer.toString());
        return output;
    }
}
