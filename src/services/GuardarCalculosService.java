package services;

import constants.Mensajes;
import interfaces.IMedidas;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class GuardarCalculosService implements Runnable{
    private static IMedidas figura;
    GuardarCalculosService(IMedidas figura){
        this.figura = figura;
    }

    public static void generarArchivo() {
        String rutaArchivo = crearNuevoArchivo();
        escribirNuevoArchivo(rutaArchivo, figura);
    }

    private static void escribirNuevoArchivo(String nombreArchivo, IMedidas figuraElegida) {
        try {
            PrintWriter printWriter = new PrintWriter(nombreArchivo);
            printWriter.println(figuraElegida.toString());
            printWriter.close();
        }catch (Exception e){
        }
    }

    public static String crearNuevoArchivo() {

        LocalDate todaysDate = LocalDate.now();
        boolean nombreIngresadoCorrectamente = false;
        String nombreArchivo;
        String rutaArchivo = "";
        try {
            do {
                nombreArchivo = JOptionPane.showInputDialog(Mensajes.PEDIR_NOMBRE_ARCHIVO);
                rutaArchivo = String.format(Mensajes.RUTA_ARCHIVO, todaysDate, "/", nombreArchivo);
                File archivo = new File(rutaArchivo);
                if (archivo.exists()) {
                    String decision = JOptionPane.showInputDialog(Mensajes.CONFIRMACION_SOBREESCRITURA);
                    if (decision.equalsIgnoreCase(Mensajes.CONFIRMACION)) {
                        archivo.createNewFile();
                        nombreIngresadoCorrectamente = true;
                    } else if (decision.equalsIgnoreCase(Mensajes.NEGACION))
                        JOptionPane.showMessageDialog(null, "Regresando al menu anterior");
                    else JOptionPane.showMessageDialog(null, "Ingrese una opcion valida en el menu");
                } else {
                    archivo.createNewFile();
                    nombreIngresadoCorrectamente = true;
                }

            } while (!nombreIngresadoCorrectamente);
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error fatal al crear Archivo");
        }
        return rutaArchivo;

    }


    @Override
    public void run() {
        generarArchivo();
    }
}
