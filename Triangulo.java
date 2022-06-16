public class Triangulo extends Poligono {
    private double base;
    private double altura;
    private double[] lados;
    // No siempre la altura es un lado del triangulo
    private boolean alturaEsLado;

    public Triangulo(String nombre, double base, double altura, double lado1) throws Exception {
        super(nombre);
        verificarDatos(base, altura, lado1, 1);
        setBase(base);
        setAltura(altura);

        alturaEsLado = true;
        lados = new double[1];
        lados[0] = lado1;
    }

    public Triangulo(String nombre, double base, double altura, double lado1, double lado2) throws Exception {
        super(nombre);
        verificarDatos(base, altura, lado1, lado2);

        setBase(base);
        setAltura(altura);

        alturaEsLado = false;
        lados = new double[2];
        lados[0] = lado1;
        lados[1] = lado2;
    }

    public double calcularArea() {
        return (base * altura) / 2;
    }

    public double calcularPerimetro() {
        if (alturaEsLado)
            return altura + base + lados[0];

        return lados[0] + lados[1] + base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    private void verificarDatos(double base, double altura, double lado1, double lado2) throws Exception {
        if (base < 1)
            throw new Exception("La base no puede ser menor a 1");

        if (altura < 1)
            throw new Exception("La altura no puede ser menor a 1");

        if (lado1 < 1)
            throw new Exception("El lado no puede ser menor a 1");

        if (lado2 < 1)
            throw new Exception("El lado no puede ser menor a 1");
    }

    @Override
    public String toString() {
        double tercerLado, segundoLado;
        String alturaEsLadoMensaje = "La altura no es ningun lado del triangulo";
        tercerLado = lados[0];
        if (alturaEsLado) {
            alturaEsLadoMensaje = "La altura es uno de los lados";
            segundoLado = altura;
        } else
            segundoLado = lados[1];

        return super.toString() + "\nBase = " + base + "\nAltura = " + altura + "\nLado 2 = " + segundoLado
                + "\nLado 3 = " + tercerLado + "\n" + alturaEsLadoMensaje;
    }

}
