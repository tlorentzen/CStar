package com.p4.errors;

import java.util.ArrayList;
import java.util.List;

enum errorType {TYPE};

public class ErrorBag {
    List<Item> errors = new ArrayList();

    public void addEntry(String code, String message, errorType type){
        this.errors.add(new Item(code, message, type));
    }

    public void display(){
        for (Item item : errors) {
            System.out.println(item.message);
        }
    }
}

class Item{
    errorType type;
    String code;
    String message;

    public Item(String code, String message, errorType type){
        this.type = type;
        this.code = code;
        this.message = message;
    }
}

