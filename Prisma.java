public class Prisma extends CuerpoGeometrico {
    public Prisma(Poligono base, double altura){
        super(base, altura);
    }

    public double calcularVolumen() {
        return base.calcularArea() * altura;
    }
}
