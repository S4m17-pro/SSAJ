package decorators;

import core.ComponenteCarro;

/**
 * Decorador concreto: agrega el sistema de piloto autónomo al vehículo.
 */
public class PilotoAutonomo extends CarroDecorador {

    /**
     * Constructor del decorador de piloto autónomo.
     * @param componenteDecorado el componente a decorar.
     */
    public PilotoAutonomo(ComponenteCarro componenteDecorado) {
        super(componenteDecorado);
    }

    @Override
    public double calcularPrecio() {
        // TODO: implementar - sumar el costo del piloto autónomo al precio del componente decorado
        return 0;
    }

    @Override
    public String obtenerDescripcion() {
        // TODO: implementar - agregar la descripción del piloto autónomo
        return "";
    }
}
