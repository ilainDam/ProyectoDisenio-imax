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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoginController {
    @FXML private TextField email;
    @FXML private PasswordField contrasenia;

    @FXML
    public void onLogin(ActionEvent event) throws FileNotFoundException {
        Scanner leer = new Scanner(new File("usuarios.txt"));
        String[] lineaSeparada;
        String linea;
        Boolean encontrado=false;
        while (leer.hasNext()){
            linea = leer.nextLine();
            lineaSeparada = linea.split(",");
            if (email.getText().equals(lineaSeparada[0])&&contrasenia.getText().equals(lineaSeparada[1])){
                abrirBloquearArchivos(event);
                encontrado=true;
                break;
            }
        }
        if (!encontrado){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Credenciales incorrectos");
            alerta.setContentText("Las credenciales son incorrectas revise la escritura o si no se acuerda de la contraseña dele al boton ¿Olvidaste tu contraseña?");
            alerta.showAndWait();
        }
        leer.close();
    }
    
    @FXML
    public void abrirBloquearArchivos(ActionEvent event) {
        new Utilidades().abrirVentana(event,"bloquearArchivos.fxml","Bloquear Archivos");
    }
    
    @FXML
    public void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
