package services;

import constants.Mensajes;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class GenerarMenuService implements Runnable {
    public void generarMenu() {
        boolean hasPassed = false;
        do {
            String eleccionInicial = JOptionPane.showInputDialog(Mensajes.MENU_INICIAL);
            switch (eleccionInicial) {
                case "1":
                    CalculosFiguraService.calcularFiguras();
                    break;
                case "2":
                    AbrirArchivosService.run();
                    break;
                case "3":
                    hasPassed = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
            }
        }while(!hasPassed);

    }
    public void crearCarpeta() {
        LocalDate date = LocalDate.now();

        String filepath = String.format("./Calculos/%s",date);
        File nuevaCarpeta = new File(filepath);

        if (!nuevaCarpeta.exists()) {
            nuevaCarpeta.mkdir();
        }

    }

    @Override
    public void run(){
        crearCarpeta();
        generarMenu();
    }
}
