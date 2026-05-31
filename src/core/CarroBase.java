package core;

/**
 * Clase concreta que representa el vehículo eléctrico base.
 * Actúa como el componente concreto del patrón Decorator.
 */
public class CarroBase implements ComponenteCarro {

    private String modelo;
    private double precioBase;

    /**
     * Constructor del vehículo base.
     * @param modelo nombre del modelo del vehículo.
     * @param precioBase precio base del vehículo sin accesorios.
     */
    public CarroBase(String modelo, double precioBase) {
        // TODO: implementar
    }

    @Override
    public double calcularPrecio() {
        // TODO: implementar - retornar el precio base
        return 0;
    }

    @Override
    public String obtenerDescripcion() {
        // TODO: implementar - retornar la descripción del modelo base
        return "";
    }
}
