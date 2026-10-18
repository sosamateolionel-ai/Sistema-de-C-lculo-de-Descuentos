public class CalculadoraPrecios {

    private PoliticaDescuento politica; // referencia a la ABSTRACCIÓN

    public CalculadoraPrecios(PoliticaDescuento politica) {
        this.politica = politica;
    }

    public void setPolitica(PoliticaDescuento politica) {
        this.politica = politica;
    }

    public double calcularPrecioFinal(double montoOriginal) {

        if (montoOriginal <= 0) {
            System.out.println("Calculadora: monto inválido ($" + montoOriginal + ").");
            return 0;
        }

        double descuento = politica.calcularDescuento(montoOriginal);

        // Protección: el descuento nunca puede ser negativo ni superar el monto
        if (descuento < 0) {
            descuento = 0;
        }
        if (descuento > montoOriginal) {
            descuento = montoOriginal;
        }

        double precioFinal = montoOriginal - descuento;

        System.out.println("\nPolítica: " + politica.getNombre());
        System.out.printf("   Monto original: %12.2f%n", montoOriginal);
        System.out.printf("   Ahorro        : %12.2f%n", descuento);
        System.out.printf("   Total a pagar : %12.2f%n", precioFinal);

        return precioFinal;
    }
}