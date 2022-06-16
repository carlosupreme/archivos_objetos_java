import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreadorArchivo {
    private ObjectOutputStream flujoObjetoSalida;
    private FileOutputStream flujoArchivoSalida;

    public CreadorArchivo(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        if (archivo.exists())
        // el segundo argumento pasado al constructor permite mantener el archivo como
        // esta, si no se le pasa true entonces vacia el archivo.
            flujoArchivoSalida = new FileOutputStream(archivo, true);
        else
            flujoArchivoSalida = new FileOutputStream(archivo);

        flujoObjetoSalida = new ObjectOutputStream(flujoArchivoSalida);
    }

    public void cerrarArchivo() throws IOException {
        flujoObjetoSalida.close();
        
    }

    public void escribirPoligonosBase() throws IOException, Exception {
        Circulo circulo = new Circulo("circulo", random(10));
        Cuadrado cuadrado = new Cuadrado("cuadrado", random(15));
        Pentagono pentagono = new Pentagono("pentagono", random(8));
        Triangulo triangulo = new Triangulo("triangulo", random(6), random(50),
                random(35));
        Triangulo triangulo2 = new Triangulo("triangulo", random(9), random(44),
                random(56), random(10));

        flujoObjetoSalida.writeObject(circulo);
        flujoObjetoSalida.writeObject(cuadrado);
        flujoObjetoSalida.writeObject(pentagono);
        flujoObjetoSalida.writeObject(triangulo);
        flujoObjetoSalida.writeObject(triangulo2);
    }

    public void escribirCuerposBase() throws Exception {
        Prisma prisma = new Prisma(new Circulo("circulo", 10), 20);
        Prisma prisma2 = new Prisma(new Cuadrado("cuadrado", 10), 20);
        Piramide piramide = new Piramide(new Triangulo("triangulo", 10, 10, 10), 20);
        Piramide piramide2 = new Piramide(new Pentagono("pentagono", 10), 20);

        flujoObjetoSalida.writeObject(prisma);
        flujoObjetoSalida.writeObject(prisma2);
        flujoObjetoSalida.writeObject(piramide);
        flujoObjetoSalida.writeObject(piramide2);
    }

    public void agregarCuerpo(CuerpoGeometrico cuerpoG) throws IOException {
        flujoObjetoSalida.writeObject(cuerpoG);
    }

    public void agregarPoligono(Poligono poligono) throws IOException {
        flujoObjetoSalida.writeObject(poligono);
    }

    private double random(int limite){
        double numero = (Math.random() * (limite - 1)) + 1;
        return (double)Math.round(((numero) * 100)/100);
    }
}
