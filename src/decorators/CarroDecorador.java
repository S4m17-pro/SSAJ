package decorators;

import core.ComponenteCarro;

/**
 * Clase abstracta base para todos los decoradores de vehículos.
 * Implementa ComponenteCarro y mantiene una referencia al componente envuelto.
 */
public abstract class CarroDecorador implements ComponenteCarro {

    private ComponenteCarro componenteDecorado;

    /**
     * Constructor del decorador.
     * @param componenteDecorado el componente a decorar.
     */
    public CarroDecorador(ComponenteCarro componenteDecorado) {
        // TODO: implementar - asignar el componente decorado
    }

    /**
     * Retorna el componente decorado interno.
     * @return referencia al ComponenteCarro envuelto.
     */
    protected ComponenteCarro getComponenteDecorado() {
        return componenteDecorado;
    }
}
