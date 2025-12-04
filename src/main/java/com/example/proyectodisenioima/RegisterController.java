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
    @FXML
    private PasswordField contrasenia;
    @FXML
    private PasswordField contraseniaRepetida;

    @FXML
    public void onRegister(ActionEvent event) throws IOException {
        if (contrasenia.getText().isEmpty()
                || contraseniaRepetida.getText().isEmpty()
                || email.getText().isEmpty()) {
            Alert alerta = new Utilidades().alerta(
                    Alert.AlertType.ERROR,
                    "Credenciales vacias",
                    "No pueden existir credenciales vacias"
            );
            alerta.showAndWait();
        } else {
            FileWriter fw = new FileWriter("usuarios.txt", true);
            BufferedWriter escribir = new BufferedWriter(fw);
            if (contraseniaRepetida.getText().equals(contrasenia.getText())) {
                escribir.write(email.getText() + "," + contraseniaRepetida.getText());
                escribir.newLine();
                abrirLogin(event);
                escribir.close();
            } else {
                Alert alerta = new Utilidades().alerta(
                        Alert.AlertType.ERROR,
                        "Constraseñas no coinciden",
                        "Las contraseñas no coinciden revisa la escritura"
                );
                alerta.showAndWait();
            }
        }
    }

    @FXML
    public void abrirLogin(ActionEvent event) {
        new Utilidades().abrirVentana(event, "login.fxml", "Login");
    }

    @FXML
    public void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
