package com.gab.mailsimulator.controller;

import com.gab.mailsimulator.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HelloController {

    private final UserService userService = new UserService();
    @FXML
    public TextField emailRegisterBox;
    @FXML
    public TextField passwordRegisterBox;
    @FXML
    public TextField usernameRegisterBox;
    @FXML
    public VBox registerBox;
    private boolean logged = false;
    @FXML
    public VBox loginBox;
    @FXML
    public TextField emailBox;
    @FXML
    public TextField passwordBox;

    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) {
        logged = userService.checkUser(emailBox.getText(), passwordBox.getText());

        if (logged) switchTagAttribute(loginBox);
    }

    @FXML
    public void onRegisterButtonClick(ActionEvent actionEvent) {
        switchTagAttribute(loginBox);
        switchTagAttribute(registerBox);

    }

    @FXML
    public void onRegisterConcluded(ActionEvent actionEvent) {
        userService.addUser(emailRegisterBox.getText(), passwordRegisterBox.getText(), usernameRegisterBox.getText());

        switchTagAttribute(loginBox);
        switchTagAttribute(registerBox);
    }

    private void switchTagAttribute(VBox box) {
        box.setVisible(!box.isVisible());
        box.managedProperty().set(!box.managedProperty().get());
    }
}