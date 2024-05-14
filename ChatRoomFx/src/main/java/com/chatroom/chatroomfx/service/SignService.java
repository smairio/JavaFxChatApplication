package com.chatroom.chatroomfx.service;

import com.chatroom.chatroomfx.ChatController;
import com.chatroom.chatroomfx.alert.AlertMessage;
import com.chatroom.chatroomfx.users.User;
import com.chatroom.chatroomfx.users.UserService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class SignService {

    public void register(UserService userService, TextField signup_username, PasswordField signup_password, PasswordField signup_confirmPassword,
                        TextField signup_firstname, TextField signup_lastname) throws SQLException {
        AlertMessage alertMessage = new AlertMessage();

        if (signup_username.getText().isEmpty() || signup_password.getText().isEmpty() || signup_confirmPassword.getText().isEmpty()
                || signup_firstname.getText().isEmpty() || signup_lastname.getText().isEmpty()) {
            alertMessage.errorMessage("All fields are necessary to be filled!");
        } else if (!signup_password.getText().equals(signup_confirmPassword.getText())) {
            alertMessage.errorMessage("Password does not match!");
        } else if (signup_password.getText().length() < 8) {
            alertMessage.errorMessage("Password length must be at least 8 characters!");
        } else {
            //check if username Eists

            userService.getUserByUsername(signup_username.getText());

            User user = userService.getUserByUsername(signup_username.getText());
            if (user.getUsername() != null) {
                alertMessage.errorMessage("Username is already in use!");
            } else {
                user.setUsername(signup_username.getText()).setPassword(signup_password.getText()).
                        setFirstname(signup_firstname.getText()).setLastname(signup_lastname.getText()).setId(0);
                userService.addUser(user);
                alertMessage.successMessage("User successfully registered!");

            }

        }
    }

    public void login(UserService userService, TextField login_username,PasswordField login_password) throws SQLException{
        AlertMessage alertMessage = new AlertMessage();

        if (login_username.getText().isEmpty() || login_password.getText().isEmpty()) {
            alertMessage.errorMessage("All fields are necessary to be filled!");
        }else{
            User user = userService.getUserByUsername(login_username.getText());
            if(user.getUsername()==null){
                alertMessage.errorMessage("Username is not found on Database!");
            } else if (!user.getPassword().equals(login_password.getText())) {
                alertMessage.errorMessage("Password does not match!");
            }else{
                try {
                    // Load the FXML file for the new scene
                    URL resourceUrl = getClass().getClassLoader().getResource("chat.fxml");
                    if (resourceUrl == null) {
                        // Handle the case where the resource is not found
                        System.err.println("chat.fxml not found in the classpath.");
                    } else {
                        alertMessage.successMessage("Login successful!");
                        FXMLLoader loader = new FXMLLoader(resourceUrl);
                        ChatController controller = new ChatController();
                        controller.setUser(user);
                        loader.setController(controller);
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Main Application");
                        // Show the stage
                        stage.show();
                        Stage loginStage = (Stage) login_username.getScene().getWindow();
                        loginStage.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}