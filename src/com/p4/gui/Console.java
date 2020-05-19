package com.p4.gui;


import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.OutputStream;

public class Console extends OutputStream {
    private TextArea console;

    public Console(TextArea console) {
        this.console = console;
    }

    public void appendText(String valueOf) {
        Platform.runLater(() -> console.appendText(valueOf));
    }

    public void write(int b) throws IOException {
        appendText(String.valueOf((char)b));
    }
}
