package figuras;

import abstracts.Triangulo;
import interfaces.IMedidas;

public class TrianguloIsosceles extends Triangulo implements IMedidas {

    private double lado;
    private double base;

    public TrianguloIsosceles(double base, double lado) {
        this.base = base;
        this.lado = lado;
        this.altura = calcularAltura();
    }

    @Override
    public double calcularAltura() {
        return Math.sqrt(Math.pow(this.lado,2) - (Math.pow(this.base,2)/4));
    }

    @Override
    public double calcularPerimetro() {
        return (this.lado * 2) + this.base;
    }

    @Override
    public double calcularArea() {
        return (altura * this.base) /2;
    }

    @Override
    public String toString() {
        return "Figura seleccionada: TrianguloEquilatero" +
                "\nlado ingresado = " + lado +
                "\nbase ingresada = " + base +
                "\naltura calculada = " + altura +
                "\nperimetro = " + calcularPerimetro() +
                "\narea = " + calcularArea();
    }
}
