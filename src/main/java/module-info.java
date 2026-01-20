module com.example.proyectodisenioima {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.web;

    opens com.example.proyectodisenioima to javafx.fxml;
    exports com.example.proyectodisenioima;
}