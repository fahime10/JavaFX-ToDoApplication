module com.example.todoapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    requires com.jfoenix;
    requires java.sql;

    opens com.example.todoapplication to javafx.fxml;
    exports com.example.todoapplication;
    exports com.example.todoapplication.controller;
    opens com.example.todoapplication.controller to javafx.fxml;
}