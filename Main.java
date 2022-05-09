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
    public double calcularArea() {
        return (Math.PI * Math.pow(radio, 2));
    }

    @Override
    public double calcularPerimetro() {
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

class FiguraAbstracta {

    Figura[] composicion;

    public FiguraAbstracta(Figura[] composicion) {
        this.composicion = composicion;
    }

    public double areaTotal() {
        double result = 0;
        for (int i = 0; i < composicion.length; i++) {
            result += composicion[i].calcularArea();
        }
        return result;
    }

    public double perimetroTotal() {
        double result = 0;
        for (int i = 0; i < composicion.length; i++) {
            result += composicion[i].calcularPerimetro();
        }
        return result;
    }

    public void imprimirTodo() {
        System.out.println("-- COMPOSICIÓN DE LA FIGURA --");
        for (int i = 0; i < composicion.length; i++) {
            composicion[i].imprimir();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");

        FiguraAbstracta figura1 = new FiguraAbstracta(new Figura[]{new Circulo(2.5), new Rectangulo(10, 5)});
        figura1.imprimirTodo();
        double area = figura1.areaTotal();
        System.out.println("El area de la figura es: " + df.format(area));
        double perimetro = figura1.perimetroTotal();
        System.out.println("El perimetro de la figura es: " + df.format(perimetro));

        FiguraAbstracta figura2 = new FiguraAbstracta(new Figura[]{new Semicirculo(6), new Rectangulo(22, 12),
                new Triangulo(22, 10), new Triangulo(22, 10)});
        figura2.imprimirTodo();
        double area2 = figura2.areaTotal();
        System.out.println("El area de la figura es: " + df.format(area2));

    }
}

