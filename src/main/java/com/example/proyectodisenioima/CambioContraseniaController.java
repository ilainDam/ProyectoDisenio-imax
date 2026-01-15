package com.example.proyectodisenioima;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.io.*;

public class CambioContraseniaController {

    @FXML private TextField nombreApellidosField;
    @FXML private TextField emailField;
    @FXML private TextField tituloSolicitudField;
    @FXML private TextArea explicacionArea;
    @FXML private PasswordField nuevaContrasenaField;

    @FXML
    public void enviarSolicitudCambioContrasena() {
        String nombreApellidos = nombreApellidosField.getText();
        String email = emailField.getText();
        String titulo = tituloSolicitudField.getText();
        String explicacion = explicacionArea.getText();
        String nuevaContrasena = nuevaContrasenaField.getText();

        try (FileWriter fw = new FileWriter("solicitudes_cambio_contrasena.csv", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"%n",
                    nombreApellidos, email, titulo, explicacion, nuevaContrasena));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Solicitud Enviada");
            alert.setHeaderText(null);
            alert.setContentText("Tu solicitud de cambio de contraseña ha sido enviada.");
            alert.showAndWait();

            // Cerrar la ventana
            Stage stage = (Stage) nombreApellidosField.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hubo un error al guardar la solicitud.");
            alert.showAndWait();
        }
    }

    @FXML
    public void crearInformeJasper() {
        try {
            InputStream jasperStream = getClass().getResourceAsStream("/ExamenDAD-ima.jasper");
            File csvFile = new File("solicitudes_cambio_contrasena.csv");
            JRCsvDataSource dataSource = new JRCsvDataSource(csvFile);
            dataSource.setUseFirstRowAsHeader(true);
            dataSource.setFieldDelimiter(',');
            JasperPrint print = JasperFillManager.fillReport(jasperStream, null, dataSource);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
