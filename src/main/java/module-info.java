module com.project.providentia {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.project.providentia to javafx.fxml;
    exports com.project.providentia;
}