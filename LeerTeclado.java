import javax.swing.JOptionPane;

public class LeerTeclado {

    public static String leerString(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    public static int leerInt(String mensaje) {
        return Integer.parseInt(leerString(mensaje));
    }

    public static double leerDouble(String mensaje) {
        return Double.parseDouble(leerString(mensaje));
    }

    public static char leerChar(String mensaje) throws ArrayIndexOutOfBoundsException {
        return leerString(mensaje).toCharArray()[0];
    }

    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static String leerOpcion(String mensaje, String[] opciones) throws Exception {
        return (String) JOptionPane.showInputDialog(null, mensaje, "Selecciona una opcion", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }

    public static int menu() {
        return leerInt(
                "--------------MENU----------------\n" +
                "0.-  Salir\n" +
                "1.-  Agregar una Piramide\n" +
                "2.-  Agregar un nuevo Prisma\n" +
                "3.-  Agregar un Trangulo\n" +
                "4.-  Agregar un Cuadrado\n" +
                "5.-  Agregar un Pentagono\n" +
                "6.-  Agregar un círculo\n" +
                "7.-  Mostrar todos los cuerpos geometrico\n" +
                "8.-  Mostrar todos los polígonos\n" +
                "9.-  Mostrar los poligonos cuya área sea menor de x\n" +
                "10.- Mostrar todos los Cuerpos geometricos cuyo volumen sea mayor de x\n" +
                "\nINGRESA UN NUMERO DEL 0 AL 10"
            );
    }
}
