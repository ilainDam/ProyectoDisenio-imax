module com.example.proyectodisenioima {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.web;
    requires java.sql;
    requires net.sf.jasperreports.core;

    opens com.example.proyectodisenioima to javafx.fxml;
    exports com.example.proyectodisenioima;
}