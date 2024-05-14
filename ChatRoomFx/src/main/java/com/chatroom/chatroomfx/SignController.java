package com.chatroom.chatroomfx;

import com.chatroom.chatroomfx.database.DatabaseHandler;
import com.chatroom.chatroomfx.database.DatabaseQuery;
import com.chatroom.chatroomfx.service.SignService;
import com.chatroom.chatroomfx.users.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class SignController {

    DatabaseQuery databaseQuery = new DatabaseQuery(new DatabaseHandler());
    UserService userService = new UserService(databaseQuery);
    SignService signService = new SignService();


    @FXML
    private AnchorPane login_form;

    @FXML
    private TextField login_username;

    @FXML
    private PasswordField login_password;

    @FXML
    private Button login_btn;

    @FXML
    private Button login_createAccount;

    @FXML
    private TextField login_showPassword;

    @FXML
    private Button signup_btn;

    @FXML
    private PasswordField signup_confirmPassword;

    @FXML
    private TextField signup_firstname;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private TextField signup_lastname;

    @FXML
    private Button signup_loginAccount;

    @FXML
    private PasswordField signup_password;

    @FXML
    private TextField signup_username;

    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox login_SelectShowPassword;



    public SignController() throws SQLException, IOException {
    }

    public void register() throws SQLException {
        this.signService.register(userService,signup_username,signup_password,
                signup_confirmPassword,signup_firstname,signup_lastname);
    }

    public void login() throws SQLException, IOException {
        signService.login(userService,login_username, login_password);
    }


    public void switchForm(ActionEvent event) {
        if (event.getSource()==signup_loginAccount){
            signup_form.setVisible(false);
            login_form.setVisible(true);
        }else{
            signup_form.setVisible(true);
            login_form.setVisible(false);
        }
    }

    public void showPassword() {
        if(login_SelectShowPassword.isSelected()){
            login_showPassword.setText(login_password.getText());
            login_showPassword.setVisible(true);
            login_password.setVisible(false);
        }else {
            login_password.setText(login_password.getText());
            login_password.setVisible(true);
            login_showPassword.setVisible(false);

        }
    }
}