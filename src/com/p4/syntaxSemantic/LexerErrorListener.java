package com.p4.syntaxSemantic;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import org.antlr.v4.runtime.*;

public class LexerErrorListener extends BaseErrorListener {
// tsting version control
    ErrorBag errors;

    public LexerErrorListener(ErrorBag errors){
        this.errors = errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        String token = e.toString().substring(27, 28);
        errors.addEntry(ErrorType.LEXER_ERROR, "did not recognize the character '"+token+"'", line, charPositionInLine);
    }

}
