package com.example.proyectodisenioima;

import javafx.event.ActionEvent;

public class BarraSuperiorController {

    public void abrirBloquear(ActionEvent event) {
        new Utilidades().abrirVentana(event,"bloquearArchivos.fxml","Bloquear archivos");
    }
    public void abrirAcciones(ActionEvent event) {
        new Utilidades().abrirVentana(event,"historialDeAcciones.fxml","Historial de acciones");
    }
    public void abrirBloqueados(ActionEvent event) {
        new Utilidades().abrirVentana(event,"trabajando.fxml","trabajando");
    }
    public void abrirAjustes(ActionEvent event) {
        new Utilidades().abrirVentana(event,"ajustes.fxml","ajustes");
    }
}
