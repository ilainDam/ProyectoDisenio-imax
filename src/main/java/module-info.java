module com.example.proyectodisenioima {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.example.proyectodisenioima to javafx.fxml;
    exports com.example.proyectodisenioima;
}