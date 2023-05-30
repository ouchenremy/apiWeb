module com.example.projet_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.common;

    opens com.example.projet_javafx to javafx.fxml;
    exports com.example.projet_javafx;
}