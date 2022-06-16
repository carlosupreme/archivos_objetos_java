import java.io.Serializable;

public abstract class CuerpoGeometrico implements Serializable{
    protected Poligono base;
    protected double altura;

    public CuerpoGeometrico(Poligono base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public abstract double calcularVolumen();

    public Poligono getBase() {
        return base;
    }

    public void setBase(Poligono base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String toString() {
        return "Cuerpo geometrico\n Datos de su base: " + base.toString() +"\nAltura del cuerpo = " + altura + "\nVolumen = " + calcularVolumen();  
    }
}
