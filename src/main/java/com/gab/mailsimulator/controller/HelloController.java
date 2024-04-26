package com.gab.mailsimulator.controller;

import com.gab.mailsimulator.model.Email;
import com.gab.mailsimulator.model.User;
import com.gab.mailsimulator.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
    @FXML
    public Label username;
    @FXML
    public TextField searchBar;
    @FXML
    public TableView<Email> emailTableView;
    @FXML
    public VBox mainWindow;
    @FXML
    public VBox sendEmailBox;
    public TextField destinationEmail;
    public TextField cc;
    public TextField emailSubject;
    public TextArea emailContent;
    private boolean logged = false;
    @FXML
    public VBox loginBox;
    @FXML
    public TextField emailBox;
    @FXML
    public TextField passwordBox;
    private User currentUser;

    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) {
        logged = userService.checkUser(emailBox.getText(), passwordBox.getText());

        if (logged) {
            switchTagAttribute(loginBox);
            currentUser = userService.getUser(emailBox.getText());
            userLogged();
            username.setText(currentUser.getUsername());
            switchTagAttribute(mainWindow);
        }
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

    private void userLogged() {
        ObservableList<Email> emails = FXCollections.observableArrayList(currentUser.getMainMailList());

        emailTableView.setItems(emails);
    }

    public void onNewEmailButtonClick(ActionEvent actionEvent) {
        switchTagAttribute(mainWindow);
        switchTagAttribute(sendEmailBox);
    }

    public void onSendEmailButtonClicked(ActionEvent actionEvent) {
        String contactName = destinationEmail.getText();
        String anotherContacts = cc.getText();
        String subject = emailSubject.getText();
        String content = emailContent.getText();

        String[] contactsArray = anotherContacts.split("\\s+");
        List<String> ccList = Arrays.asList(contactsArray);

        Email email = new Email(subject, currentUser.getUserMail(), contactName, ccList, content);

        User user = userService.getUser(contactName);
        if (user != null) {
            user.getMainMailList().add(email);

            if (user.getMainMailList().get(user.getMainMailList().size() - 1) == email) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Email sent");
                alert.setHeaderText(null);
                alert.setContentText("The email was sucesfully sent");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Check the destination email");
            alert.showAndWait();
        }
        userLogged();

        switchTagAttribute(mainWindow);
        switchTagAttribute(sendEmailBox);
    }

    @FXML
    private void onEmailClicked(MouseEvent event) throws IOException {
        Email selectedEmail = emailTableView.getSelectionModel().getSelectedItem();

        if (selectedEmail != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/gab/mailsimulator/emailDetails.fxml"));
            Scene scene = new Scene(loader.load(), 480, 320);
            Stage stage = new Stage();

            stage.setTitle(selectedEmail.getSubject());
            stage.setScene(scene);
            stage.show();

            EmailDetailController controller = loader.getController();
            controller.initialize(selectedEmail.getSender(), selectedEmail.getSubject(), selectedEmail.getContent());

        }
    }

    public void onReturnButtonClicked(ActionEvent actionEvent) {
        switchTagAttribute(registerBox);
        switchTagAttribute(loginBox);
    }

    public void onLogoutButtonClick(ActionEvent actionEvent) {
        currentUser = null;
        switchTagAttribute(mainWindow);
        switchTagAttribute(loginBox);
    }

    public void onReturnEmailButtonClick(ActionEvent actionEvent) {
        switchTagAttribute(sendEmailBox);
        switchTagAttribute(mainWindow);
    }
}