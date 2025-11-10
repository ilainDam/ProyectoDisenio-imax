module com.example.proyectodisenioima {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectodisenioima to javafx.fxml;
    exports com.example.proyectodisenioima;
}