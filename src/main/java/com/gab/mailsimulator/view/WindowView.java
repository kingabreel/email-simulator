package com.gab.mailsimulator.view;

import com.gab.mailsimulator.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/gab/mailsimulator/fxml/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 360);
        scene.getStylesheets().add(getClass().getResource("/com/gab/mailsimulator/css/style.css").toExternalForm());
        stage.setTitle("Mail Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
