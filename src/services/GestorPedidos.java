package services;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Singleton para gestionar los pedidos de vehículos personalizados.
 * Garantiza una única instancia global en memoria.
 */
public class GestorPedidos {

    private static GestorPedidos instancia;
    private List<String> historialPedidos;

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private GestorPedidos() {
        // TODO: implementar - inicializar la lista de historial
    }

    /**
     * Retorna la única instancia del GestorPedidos (Singleton).
     * @return instancia única de GestorPedidos.
     */
    public static GestorPedidos getInstance() {
        // TODO: implementar - crear la instancia si no existe y retornarla
        return instancia;
    }

    /**
     * Guarda un pedido en el historial.
     * @param descripcion descripción del vehículo personalizado.
     * @param precio precio total del vehículo configurado.
     */
    public void guardarPedido(String descripcion, double precio) {
        // TODO: implementar - agregar el pedido al historial
    }

    /**
     * Muestra por consola todos los pedidos realizados.
     */
    public void mostrarHistorial() {
        // TODO: implementar - recorrer e imprimir el historial de pedidos
    }
}
