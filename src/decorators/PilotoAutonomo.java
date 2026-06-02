package decorators;

import core.ComponenteCarro;

public class PilotoAutonomo extends CarroDecorador {

    private static final double COSTO_PILOTO = 12500.00;

    // Constructor del decorador de piloto autónomo.
    public PilotoAutonomo(ComponenteCarro componenteDecorado) {
        super(componenteDecorado);
    }

    @Override
    public double calcularPrecio() {
        return getComponenteDecorado().calcularPrecio() + COSTO_PILOTO;
    }

    @Override
    public String obtenerDescripcion() {
        return getComponenteDecorado().obtenerDescripcion() + " + Pack Piloto Autónomo PRO";
    }
}
