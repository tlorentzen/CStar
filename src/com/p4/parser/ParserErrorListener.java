package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ParserErrorListener extends BaseErrorListener {

    ErrorBag errors;

    public ParserErrorListener(ErrorBag errors){
        this.errors = errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){

        System.out.println(" MSG: "+recognizer.getState());

        errors.addEntry(ErrorType.PARSER_ERROR, msg, line, charPositionInLine);
    }

}
