package decorators;

import core.ComponenteCarro;

/**
 * Decorador concreto: agrega una batería de larga duración al vehículo.
 */
public class BateriaLargaDuracion extends CarroDecorador {

    /**
     * Constructor del decorador de batería de larga duración.
     * @param componenteDecorado el componente a decorar.
     */
    public BateriaLargaDuracion(ComponenteCarro componenteDecorado) {
        super(componenteDecorado);
    }

    @Override
    public double calcularPrecio() {
        // TODO: implementar - sumar el costo de la batería al precio del componente decorado
        return 0;
    }

    @Override
    public String obtenerDescripcion() {
        // TODO: implementar - agregar la descripción de la batería
        return "";
    }
}
