public class DescuentoLealtad implements PoliticaDescuento {

    private static final double PORCENTAJE = 0.10;      // 10% fijo
    private static final double TOPE_MAXIMO = 20000.0;  // el ahorro nunca supera este valor

    @Override
    public double calcularDescuento(double montoOriginal) {

        double descuento = montoOriginal * PORCENTAJE;

        if (descuento > TOPE_MAXIMO) {
            descuento = TOPE_MAXIMO;
        }

        return descuento;
    }

    @Override
    public String getNombre() {
        return "Lealtad (10%, tope $20000)";
    }
}