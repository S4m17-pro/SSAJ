import core.ComponenteCarro;
import core.CarroBase;
import decorators.BateriaLargaDuracion;
import decorators.PilotoAutonomo;
import decorators.RinesDeportivos;
import services.GestorPedidos;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

// Clase principal del sistema CyberCar.
// Punto de entrada para la personalización interactiva de vehículos eléctricos.
public class Main {

    private static final NumberFormat FORMATO_MONEDA = NumberFormat.getCurrencyInstance(Locale.US);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorPedidos gestor = GestorPedidos.getInstance();
        boolean ejecutando = true;

        mostrarBienvenida();

        while (ejecutando) {
            mostrarMenuPrincipal();
            System.out.print("  ➤  Seleccione una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    procesarNuevoPedido(scanner, gestor);
                    break;
                case "2":
                    gestor.mostrarHistorial();
                    break;
                case "3":
                    ejecutando = false;
                    mostrarDespedida();
                    break;
                default:
                    System.out.println("\n  ⚠️  Opción no válida. Intente de nuevo.\n");
                    break;
            }
        }

        scanner.close();
    }

    // Muestra la pantalla de bienvenida del sistema.
    private static void mostrarBienvenida() {
        System.out.println();
        System.out.println("  ╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("  ║                                                                      ║");
        System.out.println("  ║     ██████╗██╗   ██╗██████╗ ███████╗██████╗  ██████╗ █████╗ ██████╗  ║");
        System.out.println("  ║    ██╔════╝╚██╗ ██╔╝██╔══██╗██╔════╝██╔══██╗██╔════╝██╔══██╗██╔══██╗ ║");
        System.out.println("  ║    ██║      ╚████╔╝ ██████╔╝█████╗  ██████╔╝██║     ███████║██████╔╝ ║");
        System.out.println("  ║    ██║       ╚██╔╝  ██╔══██╗██╔══╝  ██╔══██╗██║     ██╔══██║██╔══██╗ ║");
        System.out.println("  ║    ╚██████╗   ██║   ██████╔╝███████╗██║  ██║╚██████╗██║  ██║██║  ██║ ║");
        System.out.println("  ║     ╚═════╝   ╚═╝   ╚═════╝ ╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝ ║");
        System.out.println("  ║                                                                      ║");
        System.out.println("  ║        ⚡  SISTEMA DE PERSONALIZACIÓN DE VEHÍCULOS ELÉCTRICOS  ⚡    ║");
        System.out.println("  ║                                                                      ║");
        System.out.println("  ║        Patrón de Diseño: DECORATOR                                   ║");
        System.out.println("  ║        Versión: 1.0.0                                                ║");
        System.out.println("  ║        Desarrollado con ☕ Java                                      ║");
        System.out.println("  ║                                                                      ║");
        System.out.println("  ╚════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    // Muestra el menú principal del sistema.
    private static void mostrarMenuPrincipal() {
        System.out.println("  ┌────────────────────────────────────────────────┐");
        System.out.println("  │            🏠  MENÚ PRINCIPAL                  │");
        System.out.println("  ├────────────────────────────────────────────────┤");
        System.out.println("  │                                                │");
        System.out.println("  │    [1]  🚗  Configurar nuevo vehículo          │");
        System.out.println("  │    [2]  📋  Ver historial de pedidos           │");
        System.out.println("  │    [3]  🚪  Salir del sistema                  │");
        System.out.println("  │                                                │");
        System.out.println("  └────────────────────────────────────────────────┘");
    }

    // Flujo completo de configuración de un vehículo nuevo con decoradores acumulativos.
    private static void procesarNuevoPedido(Scanner scanner, GestorPedidos gestor) {
        System.out.println();
        System.out.println("  ═══════════════════════════════════════════════════════════");
        System.out.println("     🏭  CONFIGURADOR DE VEHÍCULO CYBERCAR");
        System.out.println("  ═══════════════════════════════════════════════════════════");
        System.out.println();

        // Paso 1: Seleccionar modelo base
        System.out.println("  ┌─────────────────────────────────────────────────────────┐");
        System.out.println("  │   📦  PASO 1: Seleccione el modelo base                │");
        System.out.println("  ├─────────────────────────────────────────────────────────┤");
        System.out.println("  │                                                         │");
        System.out.println("  │   [1]  CyberCar Model S Standard    -  $30,000.00       │");
        System.out.println("  │   [2]  CyberCar Model X Premium     -  $45,000.00       │");
        System.out.println("  │   [3]  CyberCar Model R Racing      -  $60,000.00       │");
        System.out.println("  │                                                         │");
        System.out.println("  └─────────────────────────────────────────────────────────┘");
        System.out.print("  ➤  Modelo: ");
        String modeloOpcion = scanner.nextLine().trim();

        ComponenteCarro carro;
        switch (modeloOpcion) {
            case "2":
                carro = new CarroBase("CyberCar Model X Premium", 45000.00);
                break;
            case "3":
                carro = new CarroBase("CyberCar Model R Racing", 60000.00);
                break;
            default:
                carro = new CarroBase("CyberCar Model S Standard", 30000.00);
                break;
        }

        System.out.println();
        System.out.println("  ✔  Modelo seleccionado: " + carro.obtenerDescripcion());
        System.out.println("     Precio base: " + FORMATO_MONEDA.format(carro.calcularPrecio()));
        System.out.println();

        // Paso 2: Agregar accesorios (decoradores acumulativos)
        boolean configurando = true;
        while (configurando) {
            System.out.println("  ┌─────────────────────────────────────────────────────────┐");
            System.out.println("  │   🔧  PASO 2: Agregar accesorios (acumulativo)         │");
            System.out.println("  ├─────────────────────────────────────────────────────────┤");
            System.out.println("  │                                                         │");
            System.out.println("  │   [1]  🔋  Pack Batería Larga Duración 100kWh           │");
            System.out.println("  │         Autonomía extendida · +$8,200.00                │");
            System.out.println("  │                                                         │");
            System.out.println("  │   [2]  🤖  Pack Piloto Autónomo PRO                     │");
            System.out.println("  │         LiDAR + Cámaras 360° · +$12,500.00              │");
            System.out.println("  │                                                         │");
            System.out.println("  │   [3]  🏎️   Rines Deportivos 21\" Forjados               │");
            System.out.println("  │         Aluminio forjado aerodinámico · +$3,800.00      │");
            System.out.println("  │                                                         │");
            System.out.println("  │   [0]  ✅  Finalizar configuración                      │");
            System.out.println("  │                                                         │");
            System.out.println("  └─────────────────────────────────────────────────────────┘");
            System.out.println();
            System.out.println("  📝  Configuración actual:");
            System.out.println("      " + carro.obtenerDescripcion());
            System.out.println("      Precio parcial: " + FORMATO_MONEDA.format(carro.calcularPrecio()));
            System.out.println();
            System.out.print("  ➤  Accesorio: ");
            String accesorioOpcion = scanner.nextLine().trim();

            switch (accesorioOpcion) {
                case "1":
                    carro = new BateriaLargaDuracion(carro);
                    System.out.println("\n  ✔  ¡Pack Batería Larga Duración agregado!");
                    System.out.println("     Nuevo total: " + FORMATO_MONEDA.format(carro.calcularPrecio()));
                    System.out.println();
                    break;
                case "2":
                    carro = new PilotoAutonomo(carro);
                    System.out.println("\n  ✔  ¡Pack Piloto Autónomo PRO agregado!");
                    System.out.println("     Nuevo total: " + FORMATO_MONEDA.format(carro.calcularPrecio()));
                    System.out.println();
                    break;
                case "3":
                    carro = new RinesDeportivos(carro);
                    System.out.println("\n  ✔  ¡Rines Deportivos 21\" Forjados agregados!");
                    System.out.println("     Nuevo total: " + FORMATO_MONEDA.format(carro.calcularPrecio()));
                    System.out.println();
                    break;
                case "0":
                    configurando = false;
                    break;
                default:
                    System.out.println("\n  ⚠️  Opción no válida. Intente de nuevo.\n");
                    break;
            }
        }

        // Paso 3: Resumen y confirmación del pedido
        System.out.println();
        System.out.println("  ╔═══════════════════════════════════════════════════════════╗");
        System.out.println("  ║            🧾  RESUMEN DE CONFIGURACIÓN                  ║");
        System.out.println("  ╠═══════════════════════════════════════════════════════════╣");
        System.out.println("  ║                                                           ║");
        System.out.println("  ║   Vehículo configurado:                                   ║");

        // Imprimir la descripción desglosada
        String descripcion = carro.obtenerDescripcion();
        String[] partes = descripcion.split(" \\+ ");
        for (int i = 0; i < partes.length; i++) {
            if (i == 0) {
                System.out.printf("  ║   🚗  %-51s║%n", partes[i].trim());
            } else {
                System.out.printf("  ║       ├─ %-49s║%n", partes[i].trim());
            }
        }

        System.out.println("  ║                                                           ║");
        System.out.printf("  ║   💰  PRECIO TOTAL:  %-37s║%n", FORMATO_MONEDA.format(carro.calcularPrecio()));
        System.out.println("  ║                                                           ║");
        System.out.println("  ╚═══════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.print("  ¿Confirmar pedido? (S/N): ");
        String confirmacion = scanner.nextLine().trim().toUpperCase();

        if (confirmacion.equals("S")) {
            gestor.guardarPedido(carro.obtenerDescripcion(), carro.calcularPrecio());
        } else {
            System.out.println("\n  ❌  Pedido cancelado.\n");
        }
    }

    // Muestra el mensaje de despedida del sistema.
    private static void mostrarDespedida() {
        System.out.println();
        System.out.println("  ╔════════════════════════════════════════════════════════════╗");
        System.out.println("  ║                                                            ║");
        System.out.println("  ║   🙏  ¡Gracias por usar CyberCar Configurator!             ║");
        System.out.println("  ║                                                            ║");
        System.out.println("  ║   ⚡  El futuro de la movilidad eléctrica está aquí.       ║");
        System.out.println("  ║       Hasta la próxima. 🚀                                 ║");
        System.out.println("  ║                                                            ║");
        System.out.println("  ╚════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
}
