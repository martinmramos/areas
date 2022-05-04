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

    public Circulo() {
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

    public Rectangulo() {
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

    public Triangulo() {
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
        System.out.println("Base: " + this.base + "\nAltura: " + this.altura);
    }
}

class FiguraAbstracta {

    DecimalFormat df = new DecimalFormat("#.##");
    private double base;
    private double diametro;
    private double altura;
    Rectangulo r = new Rectangulo();
    Circulo c = new Circulo();
    Triangulo t = new Triangulo();

    public FiguraAbstracta(double base, double diametro) {
        this.base = base;
        this.diametro = diametro;
    }

    public FiguraAbstracta(double base, double diametro, double altura) {
        this.base = base;
        this.diametro = diametro;
        this.altura = altura;
    }

    public void datosFigura() {
        r.base = this.base;
        r.altura = this.diametro;
        c.radio = this.diametro / 2;
        t.base = this.base;
        t.altura = this.altura;
    }

    public double area() {
        datosFigura();
        double area1 = r.calcularArea();
        double area2 = c.calcularArea();
        double area3 = t.calcularArea();
        double areaTotal = area1 + area2 + area3;
        return areaTotal;
    }

    public double perimetro() {
        datosFigura();
        double perimetro1 = r.calcularPerimetro();
        double perimetro2 = c.calcularPerimetro();
        double perimetro3 = t.calcularPerimetro();
        double perimetroTotal = perimetro1 + perimetro2 + perimetro3;
        return perimetroTotal;
    }

    public void imprimir() {
        datosFigura();
        System.out.println("LOS DATOS DE LA FIGURA SON:");
        if (r.base > 0) {
            System.out.println("-RECTANGULO-");
            r.imprimir();
        }
        if (c.radio > 0) {
            System.out.println("-CIRCULO-");
            c.imprimir();
        }
        if (t.altura > 0) {
            System.out.println("-TRIANGULO-");
            t.imprimir();
        } else {
            System.out.println("El perimetro total es: " + df.format(perimetro()));
        }
        System.out.println("El área total es: " + df.format(area()));
    }
}

public class Main {
    public static void main(String[] args) {
        FiguraAbstracta uno = new FiguraAbstracta(10, 5);
        uno.imprimir();

        FiguraAbstracta dos = new FiguraAbstracta(22, 12, 10);
        dos.imprimir();
    }
}

