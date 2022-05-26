package Figuras;

import java.text.DecimalFormat;

abstract class Figura {
    protected abstract double calcularArea();

    protected abstract double calcularPerimetro();

    protected abstract void imprimir();

}

class Circulo extends Figura {
    protected double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    protected double calcularArea() {
        return (Math.PI * Math.pow(radio, 2));
    }

    @Override
    protected double calcularPerimetro() {
        return (2 * Math.PI * radio);
    }

    @Override
    protected void imprimir() {
        System.out.println("CIRCULO:");
        System.out.println("Radio: " + this.radio);
    }
}

class Semicirculo extends Figura {
    protected double radio;

    public Semicirculo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return (Math.PI * Math.pow(radio, 2)) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return (2 * Math.PI * radio) / 2;
    }

    @Override
    protected void imprimir() {
        System.out.println("SEMICIRCULO:");
        System.out.println("Radio: " + this.radio);
    }
}

class Rectangulo extends Figura {
    protected double base;
    protected double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    protected void imprimir() {
        System.out.println("RECTANGULO:");
        System.out.println("Base: " + this.base + "\nAltura: " + this.altura);
    }
}

class Triangulo extends Figura {
    protected double base;
    protected double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 0;
    }

    @Override
    protected void imprimir() {
        System.out.println("TRIANGULO:");
        System.out.println("Base: " + this.base + "\nAltura: " + this.altura);
    }
}

class FiguraAbstracta extends Figura {

    Figura[] composicion;

    public FiguraAbstracta(Figura[] composicion) {
        this.composicion = composicion;
    }

    @Override
    public double calcularArea() {
        double result = 0;
        for (int i = 0; i < composicion.length; i++) {
            result += composicion[i].calcularArea();
        }
        return result;
    }

    @Override
    public double calcularPerimetro() {
        double result = 0;
        for (int i = 0; i < composicion.length; i++) {
            if (composicion[i].getClass() == Rectangulo.class) {
                Rectangulo r = (Rectangulo) composicion[i];
                result += composicion[i].calcularPerimetro() - r.altura * 2;
            } else {
                result += composicion[i].calcularPerimetro();
            }
        }
        return result;
    }

    @Override
    public void imprimir() {
        System.out.println("-- COMPOSICIÓN DE LA FIGURA --");
        for (int i = 0; i < composicion.length; i++) {
            composicion[i].imprimir();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");

        FiguraAbstracta uno = new FiguraAbstracta(new Figura[]{new Semicirculo(2.5), new Semicirculo(2.5), new Rectangulo(10, 10)});
        uno.imprimir();
        double area = uno.calcularArea();
        System.out.println("El area de la figura es: " + df.format(area));
        double perimetro = uno.calcularPerimetro();
        System.out.println("El perimetro de la figura es: " + df.format(perimetro));

        FiguraAbstracta dos = new FiguraAbstracta(new Figura[]{new Semicirculo(6), new Rectangulo(22, 12),
                new Triangulo(22, 10), new Triangulo(22, 10)});
        dos.imprimir();
        double area2 = dos.calcularArea();
        System.out.println("El area de la figura es: " + df.format(area2));
    }
}

