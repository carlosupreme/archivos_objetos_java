public class Piramide extends CuerpoGeometrico {

    public Piramide(Poligono base, double altura) {
        super(base, altura);
    }

    public double calcularVolumen() {
        //formula -> area de la base * altura / 3
        return (base.calcularArea() * altura) / 3;
    }
}
