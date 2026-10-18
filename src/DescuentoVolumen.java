public class DescuentoVolumen implements PoliticaDescuento {

    @Override
    public double calcularDescuento(double montoOriginal) {

        // Escalonado: cuanto mayor es la compra, mayor es el porcentaje
        if (montoOriginal >= 200000) {
            return montoOriginal * 0.20;
        } else if (montoOriginal >= 100000) {
            return montoOriginal * 0.10;
        } else if (montoOriginal >= 50000) {
            return montoOriginal * 0.05;
        }

        return 0; // compras chicas no tienen descuento
    }

    @Override
    public String getNombre() {
        return "Volumen (escalonado 5% / 10% / 20%)";
    }
}