package com.p4.errors;

import java.util.ArrayList;
import java.util.List;



public class ErrorBag {
    private List<Item> errors = new ArrayList<>();

    public enum errorType {TYPE};

    public void addEntry(String code, String message, errorType type){
        this.errors.add(new Item(code, message, type));
    }

    public boolean isEmpty(){
        return this.errors.isEmpty();
    }

    public void display(){
        for (Item item : errors) {
            System.out.println(item.message);
        }
    }
}

class Item{
    ErrorBag.errorType type;
    String code;
    String message;

    public Item(String code, String message, ErrorBag.errorType type){
        this.type = type;
        this.code = code;
        this.message = message;
    }
}

