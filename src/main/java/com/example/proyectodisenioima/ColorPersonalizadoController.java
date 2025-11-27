package com.example.proyectodisenioima;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ColorPersonalizadoController {
    @FXML
    ColorPicker uno;
    @FXML
    ColorPicker dos;
    @FXML
    ColorPicker tres;
    @FXML
    ColorPicker cuatro;
    @FXML
    ColorPicker cinco;
    @FXML
    ColorPicker seis;
    @FXML
    ColorPicker siete;



    private String toHexColor(Color c) {
        return c.toString().replace("0x", "#").substring(0, 7);
    }

    public void onBotonEnviar() throws IOException {
        new AjustesController().crearCss(
                toHexColor(uno.getValue()),
                toHexColor(dos.getValue()),
                toHexColor(tres.getValue()),
                toHexColor(cuatro.getValue()),
                toHexColor(cinco.getValue()),
                toHexColor(seis.getValue()),
                toHexColor(siete.getValue())
        );
    }

}
