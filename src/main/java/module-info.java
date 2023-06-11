module Login {
    requires javafx.graphics;
    requires  javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens fxml;
    opens com.example.login to javafx.fxml;
    exports com.example.login;
}