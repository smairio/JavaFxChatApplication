package com.chatroom.chatroomfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 353, 546);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            // Add cleanup tasks here before exiting the application
            Platform.exit(); // Terminate the JavaFX application
            // Add additional cleanup tasks if needed
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
