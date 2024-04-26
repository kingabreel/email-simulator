module com.gab.mailsimulator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.gab.mailsimulator to javafx.fxml;
    exports com.gab.mailsimulator;
    exports com.gab.mailsimulator.controller;
    opens com.gab.mailsimulator.controller to javafx.fxml;
}