package com.p4.gui;

import com.p4.Board;
import com.p4.CliExec;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ShowArduinoController {
    public ObservableList<Board> items = FXCollections.observableArrayList();
    @FXML
    public ListView listView;

    public static Board chosenBoard;

    public void initialize() throws FileNotFoundException {
        items.addAll(CliExec.boards);
        listView.setItems(items);
    }
    public void saveBoardAction(ActionEvent actionEvent) {
        chosenBoard = (Board) listView.getSelectionModel().getSelectedItem();
    }
}
