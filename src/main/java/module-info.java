module com.example.todoapplication {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires validatorfx;
                requires org.kordamp.bootstrapfx.core;
            
    opens com.example.todoapplication to javafx.fxml;
    exports com.example.todoapplication;
}