package services;

import constants.Mensajes;
import constants.ProcesosEnum;
import constants.TipoFigurasEnum;
import excepciones.ProcesoInterrumpidoException;
import figuras.*;
import interfaces.IMedidas;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CalculosFiguraService {

    public static void calcularFiguras() {
        Thread t2;
        ProcesosEnum procesoActual = ProcesosEnum.INGRESO_FIGURA;
        TipoFigurasEnum figura = null;
        boolean procesoCompletado = false;
        StringBuilder sb = new StringBuilder(Mensajes.INGRESO_OPCION_FIGURA);
        TipoFigurasEnum[] figuras = TipoFigurasEnum.values();
        IMedidas figuraElegida;

        for(TipoFigurasEnum f : figuras) {
            sb.append(String.format(Mensajes.FORMATO_OPCIONES_FIGURAS, f.getOpcion(), f.getNombre()));
        }

        do {
            try {
                switch (procesoActual) {
                    case INGRESO_FIGURA:
                        figura = getNombre(sb.toString());

                    case INGRESO_VALORES:
                        // TODO: Pedir valores para los cálculos
                        switch (figura){
                            case CIRCULO:
                                sb = new StringBuilder(String.format(Mensajes.INGRESO_RADIO, Mensajes.UNIDAD_MEDIDA_CM));
                                double radio = Double.parseDouble(JOptionPane.showInputDialog(sb));
                                figuraElegida = new Circulo(radio);
                                t2 = new Thread(new GuardarCalculosService(figuraElegida));
                                t2.start();
                                break;
                            case CUADRADO:
                                sb = new StringBuilder(String.format(Mensajes.INGRESO_LADO,Mensajes.UNIDAD_MEDIDA_CM));
                                double lado = Double.parseDouble(JOptionPane.showInputDialog(sb));
                                figuraElegida = new Cuadrado(lado);
                                t2 = new Thread(new GuardarCalculosService(figuraElegida));
                                t2.start();
                                break;
                            case RECTANGULO:
                                sb = new StringBuilder(String.format(Mensajes.INGRESO_BASE,Mensajes.UNIDAD_MEDIDA_CM));
                                double base = Double.parseDouble(JOptionPane.showInputDialog(sb));
                                sb = new StringBuilder(String.format(Mensajes.INGRESO_ALTURA,Mensajes.UNIDAD_MEDIDA_CM));
                                double altura = Double.parseDouble(JOptionPane.showInputDialog(sb));
                                figuraElegida = new Rectangulo(base, altura);
                                t2 = new Thread(new GuardarCalculosService(figuraElegida));
                                t2.start();
                                break;
                            case TRIANGULO_ISOSCELES:
                                sb = new StringBuilder(String.format(Mensajes.INGRESO_BASE,Mensajes.UNIDAD_MEDIDA_CM));
                                base = Double.parseDouble(JOptionPane.showInputDialog(sb));
                                sb = new StringBuilder(String.format(Mensajes.INGRESO_LADO,Mensajes.UNIDAD_MEDIDA_CM));
                                lado = Double.parseDouble(JOptionPane.showInputDialog(sb));
                                figuraElegida = new TrianguloIsosceles(base, lado);
                                t2 = new Thread(new GuardarCalculosService(figuraElegida));
                                t2.start();
                                break;
                            case TRIANGULO_EQUILATERO:
                                sb = new StringBuilder(String.format(Mensajes.INGRESO_LADO,Mensajes.UNIDAD_MEDIDA_CM));
                                lado = Double.parseDouble(JOptionPane.showInputDialog(sb));
                                figuraElegida = new TrianguloEquilatero(lado);
                                t2 = new Thread(new GuardarCalculosService(figuraElegida));
                                t2.start();
                                break;
                        }
                }
                procesoCompletado = true;
            } catch (ProcesoInterrumpidoException ex) {
                procesoActual = ex.getProceso();
                if (ex.getMessage() != null) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
            }catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor no vacio");
            }
        } while (!procesoCompletado);
    }

    public static TipoFigurasEnum getNombre(String mensaje) throws ProcesoInterrumpidoException {
        try {
            String opcionFigura = JOptionPane.showInputDialog(mensaje);

            if (opcionFigura == null) {
                throw new NullPointerException();
            }

            int opcion = Integer.parseInt(opcionFigura);
            return Stream.of(TipoFigurasEnum.values()).filter(f -> f.getOpcion() == opcion).findFirst().orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException | NumberFormatException ex) {
            throw new ProcesoInterrumpidoException("Nombre de figura inválido", ProcesosEnum.INGRESO_FIGURA);
        } catch (NullPointerException ex) {
            int opcionUsuario = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?");

            if(opcionUsuario == 0) {
                System.exit(0);
            }

            throw new ProcesoInterrumpidoException(ProcesosEnum.INGRESO_FIGURA);
        }
    }
}
