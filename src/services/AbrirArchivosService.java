package services;

import constants.Mensajes;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AbrirArchivosService {
    public static void run(){
        File directorio = new File(Mensajes.RUTA_BASE_CARPETA);
        String[] carpetas = directorio.list();
        int eleccion = 0;
        int i = 0;
        StringBuilder sb;
        String rutaFinalArchivo = "";

        boolean valorIngresadoCorrecto = false;
        do {
            try {
                sb = new StringBuilder(Mensajes.MENU_ELECCION_CARPETA);
                eleccion = Integer.parseInt(JOptionPane.showInputDialog(imprimirCarpetas(carpetas,sb,i)));
                valorIngresadoCorrecto = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
            }
        }while(!valorIngresadoCorrecto);
        rutaFinalArchivo = rutaFinalArchivo.concat(Mensajes.RUTA_CARPETA_BASE);
        rutaFinalArchivo = rutaFinalArchivo.concat(carpetas[eleccion]);
        rutaFinalArchivo = rutaFinalArchivo.concat(Mensajes.DOUBLE_BACKSLASH);

        directorio = new File(Mensajes.RUTA_BASE_CARPETA + carpetas[eleccion] + "/");
        carpetas = directorio.list();

        sb = new StringBuilder(Mensajes.MENU_ELECCION_ARCHIVOS_DISPONIBLES);

        imprimirListadoArchivos(carpetas,sb);

        String archivosIngresados = JOptionPane.showInputDialog(sb);
        String[] arrayArchivos = archivosIngresados.split(",");

        abrirArchivos(arrayArchivos, rutaFinalArchivo);

    }
    private static StringBuilder imprimirCarpetas(String[] carpetas, StringBuilder sb, int i){
        for(String carpeta : carpetas) {
            sb.append(String.format(Mensajes.FORMATO_LISTA,i, carpeta));
            i++;
        }

        return sb;
    }

    private static StringBuilder imprimirListadoArchivos(String[] archivos, StringBuilder sb){
        for(String archivo : archivos) {
            sb.append(String.format(Mensajes.FORMATO_LISTA_SIN_NUMERO, archivo));
        }

        return sb;
    }
    private static void abrirArchivos(String[] listaArchivos,String rutaArchivo){
        Runtime runtime = Runtime.getRuntime();
        try {
            for (int i = 0; i < listaArchivos.length; i++) {
                String rutaArchivoAux = rutaArchivo.concat(listaArchivos[i]);
                String command = "notepad ";
                command = command.concat(rutaArchivoAux);
                runtime.exec(command);
            }/*
            for (String archivo : listaArchivos) {
                rutaArchivo.concat(archivo);
                System.out.println(rutaArchivo);
                runtime.exec("notepad " + rutaArchivo);
            }*/
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error fatal al abrir archivos");
        }
    }
}
