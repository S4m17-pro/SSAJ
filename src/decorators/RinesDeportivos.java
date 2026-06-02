package decorators;

import core.ComponenteCarro;

public class RinesDeportivos extends CarroDecorador {

    private static final double COSTO_RINES = 3800.00;

    // Constructor del decorador de rines deportivos.
    public RinesDeportivos(ComponenteCarro componenteDecorado) {
        super(componenteDecorado);
    }

    @Override
    public double calcularPrecio() {
        return getComponenteDecorado().calcularPrecio() + COSTO_RINES;
    }

    @Override
    public String obtenerDescripcion() {
        return getComponenteDecorado().obtenerDescripcion() + " + Rines Deportivos 21\" Forjados";
    }
}
