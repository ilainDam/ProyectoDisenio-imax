package com.example.proyectodisenioima;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/font/Jersey15-Regular.ttf"), 14);
        //
        if (sesionIniciada()){
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("bloquearArchivos.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
            stage.setTitle("bloquear Archivos");
            stage.setScene(scene);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/IMG/icono.png")));
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.show();
        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/IMG/icono.png")));
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.show();
        }
    }
    public static boolean sesionIniciada(){
        boolean encontrado=false;
        try {
            String lineaSesion;
            Scanner leerS = new Scanner(new File("sesionGuardada.txt"));
            Scanner leerU = new Scanner(new File("usuarios.txt"));
            lineaSesion = leerS.nextLine();
            while (leerU.hasNext()){
                if (leerU.nextLine().equalsIgnoreCase(lineaSesion)){
                    encontrado=true;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("No encontrada la sesion");
        }
        return encontrado;
    }
}
