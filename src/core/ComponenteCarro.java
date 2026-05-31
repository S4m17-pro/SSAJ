package core;

/**
 * Interfaz base del patrón Decorator.
 * Define el contrato para todos los componentes del vehículo eléctrico.
 */
public interface ComponenteCarro {

    /**
     * Calcula el precio total del vehículo con sus accesorios.
     * @return precio en formato double.
     */
    double calcularPrecio();

    /**
     * Obtiene la descripción completa del vehículo y sus accesorios.
     * @return descripción del componente.
     */
    String obtenerDescripcion();
}
