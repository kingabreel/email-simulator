package com.gab.mailsimulator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EmailDetailController {
    @FXML
    public Label contentLabel;
    @FXML
    private Label senderLabel;

    @FXML
    private Label subjectLabel;


    public void initialize(String sender, String subject, String content) {
        senderLabel.setText(sender);
        subjectLabel.setText(subject);
        contentLabel.setText(content);
    }

}
