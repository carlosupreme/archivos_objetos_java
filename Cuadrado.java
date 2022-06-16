public class Cuadrado extends Poligono {
    private double lado;

    public Cuadrado(String nombre, double lado) throws Exception {
        super(nombre);
        if (lado < 1)
            throw new Exception("El lado debe ser mayor a 0");

        this.lado = lado;
    }

    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public String toString() {
        return super.toString() + " con\n4 lados de = " + lado + "\nArea = " + calcularArea() + "\nPerimetro = "
                + calcularPerimetro();
    }
}
