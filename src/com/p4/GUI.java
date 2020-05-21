package com.p4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.util.Objects;

public class GUI extends Application{
    public static void main (String[] args)
    {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("com/p4/resources/MainWindow.fxml")));
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/p4/resources/icon.png")));
        stage.setTitle("CStar Compiler");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
