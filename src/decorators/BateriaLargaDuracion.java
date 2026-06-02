package decorators;

import core.ComponenteCarro;

public class BateriaLargaDuracion extends CarroDecorador {

    private static final double COSTO_BATERIA = 8200.00;

    // Constructor del decorador de batería de larga duración.
    public BateriaLargaDuracion(ComponenteCarro componenteDecorado) {
        super(componenteDecorado);
    }

    @Override
    public double calcularPrecio() {
        return getComponenteDecorado().calcularPrecio() + COSTO_BATERIA;
    }

    @Override
    public String obtenerDescripcion() {
        return getComponenteDecorado().obtenerDescripcion() + " + Pack Batería Larga Duración 100kWh";
    }
}
