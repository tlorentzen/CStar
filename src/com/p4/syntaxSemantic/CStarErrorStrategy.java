package com.p4.syntaxSemantic;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import java.util.*;

//Finds the expected tokens for the error message
public class CStarErrorStrategy extends DefaultErrorStrategy {
    private final HashMap<String, String> tokenTranslate = new HashMap<>();

    //Adds tokens that need to be translated to the hashmap
    public CStarErrorStrategy() {
        tokenTranslate.put("COMP_OP", "'='");
        tokenTranslate.put("INT_LITERAL", "'integer'");
        tokenTranslate.put("LONG_LITERAL", "'long integer'");
        tokenTranslate.put("FLOAT_LITERAL", "'decimal'");
        tokenTranslate.put("PIN_LITERAL", "'pin'");
        tokenTranslate.put("CHAR_LITERAL", "'char'");
        tokenTranslate.put("FUNCID", "'function'");
        tokenTranslate.put("ID", "'variable'");
    }

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
        //Gets the intervals for the expected tokens
        IntervalSet set = e.getExpectedTokens();
        List<String> expectedTokens = new ArrayList<>();

        //Finds possible symbols that can correct the error
        //The intervals indicate the expected symbols token numbers
        for (Interval interval : set.getIntervals()) {
            for (int a = interval.a; a <= interval.b; a++) {
                //Finds all the expected tokens and adds them to expected tokens
                String symbolName = recognizer.getVocabulary().getDisplayName(a);
                expectedTokens.add(tokenTranslate.getOrDefault(symbolName, symbolName));
            }
        }

        //Builds the string message for the expected token
        String tokenString = buildString(expectedTokens).toString();

        String message = "Incorrect input: " + this.getTokenErrorDisplay(e.getOffendingToken()) + 
                         " was expecting ("+ tokenString +")";
        recognizer.notifyErrorListeners(e.getOffendingToken(), message, e);
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);

            //Gets the unwanted token
            Token token = recognizer.getCurrentToken();
            String tokenName = this.getTokenErrorDisplay(token);
            //Gets the intervals for the expected tokens
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            List<String> expectedTokens = new ArrayList<>();

            //Finds possible symbols that can correct the error
            //The intervals indicate the expected symbols token numbers
            for (Interval interval : expecting.getIntervals()) {
                for (int a = interval.a; a <= interval.b; a++) {
                    //Gets the symbol name
                    String symbolName = recognizer.getVocabulary().getDisplayName(a);
                    //Adds the symbol to the list of expected tokens
                    expectedTokens.add(tokenTranslate.getOrDefault(symbolName, symbolName));
                }
            }

            //Builds the string message for the expected token
            String tokenString = buildString(expectedTokens).toString();

String message = "Expected " + tokenString + " found " + tokenName;
            recognizer.notifyErrorListeners(token, message, null);
        }
    }
    
    private StringBuilder buildString(List<String> expectedTokens) {
        StringBuilder stringBuilder = new StringBuilder();
        int limit = expectedTokens.size() - 1;

        for (int limitCount = 0; limitCount <= limit; limitCount++) {
            //Enters if the last expected token has been reached
            if (limitCount == limit && limit > 0) {
                stringBuilder.append(" or ");
            }
            //Enters if there are more tokens left to be appended
            else if (limitCount > 0) {
                stringBuilder.append(", ");
            }

            //Appends the token to the error message
            stringBuilder.append(expectedTokens.get(limitCount));
        }
        return stringBuilder;
    }

}
