package com.example.proyectodisenioima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class RegisterController {
    @FXML
    private TextField email;
    @FXML private PasswordField contrasenia;
    @FXML private PasswordField contraseniaRepetida;

    @FXML
    protected void onRegister(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter(new File("usuarios.txt"));
        BufferedWriter escribir = new BufferedWriter(fw);
        if (contraseniaRepetida.getText().equals(contrasenia.getText())){
            escribir.write(email.getText()+","+contraseniaRepetida.getText());
            escribir.newLine();
            abrirLogin(event);
            escribir.close();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Constraseñas no coinciden");
            alerta.setContentText("Las contraseñas no coinciden revisa la escritura ");
            alerta.show();
        }
    }

    @FXML
    protected void abrirLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1920, 1080);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setTitle("Login");
            stage.showAndWait();

        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
