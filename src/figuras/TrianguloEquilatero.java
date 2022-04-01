package figuras;

import abstracts.Triangulo;
import interfaces.IMedidas;

public class TrianguloEquilatero extends Triangulo implements IMedidas {

    private double lado;
    private double altura;

    public TrianguloEquilatero(Double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularAltura() {
        this.altura = ((Math.sqrt(3)*this.lado) / 2);
        return this.altura;
    }

    @Override
    public double calcularPerimetro() {
        return this.lado * 3;
    }

    @Override
    public double calcularArea() {
        return ((lado * calcularAltura())/2);
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
