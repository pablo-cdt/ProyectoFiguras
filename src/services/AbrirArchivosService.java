package services;

import java.io.File;
import java.time.LocalDate;

public class AbrirArchivosService {
    public static void run(){
        /*
        File crearArchivo = new File(nuevaCarpeta,"Hola Mundo.txt");
        crearArchivo.createNewFile();
        System.out.println("Archivo creado = " + crearArchivo);
        */

        File directorio = new File("./Calculos/");
        String[] carpetas = directorio.list();
        for(String carpeta : carpetas) {
            System.out.println("archivo = " + carpeta);
        }



    }
    public void crearCarpeta() {
        LocalDate date = LocalDate.now();

        String filepath = String.format("./Calculos/%s",date);
        File nuevaCarpeta = new File(filepath);

        if (!nuevaCarpeta.exists()) {
            boolean carpetaCreada = nuevaCarpeta.mkdir();
            System.out.println("carpetaCreada = " + carpetaCreada);
         }

    }
}
