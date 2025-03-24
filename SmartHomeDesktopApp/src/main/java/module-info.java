module org.example.smarthomedesktopapp {
//    requires javafx.controls;
//    requires javafx.fxml;
//
    requires com.dlsc.formsfx;
    requires static lombok;
    requires feign.jackson;
    requires feign.core;
    requires java.logging;
//
//    opens org.example.smarthomedesktopapp to javafx.fxml;
//    exports org.example.smarthomedesktopapp;
//    exports org.example.smarthomedesktopapp.controller.HomeViewController;
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.smarthomedesktopapp.controller to javafx.fxml;
    exports org.example.smarthomedesktopapp;
}