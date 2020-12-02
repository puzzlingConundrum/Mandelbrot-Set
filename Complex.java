public class Complex {
    double real, imaginary;

    public Complex() {
        real = 0.0;
        imaginary = 0.0;
    }

    public Complex(double r, double i) {
        real = r;
        imaginary = i;
    }

    public static Complex multiply(Complex c1, Complex c2) {
        double RePart = c1.real*c2.real - c1.imaginary*c2.imaginary;
        double ImPart = c1.real*c2.imaginary + c1.imaginary*c2.real;
        return new Complex(RePart, ImPart);
    }

    public static Complex scalarMultiply(Complex c, double scalar) {
        return new Complex(c.real*scalar, c.imaginary*scalar);
    }

    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.real+c2.real, c1.imaginary+c2.imaginary);
    }

    public static Complex substract(Complex c1, Complex c2) {
        return add(c1, scalarMultiply(c2, -1));
    }

    public double abs() {
        return Math.sqrt(real*real + imaginary*imaginary);
    }

    public void set(Complex c) {
        real = c.real;
        imaginary = c.imaginary;
    }

    public void set(double r, double i) {
        real = r;
        imaginary = i;
    }

    public String toString() {
        return String.format("%f + %fi", real, imaginary);
    }
}
