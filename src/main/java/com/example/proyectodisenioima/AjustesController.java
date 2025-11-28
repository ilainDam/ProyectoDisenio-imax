package com.example.proyectodisenioima;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AjustesController {

    @FXML
    private VBox nodoAjustes;
    @FXML
    public void onOriginal() throws IOException {
        this.crearCss("#FFEECF","#FFC482","#65DEF1","#2B59C3","#04F06A","black","white");
    }

    @FXML
    public void onNegro() {

    }

    @FXML
    public void onBlanco() throws IOException {
        this.crearCss("#FFFFFF","#F5F5F5","#FFFFFF","#E0E0E0","#CCCCCC","black","#000000","white");
    }

    @FXML
    public void onPersonalizado(ActionEvent event){
        new Utilidades().abrirVentana(event,"colorPersonalizado.fxml","Color personalizado");
    }

    public void crearCss(String pbg,
                         String sbg,
                         String prs,
                         String srs,
                         String trs,
                         String pff,
                         String sff) throws IOException {
        FileWriter fw = new FileWriter("src/main/resources/CSS/root.css");
        BufferedWriter escribir = new BufferedWriter(fw);
        String css = " @font-face {\n" +
                "            font-family: \"Jersey 15\";\n" +
                "            src: url(\"../font/Jersey15-Regular.ttf\") format(\"truetype\");\n" +
                "        }\n" +
                "*{\n" +
                "            -fx-principal-bg-color:" + pbg + ";\n" +
                "            -fx-secundario-bg-color:" + sbg + ";\n" +
                "            -fx-principal-rs-color:" + prs + ";\n" +
                "            -fx-secundario-rs-color:" + srs + ";\n" +
                "            -fx-terciario-rs-color:" + trs + ";\n" +
                "            -fx-principal-font-color:" + pff + ";\n" +
                "            -fx-secundario-font-color:" + sff + ";\n" +
                "            -fx-font-family: 'Jersey 15';\n" +
                "            -fx-especial:black;\n" +
                "        }\n" +
                "\n" +
                ".fuente32{\n" +
                "            -fx-font-size: 32px;\n" +
                "        }\n" +
                ".fuente42{\n" +
                "            -fx-font-size: 42px;\n" +
                "        }\n" +
                ".fuente62{\n" +
                "            -fx-font-size: 62px;\n" +
                "        }.menuSuperior{\n" +
                "            -fx-background-color: -fx-secundario-bg-color;\n" +
                "            -fx-border-color: black;\n" +
                "            -fx-border-width: 4px;\n" +
                "        }\n" +
                " .tituloApartado{\n" +
                "            -fx-background-color: -fx-principal-rs-color;\n" +
                "            -fx-border-color: black;\n" +
                "            -fx-border-width: 0 4px 4px 4px;\n" +
                "        }";

        escribir.write(css);
        escribir.close();
    }

    public void crearCss(String pbg,
                         String sbg,
                         String prs,
                         String srs,
                         String trs,
                         String pff,
                         String sff,
                         String sp) throws IOException {
        FileWriter fw = new FileWriter("src/main/resources/CSS/root.css");
        BufferedWriter escribir = new BufferedWriter(fw);
        String css = " @font-face {\n" +
                "            font-family: \"Jersey 15\";\n" +
                "            src: url(\"../font/Jersey15-Regular.ttf\") format(\"truetype\");\n" +
                "        }\n" +
                "*{\n" +
                "            -fx-principal-bg-color:" + pbg + ";\n" +
                "            -fx-secundario-bg-color:" + sbg + ";\n" +
                "            -fx-principal-rs-color:" + prs + ";\n" +
                "            -fx-secundario-rs-color:" + srs + ";\n" +
                "            -fx-terciario-rs-color:" + trs + ";\n" +
                "            -fx-principal-font-color:" + pff + ";\n" +
                "            -fx-secundario-font-color:" + sff + ";\n" +
                "            -fx-font-family: 'Jersey 15';\n" +
                "            -fx-especial:"+sp+";\n" +
                "        }\n" +
                "\n" +
                ".fuente32{\n" +
                "            -fx-font-size: 32px;\n" +
                "        }\n" +
                ".fuente42{\n" +
                "            -fx-font-size: 42px;\n" +
                "        }\n" +
                ".fuente62{\n" +
                "            -fx-font-size: 62px;\n" +
                "        }.menuSuperior{\n" +
                "            -fx-background-color: -fx-secundario-bg-color;\n" +
                "            -fx-border-color: black;\n" +
                "            -fx-border-width: 4px;\n" +
                "        }\n" +
                " .tituloApartado{\n" +
                "            -fx-background-color: -fx-principal-rs-color;\n" +
                "            -fx-border-color: black;\n" +
                "            -fx-border-width: 0 4px 4px 4px;\n" +
                "        }";

        escribir.write(css);
        escribir.close();
    }
    public void onAjustesUsuario(){
       nodoAjustes.getChildren().clear();
//Personalizacion
        Label lblPersonalizacion = new Label("Ajustes de usuario");
        lblPersonalizacion.setAlignment(Pos.CENTER);
        lblPersonalizacion.setPrefSize(1300, 85);
        lblPersonalizacion.getStyleClass().addAll("fuente42", "botonOpciones");
        VBox.setMargin(lblPersonalizacion, new Insets(25, 0, 0, 25));
//Temas
        Label lblTemas = new Label("Informacion del usuario");
        lblTemas.setPrefSize(1356, 50);
        lblTemas.getStyleClass().add("fuente32");
        VBox.setMargin(lblTemas, new Insets(20, 0, 0, 0));
        lblTemas.setPadding(new Insets(0, 0, 0, 30));
//Original
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPrefSize(200, 100);
        Button btnOriginal = new Button("Usuario: ");
        btnOriginal.setPrefSize(162, 66);
        btnOriginal.setMnemonicParsing(false);
        btnOriginal.getStyleClass().addAll("fuente32", "botonInterno");
        btnOriginal.setCursor(Cursor.HAND);
        HBox.setMargin(btnOriginal, new Insets(0, 50, 0, 0));
        hbox.getChildren().add(btnOriginal);
        hbox.setPadding(new Insets(0,0,0,100));
// Añadir al nodo principal
        nodoAjustes.getChildren().add(lblPersonalizacion);
        nodoAjustes.getChildren().add(lblTemas);
        nodoAjustes.getChildren().add(hbox);
    }
}
