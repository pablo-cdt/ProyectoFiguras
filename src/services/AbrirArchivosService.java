package services;

import java.io.File;
import java.time.LocalDate;

public class AbrirArchivosService {
    public static void run(){
        File directorio = new File("./Calculos/");
        String[] carpetas = directorio.list();
        for(String carpeta : carpetas) {
            System.out.println("archivo = " + carpeta);
        }



    }
}
