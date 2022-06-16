import java.io.*;
import java.util.ArrayList;

public class LectorArchivo {
    private ObjectInputStream flujoObjetoEntrada;
    private FileInputStream flujoArchivoEntrada;

    public LectorArchivo(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        flujoArchivoEntrada = new FileInputStream(archivo);
        flujoObjetoEntrada = new ObjectInputStream(flujoArchivoEntrada);
    }

    public ArrayList<CuerpoGeometrico> leerCuerpos() throws IOException, ClassNotFoundException {
        ArrayList<CuerpoGeometrico> cuerposGeometricos = new ArrayList<CuerpoGeometrico>();

        while (true) {
            try {
                cuerposGeometricos.add((CuerpoGeometrico) flujoObjetoEntrada.readObject());
            } catch (Exception ex) {
                break;
                // Si cae aca es porque acabo el archivo
            }
        }

        flujoObjetoEntrada.close();
        return cuerposGeometricos;
    }

    public ArrayList<Poligono> leerPoligonos() throws IOException, ClassNotFoundException {
        ArrayList<Poligono> poligonos = new ArrayList<Poligono>();

        while (true) {
            try {
                poligonos.add((Poligono) flujoObjetoEntrada.readObject());
            } catch (Exception ex) {
                break;
                // Si cae aca es porque acabo el archivo
            }
        }

        flujoObjetoEntrada.close();
        return poligonos;
    }

    // retorna un estimado de bytes que hay en el archivo
    public int bytes() throws IOException {
        return flujoObjetoEntrada.available();
    }
}
