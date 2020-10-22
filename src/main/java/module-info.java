module com.project.providentia {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

    opens com.project.providentia to javafx.fxml;
    exports com.project.providentia;
    
    opens com.project.providentia.ui.controllers to javafx.fxml;
    exports com.project.providentia.ui.controllers;
}