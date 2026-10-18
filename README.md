# Sistema de Cálculo de Descuentos

## Descripción

Este proyecto implementa un sistema de cálculo de precios finales mediante distintas políticas de descuento, utilizando Java y los principios de la Programación Orientada a Objetos.

El sistema permite aplicar descuentos por lealtad, descuentos estacionales y descuentos por volumen de compra. La calculadora puede cambiar de política durante la ejecución sin modificar su lógica interna.

## Funcionamiento

El programa utiliza una interfaz común para definir cómo se calcula un descuento. Cada política implementa sus propias reglas y proporciona un nombre identificador.

La calculadora realiza las siguientes operaciones:

1. Recibe el monto original de la compra.
2. Verifica que el monto sea válido.
3. Calcula el descuento utilizando la política seleccionada.
4. Evita que el descuento sea negativo o supere el monto original.
5. Muestra el monto original, el ahorro y el total a pagar.

## Clases e interfaz principales

### 1. `PoliticaDescuento`

Interfaz que define el contrato que deben cumplir todas las políticas de descuento.

**Métodos:**

* `calcularDescuento()`: calcula el importe que se descontará.
* `getNombre()`: devuelve el nombre de la política aplicada.

### 2. `DescuentoLealtad`

Implementa una política de descuento para clientes leales.

**Características:**

* Aplica un descuento del 10%.
* Establece un ahorro máximo de $20.000.
* Si el descuento calculado supera ese límite, se aplica únicamente el tope máximo.

### 3. `DescuentoEstacional`

Implementa una política de descuento configurable según la temporada o campaña comercial.

**Características:**

* Recibe el porcentaje de descuento mediante el constructor.
* Calcula el descuento multiplicando el monto original por el porcentaje recibido.
* Muestra el porcentaje aplicado en el nombre de la política.

Por ejemplo, un valor de `0.15` representa un descuento del 15%.

### 4. `DescuentoVolumen`

Implementa una política de descuentos escalonados según el monto de la compra.

| Monto de compra                        | Descuento |
| -------------------------------------- | --------: |
| Menor a $50.000                        |        0% |
| Desde $50.000 hasta menos de $100.000  |        5% |
| Desde $100.000 hasta menos de $200.000 |       10% |
| $200.000 o más                         |       20% |

Cuanto mayor sea el monto de la compra, mayor será el porcentaje de descuento aplicado.

### 5. `CalculadoraPrecios`

Es la clase encargada de calcular el precio final de una compra.

**Atributo principal:**

* `politica`: referencia a una implementación de `PoliticaDescuento`.

**Métodos principales:**

* `CalculadoraPrecios()`: recibe la política inicial mediante el constructor.
* `setPolitica()`: permite cambiar la política de descuento.
* `calcularPrecioFinal()`: valida el monto, calcula el descuento, aplica protecciones y muestra el desglose de la compra.

Si el monto original es menor o igual a cero, informa que es inválido y devuelve `0`.

Además, limita el descuento para evitar que sea negativo o superior al monto original.

### 6. `Main`

Contiene el método principal del programa.

Realiza distintas pruebas para comprobar el funcionamiento de las políticas:

* Compra de $150.000 con las tres políticas.
* Compra de $300.000 con descuentos por lealtad y volumen.
* Compra de $30.000 con descuento por volumen.
* Prueba con un monto inválido de -$500.

## Ejemplo de funcionamiento

Para una compra de $150.000, los resultados esperados son:

| Política         |  Ahorro | Total a pagar |
| ---------------- | ------: | ------------: |
| Lealtad (10%)    | $15.000 |      $135.000 |
| Estacional (15%) | $22.500 |      $127.500 |
| Volumen (10%)    | $15.000 |      $135.000 |

Para una compra de $300.000:

* **Lealtad:** el descuento del 10% sería de $30.000, pero se aplica el tope de $20.000. El total es $280.000.
* **Volumen:** se aplica el 20%, equivalente a $60.000. El total es $240.000.

Para una compra de $30.000 con descuento por volumen, no se aplica ningún descuento y el total permanece en $30.000.

## Conceptos de programación utilizados

* **Interfaces:** `PoliticaDescuento` establece un contrato común.
* **Polimorfismo:** la calculadora trabaja con distintas políticas mediante una referencia de tipo `PoliticaDescuento`.
* **Encapsulamiento:** el atributo `politica` es privado y se modifica mediante un método público.
* **Composición:** `CalculadoraPrecios` utiliza una política de descuento como parte de su funcionamiento.
* **Inyección de dependencias:** la política se recibe mediante el constructor.
* **Principio abierto/cerrado:** es posible agregar nuevas políticas sin modificar la lógica principal de la calculadora.
* **Validación de datos:** se controlan los montos inválidos y los límites del descuento.
* **Modularidad:** cada clase tiene una responsabilidad específica.

## Tecnologías utilizadas

* Java
* Programación Orientada a Objetos
* IntelliJ IDEA

## Ejecución

<img width="696" height="635" alt="image" src="https://github.com/user-attachments/assets/aa0e87ef-4ae8-4960-bd6d-4a8429a6d3a4" />
<img width="617" height="456" alt="image" src="https://github.com/user-attachments/assets/4d978b90-b72c-4235-986b-a0130a827a12" />

## Objetivo del ejercicio

Practicar el uso de interfaces, polimorfismo y diseño modular mediante un sistema flexible que permite intercambiar políticas de descuento sin modificar la calculadora.
