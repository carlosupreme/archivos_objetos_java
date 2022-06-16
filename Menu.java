
public class Menu {
    private CreadorArchivo archivoPoligonos;
    private CreadorArchivo archivoCuerpos;

    public Menu() {
        try {
            archivoPoligonos = new CreadorArchivo("poligonos.txt");
            archivoCuerpos = new CreadorArchivo("cuerpos.txt");
            System.out.println((new LectorArchivo("poligonos.txt")).bytes());
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Lista lista = new Lista();
        int opcion = -1;
        menu.rellenarLista(lista);

        while (opcion != 0) {
            try {
                opcion = LeerTeclado.menu();
                if (opcion < 0 || opcion > 10)
                    throw new Exception("Elige un numero entero de 0 a 10");

                menu.ejecutarOpcion(opcion, lista);

            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Solo numeros");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        try {
            menu.archivoCuerpos.cerrarArchivo();
            menu.archivoPoligonos.cerrarArchivo();
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje("Error al cerrar los archivos");
        }
    }

    private void ejecutarOpcion(int opcion, Lista lista) {
        String mensaje = "";

        try {
            switch (opcion) {
                case 1:
                    crearPiramide(lista);
                    break;
                case 2:
                    crearPrisma(lista);
                    break;
                case 3:
                    Triangulo t = pedirTriangulo();
                    lista.agregarPoligono(t);
                    agregarPoligono(t);
                    break;
                case 4:
                    Cuadrado c = pedirCuadrado();
                    lista.agregarPoligono(c);
                    agregarPoligono(c);
                    break;
                case 5:
                    Pentagono p = pedirPentagono();
                    lista.agregarPoligono(p);
                    agregarPoligono(p);
                    break;
                case 6:
                    Circulo ci = pedirCirculo();
                    lista.agregarPoligono(ci);
                    agregarPoligono(ci);
                    break;
                case 7:
                    mostrarCuerposGeometricos(lista);
                    break;
                case 8:
                    mostrarPoligonos(lista);
                    break;
                case 9:
                    boolean pedirArea = true;
                    mensaje = "";
                    while (pedirArea) {
                        try {
                            double area = LeerTeclado.leerDouble("Area a buscar");
                            if (area < 1)
                                throw new Exception("area negativa invalida");
                            for (Poligono poligono : lista.poligonosAreaMenor(area)) {
                                mensaje += poligono + "\n--------";
                            }
                            pedirArea = false;
                        } catch (NumberFormatException e) {
                            LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
                        } catch (Exception e) {
                            LeerTeclado.mostrarMensaje(e.getMessage());
                        }
                    }
                    break;
                case 10:
                    boolean pedirVolumen = true;
                    mensaje = "";
                    while (pedirVolumen) {
                        try {
                            double volumen = LeerTeclado.leerDouble("volumen a buscar");
                            if (volumen < 1)
                                throw new Exception("volumen negativa invalida");
                            for (CuerpoGeometrico cuerpo : lista.cuerposVolumenMayor(volumen)) {
                                mensaje += cuerpo + "\n--------";
                            }
                            pedirVolumen = false;
                        } catch (NumberFormatException e) {
                            LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
                        } catch (Exception e) {
                            LeerTeclado.mostrarMensaje(e.getMessage());
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje(e.getMessage());
        }

        LeerTeclado.mostrarMensaje(mensaje);
    }

    private void crearPiramide(Lista lista) {
        Poligono poligono = null;
        String nombrePoligono = "";
        boolean pedirPoligono = true, pedirAltura = true;
        double altura = 0.0;
        while (pedirPoligono) {
            try {
                String[] opciones = { "Pentagono", "Cuadrado", "Triangulo", "Circulo" };
                nombrePoligono = LeerTeclado.leerOpcion("Elige un poligono de base para el cuerpo geometrico",
                        opciones);

                if (nombrePoligono == "Pentagono")
                    poligono = pedirPentagono();

                if (nombrePoligono == "Cuadrado")
                    poligono = pedirCuadrado();

                if (nombrePoligono == "Circulo")
                    poligono = pedirCirculo();

                if (nombrePoligono == "Triangulo")
                    poligono = pedirTriangulo();

                pedirPoligono = false;
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        while (pedirAltura) {
            try {
                altura = LeerTeclado.leerDouble("ingresa altura");
                pedirAltura = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }
        Piramide piramide = new Piramide(poligono, altura);
        lista.agregarCuerpoGeometrico(piramide);
        agregarCuerpo(piramide);
        LeerTeclado.mostrarMensaje("Piramide agregada correctamente");
    }

    private void crearPrisma(Lista lista) {
        Poligono poligono = null;
        String nombrePoligono = "";
        boolean pedirPoligono = true, pedirAltura = true;
        double altura = 0.0;
        while (pedirPoligono) {
            try {
                String[] opciones = { "Pentagono", "Cuadrado", "Triangulo", "Circulo" };
                nombrePoligono = LeerTeclado.leerOpcion("Elige un poligono de base para el cuerpo geometrico",
                        opciones);

                if (nombrePoligono == "Pentagono")
                    poligono = pedirPentagono();

                if (nombrePoligono == "Cuadrado")
                    poligono = pedirCuadrado();

                if (nombrePoligono == "Circulo")
                    poligono = pedirCirculo();

                if (nombrePoligono == "Triangulo")
                    poligono = pedirTriangulo();

                pedirPoligono = false;
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        while (pedirAltura) {
            try {
                altura = LeerTeclado.leerDouble("ingresa altura");
                pedirAltura = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }
        Prisma prisma = new Prisma(poligono, altura);
        lista.agregarCuerpoGeometrico(prisma);
        agregarCuerpo(prisma);
        LeerTeclado.mostrarMensaje("Prisma agregada correctamente");
    }

    private Pentagono pedirPentagono() {
        boolean continua = true;
        Pentagono p = null;
        while (continua) {
            try {
                p = new Pentagono("pentagono", LeerTeclado.leerDouble("Ingresa el lado del pentagono"));
                continua = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        return p;
    }

    private Circulo pedirCirculo() {
        boolean continua = true;
        Circulo circulo = null;
        while (continua) {
            try {
                circulo = new Circulo("circulo", LeerTeclado.leerDouble("Ingresa el radio del circulo"));
                continua = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        return circulo;
    }

    private Cuadrado pedirCuadrado() {
        boolean continua = true;
        Cuadrado cuadrado = null;
        while (continua) {
            try {
                cuadrado = new Cuadrado("Cuadrado", LeerTeclado.leerDouble("Ingresa el lado del cuadrado"));
                continua = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        return cuadrado;
    }

    private Triangulo pedirTriangulo() {
        boolean pedirBase = true, pedirAltura = true, pedirLado2 = true, pedirLado3 = true;
        double base = 0.0;
        double altura = 0.0;
        double lado2 = 0.0;
        double lado3 = 0.0;
        Triangulo t = null;
        String alturaEsLado = "";

        while (pedirBase) {
            try {
                base = LeerTeclado.leerDouble("Base del triangulo");
                if (base < 1)
                    throw new Exception("Base debe ser mayor a 0");
                pedirBase = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        while (pedirAltura) {
            try {
                alturaEsLado = LeerTeclado.leerString("La altura es un lado del triangulo?\nSI\nNO");
                if (!alturaEsLado.equals("SI") && !alturaEsLado.equals("NO"))
                    throw new Exception("Escribe SI o NO con mayusculas");

                if (alturaEsLado.equals("SI"))
                    pedirLado3 = false;

                altura = LeerTeclado.leerDouble("altura del triangulo");
                if (altura < 1)
                    throw new Exception("altura debe ser mayor a 0");

                pedirAltura = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        while (pedirLado2) {
            try {
                lado2 = LeerTeclado.leerDouble("Lado del triangulo");
                if (lado2 < 1)
                    throw new Exception("El lado debe ser mayor a 0");
                pedirLado2 = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        while (pedirLado3) {
            try {
                lado3 = LeerTeclado.leerDouble("Lado del triangulo");
                if (lado3 < 1)
                    throw new Exception("El lado debe ser mayor a 0");
                pedirLado3 = false;
            } catch (NumberFormatException e) {
                LeerTeclado.mostrarMensaje("Ingresa un numero positivo");
            } catch (Exception e) {
                LeerTeclado.mostrarMensaje(e.getMessage());
            }
        }

        try {
            if (alturaEsLado.equals("SI"))
                t = new Triangulo("Triangulo", base, altura, lado2);
            else
                t = new Triangulo("Triangulo", base, altura, lado2, lado3);
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje(e.getMessage());
        }

        return t;
    }

    private void mostrarCuerposGeometricos(Lista lista) {
        try {
            LectorArchivo la = new LectorArchivo("cuerpos.txt");
            String mensaje = "";

            for (CuerpoGeometrico cuerpo : lista.getCuerposGeometricos()) {
                mensaje += cuerpo + "\n-------------";
            }

            LeerTeclado.mostrarMensaje(mensaje);
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje(e.getMessage());
        }
    }

    private void mostrarPoligonos(Lista lista) {
        try {
            LectorArchivo la = new LectorArchivo("poligonos.txt");
            String mensaje = "";

            for (Poligono poligono : lista.getPoligonos()) {
                mensaje += poligono + "\n-------------";
            }

            LeerTeclado.mostrarMensaje(mensaje);
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje(e.getMessage());
        }
    }

    private void agregarCuerpo(CuerpoGeometrico c) {
        try {
            archivoCuerpos.agregarCuerpo(c);
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje(e.getMessage());
        }
    }

    private void agregarPoligono(Poligono p) {
        try {
            archivoPoligonos.agregarPoligono(p);
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje(e.getMessage());
        }
    }

    private void rellenarLista(Lista lista) {
        try {
            LectorArchivo lectorPoligonos = new LectorArchivo("poligonos.txt");
            LectorArchivo lectorCuerpos = new LectorArchivo("cuerpos.txt");

            if (lectorPoligonos.bytes() < 1) 
                archivoPoligonos.escribirPoligonosBase();
        
            if (lectorCuerpos.bytes() < 1) 
                archivoCuerpos.escribirCuerposBase();
            

            for (Poligono p : lectorPoligonos.leerPoligonos()) {
                lista.agregarPoligono(p);
            }

            for (CuerpoGeometrico c : lectorCuerpos.leerCuerpos()) {
                lista.agregarCuerpoGeometrico(c);
            }

            LeerTeclado.mostrarMensaje("Se han añadido poligonos y cuerpos geometricos a la lista");
        } catch (Exception e) {
            LeerTeclado.mostrarMensaje("No se pudo leer el archivo");
        }
    }
}
