package decorators;

import core.ComponenteCarro;

/**
 * Decorador concreto: agrega rines deportivos al vehículo.
 */
public class RinesDeportivos extends CarroDecorador {

    /**
     * Constructor del decorador de rines deportivos.
     * @param componenteDecorado el componente a decorar.
     */
    public RinesDeportivos(ComponenteCarro componenteDecorado) {
        super(componenteDecorado);
    }

    @Override
    public double calcularPrecio() {
        // TODO: implementar - sumar el costo de los rines al precio del componente decorado
        return 0;
    }

    @Override
    public String obtenerDescripcion() {
        // TODO: implementar - agregar la descripción de los rines deportivos
        return "";
    }
}
