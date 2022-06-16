import java.util.ArrayList;
import java.io.IOException;

public class Prueba {
    public static void main(String[] args) {
        // LeerTeclado lector = new LeerTeclado();
        try {
            CreadorArchivo t = new CreadorArchivo("poligonos.txt");
            t.escribirPoligonosBase();
            t.cerrarArchivo();

            CreadorArchivo t2 = new CreadorArchivo("cuerpos.txt");
            t2.escribirCuerposBase();
            t2.cerrarArchivo();

            LectorArchivo l = new LectorArchivo("poligonos.txt");
            ArrayList<Poligono> poligonos = l.leerPoligonos();
            
            for (Poligono c : poligonos) {
                System.out.println(c + "\n------------------");
            }

            LectorArchivo l2 = new LectorArchivo("cuerpos.txt");
            ArrayList<CuerpoGeometrico> cuerpos = l2.leerCuerpos();
            
            for (CuerpoGeometrico c : cuerpos) {
                System.out.println(c + "\n-------------");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.toString());
        }

    }
}
