package com.example.proyectodisenioima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginController {
    @FXML private TextField email;
    @FXML private PasswordField contrasenia;

    @FXML
    protected void onLogin(ActionEvent event) throws FileNotFoundException {
        Scanner leer = new Scanner(new File("usuarios.txt"));
        String[] lineaSeparada;
        String linea;
        while (leer.hasNext()){
            linea = leer.nextLine();
            lineaSeparada = linea.split(",");
            if (email.getText().equals(lineaSeparada[0])&&contrasenia.getText().equals(lineaSeparada[1])){
                System.out.println("estas dentro");
            }
        }
    }
}
