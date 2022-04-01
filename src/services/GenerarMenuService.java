package services;

import constants.Mensajes;

import javax.swing.*;

public class GenerarMenuService implements Runnable {
    public void iniciarMenu() {
    String eleccionInicial = JOptionPane.showInputDialog(Mensajes.MENU_INICIAL);
    switch (eleccionInicial){
        case "1":
            CalculosFiguraService.calcularFiguras();
            break;
        case "2":
            AbrirArchivosService.run();
            break;
        default:
            JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
    }


    }

    @Override
    public void run() {
        iniciarMenu();
    }
}
