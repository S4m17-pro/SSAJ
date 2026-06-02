package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Clase Singleton para gestionar los pedidos de vehículos personalizados.
// Garantiza una única instancia global en memoria.
public class GestorPedidos {

    private static GestorPedidos instancia;
    private List<String> historialPedidos;
    private int contadorPedidos;
    private double totalVentas;

    // Constructor privado para evitar instanciación externa.
    private GestorPedidos() {
        historialPedidos = new ArrayList<>();
        contadorPedidos = 0;
        totalVentas = 0.0;
    }

    // Retorna la única instancia del GestorPedidos (Singleton thread-safe).
    public static synchronized GestorPedidos getInstance() {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
    }

    public void guardarPedido(String descripcion, double precio) {
        contadorPedidos++;
        totalVentas += precio;
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String registro = "PEDIDO #" + String.format("%04d", contadorPedidos) + " | " + timestamp + " | " + descripcion + " | " + precio;
        historialPedidos.add(registro);
    }

    public void mostrarHistorial() {
        System.out.println();
        System.out.println("=== HISTORIAL DE PEDIDOS ===");
        System.out.println();

        if (historialPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("Total de pedidos procesados: " + contadorPedidos);
            System.out.println();

            for (String pedido : historialPedidos) {
                String[] partes = pedido.split(" \\| ");
                System.out.println(partes[0]);
                System.out.println("  Fecha:   " + partes[1]);
                System.out.println("  Config:  " + partes[2]);
                System.out.println("  Total:   " + partes[3]);
                System.out.println("  ----------------------------------------");
            }

            System.out.println();
            System.out.println("INGRESOS TOTALES: " + totalVentas);
        }

        System.out.println();
    }
}
