package com.p4.syntaxSemantic;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import org.antlr.v4.runtime.*;

//Finds tokens that are not recognized by the lexer
public class LexerErrorListener extends BaseErrorListener {
    ErrorBag errors;

    public LexerErrorListener(ErrorBag errors) {
        this.errors = errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int lineNumber,
                            int charPositionInLine, String msg, RecognitionException e) {
        int tokenIndexStart = 27, tokenIndexEnd = 28;
        //Gets the token from the exception string
        String token = e.toString().substring(tokenIndexStart, tokenIndexEnd);
        errors.addEntry(ErrorType.LEXER_ERROR, "Did not recognize the character '" + token + "'", lineNumber, charPositionInLine);
    }

}
