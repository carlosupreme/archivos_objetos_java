public class Circulo  extends Poligono {
    private double radio;

    public Circulo(String nombre, double radio) throws Exception {
        super(nombre);
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) throws Exception {
        if (radio < 1)
            throw new Exception("El radio debe ser mayor a 0");

        this.radio = radio;
    }

    public double calcularArea() {
        // Formula --> PI * radio al cuadrado
        return Math.PI * (radio * radio);
    }

    public double calcularPerimetro() {
        //Formula --> PI * DIAMETRO
        return Math.PI * radio * 2;
    }

    @Override
    public String toString() {
        return super.toString() + " con\nRadio = " + radio + "\nArea = " + calcularArea() + "\nPerimetro = " + calcularPerimetro();
    }
}
