public class Pentagono extends Poligono {
    private double lado;
    private double apotema;

    public Pentagono(String nombre, double lado) throws Exception {
        super(nombre);
        if(lado < 1)
            throw new Exception("El lado no puede ser menor a 1");
        this.lado = lado;
        calcularApotema();
    }

    public double calcularArea() {
        return (apotema * calcularPerimetro()) / 2;
    }

    public double calcularPerimetro() {
        return 5 * lado;
    }

    public void calcularApotema() {
        final double TAN36GRADOS = Math.tan(Math.toRadians(36));
        apotema = lado / (2 * TAN36GRADOS);
    }

    public double getApotema() {
        return apotema;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public String toString() {
        return super.toString() + " con\n5 lados de = " + lado + "\nApotema = " + apotema + "\nArea = " + calcularArea()
                + "\nPerimetro = " + calcularPerimetro();
    }
}
