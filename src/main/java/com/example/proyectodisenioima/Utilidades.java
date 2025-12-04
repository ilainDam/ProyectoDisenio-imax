package com.example.proyectodisenioima;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Utilidades {
    public void abrirVentana(ActionEvent event,String ventanaFXML,String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ventanaFXML));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1920, 1080);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.setTitle(titulo);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/IMG/icono.png")));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar login: " + e.getMessage());
        }
    }

    public Alert alerta(Alert.AlertType tipo,String titulo,String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        DialogPane dp = alerta.getDialogPane();
        dp.getStyleClass().add("alerta");
        dp.getStylesheets().add(getClass().getResource("/CSS/root.css").toExternalForm());
        return alerta;
    }

}
