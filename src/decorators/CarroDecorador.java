package decorators;

import core.ComponenteCarro;

public abstract class CarroDecorador implements ComponenteCarro {

    private ComponenteCarro componenteDecorado;

    public CarroDecorador(ComponenteCarro componenteDecorado) {
        this.componenteDecorado = componenteDecorado;
    }

    protected ComponenteCarro getComponenteDecorado() {
        return componenteDecorado;
    }

    @Override
    public double calcularPrecio() {
        return componenteDecorado.calcularPrecio();
    }

    @Override
    public String obtenerDescripcion() {
        return componenteDecorado.obtenerDescripcion();
    }
}
