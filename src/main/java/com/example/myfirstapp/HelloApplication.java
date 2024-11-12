package com.example.myfirstapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    FXMLLoader fxmlLoader;

    public static Scene scene1;

    public static Stage stage1;

    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        scene1 = new Scene(fxmlLoader.load(), 700, 400);
        stage1 = stage;
        stage.setTitle("Pc collector");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}