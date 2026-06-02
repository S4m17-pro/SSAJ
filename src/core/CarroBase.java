package core;

// Clase concreta que representa el vehículo eléctrico base.
// Actúa como el componente concreto del patrón Decorator.
public class CarroBase implements ComponenteCarro {

    private String modelo;
    private double precioBase;

    // Constructor del vehículo base.
    public CarroBase(String modelo, double precioBase) {
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public String obtenerDescripcion() {
        return modelo;
    }
}
