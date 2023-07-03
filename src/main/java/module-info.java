module com.example.demogui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.demogui to javafx.fxml;
    exports com.example.demogui;
    exports com.example.demogui.Controller;
    opens com.example.demogui.Controller to javafx.fxml;
    exports com.example.demogui.Entity;
    opens com.example.demogui.Entity to javafx.fxml;
}