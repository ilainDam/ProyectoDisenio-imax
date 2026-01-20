package com.example.proyectodisenioima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Utilidades {
    public void abrirVentana(ActionEvent event,String ventanaFXML,String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ventanaFXML));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            double ancho = stage.getWidth();
            double alto = stage.getHeight();
            boolean estabaMaximizada = stage.isMaximized();
            boolean estabaPantallaCompleta = stage.isFullScreen();
            Scene scene = new Scene(root, ancho > 0 ? ancho : 800, alto > 0 ? alto : 600);
            scene = añadirAyuda(scene);
            stage.setScene(scene);
            stage.setMaximized(estabaMaximizada);
            stage.setFullScreen(estabaPantallaCompleta);
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
    public Scene añadirAyuda(Scene escena) {
        escena.setOnKeyPressed(e -> {
             if (e.getCode() == KeyCode.F1) {
                 mostrarAyuda();
                 e.consume();
            }
        });
        return escena;
    }
    private void mostrarAyuda() {
            Stage ayudaStage = new Stage();
            WebView webView = new WebView();
            String url = getClass().getResource("/HelpNDoc/HTML/Lockit.html").toExternalForm();
            webView.getEngine().load(url);
            Scene scene = new Scene(webView, 900, 600);
            ayudaStage.setScene(scene);
            ayudaStage.setTitle("Ayuda");
            ayudaStage.getIcons().add(
                    new Image(getClass().getResourceAsStream("/IMG/icono.png"))
            );
            ayudaStage.show();
    }

}
