package com.example.proyectodisenioima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class LoginController {
    @FXML private TextField email;
    @FXML private PasswordField contrasenia;
    @FXML private CheckBox guardarSesion;

    @FXML
    public void onLogin(ActionEvent event) throws IOException {
        Scanner leer = new Scanner(new File("usuarios.txt"));
        String[] lineaSeparada;
        String linea;
        boolean encontrado=false;
        while (leer.hasNext()){
            linea = leer.nextLine();
            lineaSeparada = linea.split(",");
            if (email.getText().equals(lineaSeparada[0])&&contrasenia.getText().equals(lineaSeparada[1])){
                abrirBloquearArchivos(event);
                if (guardarSesion.isSelected()){guardarSesion();}
                usuarioActual(email.getText());
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
    public void guardarSesion() throws IOException {
        FileWriter fw = new FileWriter("sesionGuardada.txt");
        BufferedWriter escribir = new BufferedWriter(fw);
        escribir.write(email.getText()+","+contrasenia.getText());
        escribir.close();
    }
    public void usuarioActual(String usuario) throws IOException {
        FileWriter fw = new FileWriter("sesionActual.txt");
        BufferedWriter escribir = new BufferedWriter(fw);
        escribir.write(usuario);
        escribir.close();
    }
}
