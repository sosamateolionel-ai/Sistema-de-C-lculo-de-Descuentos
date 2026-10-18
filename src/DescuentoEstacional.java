public class DescuentoEstacional implements PoliticaDescuento {

    private double porcentaje; // varía según la temporada

    public DescuentoEstacional(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double montoOriginal) {
        return montoOriginal * porcentaje;
    }

    @Override
    public String getNombre() {
        return "Estacional (" + (int) (porcentaje * 100) + "%)";
    }
}