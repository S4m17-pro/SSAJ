package services;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    // Formatea un precio double como moneda USD legible.
    private String formatearPrecio(double precio) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return formatter.format(precio);
    }

    // Ajusta espacios para alinear el borde derecho del recuadro.
    private String ajustarEspacios(String texto, int anchoTotal) {
        int espacios = anchoTotal - texto.length();
        if (espacios < 1) espacios = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < espacios; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    // Guarda un pedido en el historial con formato detallado.
    public void guardarPedido(String descripcion, double precio) {
        contadorPedidos++;
        totalVentas += precio;
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String registro = String.format("PEDIDO #%04d | %s | %s | %s",
                contadorPedidos, timestamp, descripcion, formatearPrecio(precio));
        historialPedidos.add(registro);

        // Confirmación visual al guardar
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("  ║   ✅  PEDIDO REGISTRADO EXITOSAMENTE                            ║");
        System.out.println("  ╠══════════════════════════════════════════════════════════════════╣");
        System.out.printf("  ║   📋  Pedido #%04d                                              ║%n", contadorPedidos);
        System.out.println("  ║   📅  Fecha: " + timestamp + "                              ║");
        System.out.println("  ║   💰  Total: " + formatearPrecio(precio) + ajustarEspacios(formatearPrecio(precio), 50) + "║");
        System.out.println("  ╚══════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    // Muestra por consola todos los pedidos realizados con formato tipo factura.
    public void mostrarHistorial() {
        System.out.println();
        System.out.println("  ╔════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("  ║                                                                                              ║");
        System.out.println("  ║        ██████╗██╗   ██╗██████╗ ███████╗██████╗  ██████╗ █████╗ ██████╗                        ║");
        System.out.println("  ║       ██╔════╝╚██╗ ██╔╝██╔══██╗██╔════╝██╔══██╗██╔════╝██╔══██╗██╔══██╗                       ║");
        System.out.println("  ║       ██║      ╚████╔╝ ██████╔╝█████╗  ██████╔╝██║     ███████║██████╔╝                       ║");
        System.out.println("  ║       ██║       ╚██╔╝  ██╔══██╗██╔══╝  ██╔══██╗██║     ██╔══██║██╔══██╗                       ║");
        System.out.println("  ║       ╚██████╗   ██║   ██████╔╝███████╗██║  ██║╚██████╗██║  ██║██║  ██║                       ║");
        System.out.println("  ║        ╚═════╝   ╚═╝   ╚═════╝ ╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝                       ║");
        System.out.println("  ║                                                                                              ║");
        System.out.println("  ║                    ⚡  PANEL ADMINISTRATIVO DE VENTAS  ⚡                                     ║");
        System.out.println("  ╠════════════════════════════════════════════════════════════════════════════════════════════════╣");

        if (historialPedidos.isEmpty()) {
            System.out.println("  ║                                                                                              ║");
            System.out.println("  ║        📭  No hay pedidos registrados en el sistema.                                         ║");
            System.out.println("  ║                                                                                              ║");
        } else {
            System.out.println("  ║                                                                                              ║");
            System.out.printf("  ║   📊  Total de pedidos procesados: %-5d                                                     ║%n", contadorPedidos);
            System.out.println("  ║   " + "─".repeat(90) + "║");
            System.out.println("  ║                                                                                              ║");

            for (int i = 0; i < historialPedidos.size(); i++) {
                String pedido = historialPedidos.get(i);
                String[] partes = pedido.split(" \\| ");

                System.out.printf("  ║   🚗  %-88s║%n", partes[0]);
                System.out.printf("  ║       📅  Fecha: %-76s║%n", partes[1]);
                System.out.printf("  ║       📝  Config: %-75s║%n", partes[2]);
                System.out.printf("  ║       💰  Total:  %-75s║%n", partes[3]);

                if (i < historialPedidos.size() - 1) {
                    System.out.println("  ║   " + "·".repeat(90) + "║");
                }
            }

            System.out.println("  ║                                                                                              ║");
            System.out.println("  ╠════════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("  ║                                                                                              ║");
            System.out.printf("  ║       💎  INGRESOS TOTALES:  %-65s║%n", formatearPrecio(totalVentas));
            System.out.println("  ║                                                                                              ║");
        }

        System.out.println("  ╚════════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
}
