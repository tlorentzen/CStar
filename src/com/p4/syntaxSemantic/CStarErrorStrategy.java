package com.p4.syntaxSemantic;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;

import java.util.*;

public class CStarErrorStrategy extends DefaultErrorStrategy {

    private final HashMap<String, String> tokenTranslate = new HashMap<>();

    public CStarErrorStrategy(){
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

        IntervalSet set = e.getExpectedTokens();
        List<String> expTokens = new ArrayList<>();

        for (Interval i : set.getIntervals()){
            for(int a = i.a; a <= i.b; a++){
                String symName = recognizer.getVocabulary().getDisplayName(a);
                expTokens.add(tokenTranslate.getOrDefault(symName, symName));
            }
        }

        StringBuilder str = new StringBuilder();

        int limit = expTokens.size()-1;
        for (int l=0; l<=limit; l++){
            if(l == limit && limit > 0){
                str.append(" or ");
            }else if(l > 0){
                str.append(", ");
            }

            str.append(expTokens.get(l));
        }

        String msg = "incorrect input " + this.getTokenErrorDisplay(e.getOffendingToken()) + " was expecting ("+ str.toString() +")";
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            String tokenName = this.getTokenErrorDisplay(t);
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            List<String> expTokens = new ArrayList<>();

            for (Interval i : expecting.getIntervals()){
                for(int a = i.a; a <= i.b; a++){
                    String symName = recognizer.getVocabulary().getDisplayName(a);
                    expTokens.add(tokenTranslate.getOrDefault(symName, symName));
                }
            }

            StringBuilder str = new StringBuilder();

            int limit = expTokens.size()-1;
            for (int l=0; l<=limit; l++){
                if(l == limit && limit > 0){
                    str.append(" or ");
                }else if(l > 0){
                    str.append(", ");
                }

                str.append(expTokens.get(l));
            }

            String msg = "expected " + str.toString() + " found "+ tokenName;

            //String msg = "irrelevant input " + tokenName + " expecting ("+ String.join(", ", expTokens) +")";
            recognizer.notifyErrorListeners(t, msg, (RecognitionException)null);
        }
    }

}
