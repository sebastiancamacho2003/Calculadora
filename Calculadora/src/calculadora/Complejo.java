package calculadora;

import java.util.Scanner;

public class Complejo {

    private double real;
    private double imaginaria;

    public Complejo() {
    }

    public Complejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginaria() {
        return imaginaria;
    }

    public void setImaginaria(double imaginaria) {
        this.imaginaria = imaginaria;
    }

    public Complejo suma(Complejo ncomplejo) {
        Complejo complejo = new Complejo();
        double nreal = this.real + ncomplejo.getReal();
        double nimaginario = this.imaginaria + ncomplejo.getImaginaria();

        complejo.setReal(nreal);
        complejo.setImaginaria(nimaginario);

        return complejo;
    }

    public Complejo restar(Complejo ncomplejo) {
        Complejo complejo = new Complejo();
        double nreal = this.real - ncomplejo.getReal();
        double nimaginario = this.imaginaria - ncomplejo.getImaginaria();

        complejo.setReal(nreal);
        complejo.setImaginaria(nimaginario);

        return complejo;
    }

    public Complejo multiplicar(Complejo ncomplejo) {
        Complejo complejo = new Complejo();

        double nreal = this.real * ncomplejo.getReal() - this.getImaginaria() * ncomplejo.getImaginaria();

        double nimaginario = this.real * ncomplejo.getImaginaria() + this.imaginaria * ncomplejo.getReal();

        complejo.setReal(nreal);
        complejo.setImaginaria(nimaginario);

        return complejo;
    }

    public Complejo dividir(Complejo ncomplejo) {
        Complejo complejo = new Complejo();

        double nreal = (this.real * ncomplejo.getReal() + this.imaginaria
                + ncomplejo.getImaginaria()) / (ncomplejo.getReal() * ncomplejo.getReal()
                + ncomplejo.getImaginaria() * ncomplejo.getImaginaria());

        double nimaginario = (this.imaginaria * ncomplejo.getReal() - this.real
                * ncomplejo.getImaginaria()) / (ncomplejo.getReal() * ncomplejo.getReal()
                + ncomplejo.getImaginaria() * ncomplejo.getImaginaria());

        complejo.setReal(nreal);
        complejo.setImaginaria(nimaginario);

        return complejo;
    }

    public static Complejo conjugado(Complejo ncomplejo) {

        return new Complejo(ncomplejo.getReal(), -ncomplejo.getImaginaria());

    }

    public static double Norma(Complejo ncomplejo) {

        double nNorma = Math.sqrt(ncomplejo.getReal() * ncomplejo.getReal() + ncomplejo.getImaginaria() * ncomplejo.getImaginaria());

        return nNorma;

    }

    public String toString() {
        return String.format("(%.2f, %.2fi)", real, imaginaria);
    }

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        double a, b, c, d;

        System.out.println("Digite la parte entera del primer numero: ");
        a = dato.nextDouble();
        System.out.println("Digite la parte imaginaria del primer numero: ");
        b = dato.nextDouble();

        System.out.println("Digite la parte entera del segundo numero: ");
        c = dato.nextDouble();
        System.out.println("Digite la parte imaginaria del segundo numero: ");
        d = dato.nextDouble();

        Complejo c1 = new Complejo(a, b);
        Complejo c2 = new Complejo(c, d);

        System.out.println("El primer numero es: " + c1);
        System.out.println("El segundo numero es: " + c2);

        int f;

        System.out.println("Esocja la operacion a realizar: "
                + "\n1. Suma" + "\n2. Resta" + "\n3. Multiplicacion" + "\n4. Division" + "\n5. Conjugado" + "\n6. Norma");

        f = dato.nextInt();
        switch (f) {

            case 1:
                System.out.println("El resultado de la suma es: " + c1.suma(c2));
                break;
            case 2:
                System.out.println("El resultado de la resta es: " + c1.restar(c2));
                break;
            case 3:
                System.out.println("El resultado de la multiplicacion es: " + c1.multiplicar(c2));
                break;
            case 4:
                System.out.println("El resultado de la division es: " + c1.dividir(c2));
                break;
            case 5:
                System.out.println("El conjugado 1 es: " + conjugado(c1));
                System.out.println("El conjugado 2 es: " + conjugado(c2));
                break;
            case 6:
                System.out.println("La norma del primer complejo es: " + Norma(c1));
                System.out.println("La norma del primer complejo es: " + Norma(c2));
                break;
            default:
                System.out.println("Ingreso una opcion invalida");
        }

    }
}
