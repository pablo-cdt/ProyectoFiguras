package figuras;

import interfaces.IMedidas;

public class Circulo implements IMedidas {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularPerimetro() {
        return Math.PI * (this.radio * 2);
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public String toString() {
        return "Figura seleccionada: Circulo" +
                "\nradio ingresado = " + radio +
                "\nperimetro = " + calcularPerimetro() +
                "\narea = " + calcularArea();
    }
}
