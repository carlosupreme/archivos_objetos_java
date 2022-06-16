import java.util.Vector;

public class Lista {
    private Vector<Poligono> poligonos;
    private Vector<CuerpoGeometrico> cuerposGeometricos;

    public Lista() {
        poligonos = new Vector<Poligono>();
        cuerposGeometricos = new Vector<CuerpoGeometrico>();
    }

    public void agregarCuerpoGeometrico(CuerpoGeometrico c) {
        cuerposGeometricos.add(c);
    }

    public void agregarPoligono(Poligono p) {
        poligonos.add(p);
    }

    public Vector<CuerpoGeometrico> getCuerposGeometricos() {
        Vector<CuerpoGeometrico> lista = new Vector<CuerpoGeometrico>();
        for (CuerpoGeometrico cuerpoGeometrico : cuerposGeometricos) {
            lista.add(cuerpoGeometrico);
        }

        return lista;
    }

    public Vector<Poligono> getPoligonos() {
        Vector<Poligono> lista = new Vector<Poligono>();
        for (Poligono poligono : poligonos) {
            lista.add(poligono);
        }

        return lista;
    }

    public Vector<Poligono> poligonosAreaMenor(double area) {
        Vector<Poligono> lista = new Vector<Poligono>();
        for (Poligono poligono : poligonos) {
            if (poligono.calcularArea() < area)
                lista.add(poligono);
        }

        return lista;
    }

    public Vector<CuerpoGeometrico> cuerposVolumenMayor(double volumen) {
        Vector<CuerpoGeometrico> lista = new Vector<CuerpoGeometrico>();
        for (CuerpoGeometrico cuerpoGeometrico : cuerposGeometricos) {
            if (cuerpoGeometrico.calcularVolumen() > volumen)
                lista.add(cuerpoGeometrico);
        }

        return lista;
    }

}