
void main() {

    double montoCompra = 150000.0;

    CalculadoraPrecios calculadora = new CalculadoraPrecios(new DescuentoLealtad());

    System.out.println("===== Compra base: $" + montoCompra + " =====");

    calculadora.calcularPrecioFinal(montoCompra);

    calculadora.setPolitica(new DescuentoEstacional(0.15));
    calculadora.calcularPrecioFinal(montoCompra);

    calculadora.setPolitica(new DescuentoVolumen());
    calculadora.calcularPrecioFinal(montoCompra);

    System.out.println("\n===== Compra grande: $300000.0 (se activa el tope de lealtad) =====");

    calculadora.setPolitica(new DescuentoLealtad());
    calculadora.calcularPrecioFinal(300000.0);

    calculadora.setPolitica(new DescuentoVolumen());
    calculadora.calcularPrecioFinal(300000.0);

    System.out.println("\n===== Compra chica: $30000.0 (volumen sin descuento) =====");

    calculadora.calcularPrecioFinal(30000.0);

    System.out.println("\n===== Monto inválido =====");

    calculadora.calcularPrecioFinal(-500.0);
}