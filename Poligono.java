import java.io.Serializable;

public abstract class Poligono implements Serializable {

    private String nombre;

    public Poligono(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();
    
    public String toString() {
        return "Poligono tipo " + nombre;
    }
}
