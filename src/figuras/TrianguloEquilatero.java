package figuras;

import abstracts.Triangulo;
import interfaces.IMedidas;

public class TrianguloEquilatero extends Triangulo implements IMedidas {

    private double lado;

    public TrianguloEquilatero(Double lado) {
        this.lado = lado;
        this.altura = calcularAltura();
    }

    @Override
    public double calcularAltura() {
        return ((Math.sqrt(3)*this.lado) / 2);
    }

    @Override
    public double calcularPerimetro() {
        return this.lado * 3;
    }

    @Override
    public double calcularArea() {
        return ((lado * altura)/2);
    }

    @Override
    public String toString() {
        return "Figura seleccionada: TrianguloEquilatero" +
                "\nlado ingresado = " + lado +
                "\naltura calculada = " + altura +
                "\nperimetro = " + calcularPerimetro() +
                "\narea = " + calcularArea();
    }
}
