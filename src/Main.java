import core.ComponenteCarro;
import core.CarroBase;
import decorators.BateriaLargaDuracion; 
import decorators.PilotoAutonomo;
import decorators.RinesDeportivos;
import services.GestorPedidos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorPedidos gestor = GestorPedidos.getInstance();
        boolean ejecutando = true;

        while (ejecutando) {
            mostrarMenuPrincipal();
            System.out.print("Seleccione una opcion: ");
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
                    System.out.println();
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    System.out.println();
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println();
        System.out.println("MENU PRINCIPAL");
        System.out.println("1) Configurar nuevo vehiculo");
        System.out.println("2) Ver historial de pedidos");
        System.out.println("3) Salir del sistema");
    }

    private static void procesarNuevoPedido(Scanner scanner, GestorPedidos gestor) {
        System.out.println();
        System.out.println("CONFIGURADOR DE VEHICULO CYBERCAR");
        System.out.println();

        System.out.println("PASO 1: Seleccione el modelo base");
        System.out.println("1) CyberCar Model S Standard    - " + formatear(30000.00));
        System.out.println("2) CyberCar Model X Premium     - " + formatear(45000.00));
        System.out.println("3) CyberCar Model R Racing      - " + formatear(60000.00));
        System.out.print("Modelo: ");
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
        System.out.println("Modelo seleccionado: " + carro.obtenerDescripcion());
        System.out.println("Precio base: " + formatear(carro.calcularPrecio()));
        System.out.println();

        boolean configurando = true;
        while (configurando) {
            System.out.println("PASO 2: Agregar accesorios (acumulativo)");
            System.out.println("1) Pack Bateria Larga Duracion 100kWh    + " + formatear(8200.00));
            System.out.println("2) Pack Piloto Autonomo PRO              + " + formatear(12500.00));
            System.out.println("3) Rines Deportivos 21\" Forjados         + " + formatear(3800.00));
            System.out.println("0) Finalizar configuracion");
            System.out.println();
            System.out.println("Configuracion actual:");
            System.out.println("  " + carro.obtenerDescripcion());
            System.out.println("  Precio parcial: " + formatear(carro.calcularPrecio()));
            System.out.println();
            System.out.print("Accesorio: ");
            String accesorioOpcion = scanner.nextLine().trim();

            switch (accesorioOpcion) {
                case "1":
                    carro = new BateriaLargaDuracion(carro);
                    System.out.println();
                    System.out.println("Pack Bateria Larga Duracion agregado.");
                    System.out.println("Nuevo total: " + formatear(carro.calcularPrecio()));
                    System.out.println();
                    break;
                case "2":
                    carro = new PilotoAutonomo(carro);
                    System.out.println();
                    System.out.println("Pack Piloto Autonomo PRO agregado.");
                    System.out.println("Nuevo total: " + formatear(carro.calcularPrecio()));
                    System.out.println();
                    break;
                case "3":
                    carro = new RinesDeportivos(carro);
                    System.out.println();
                    System.out.println("Rines Deportivos 21\" Forjados agregados.");
                    System.out.println("Nuevo total: " + formatear(carro.calcularPrecio()));
                    System.out.println();
                    break;
                case "0":
                    configurando = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    System.out.println();
                    break;
            }
        }

        System.out.println();
        System.out.println("RESUMEN DE CONFIGURACION");
        System.out.println("------------------------");
        System.out.println("Vehiculo configurado:");

        String descripcion = carro.obtenerDescripcion();
        String[] partes = descripcion.split(" \\+ ");
        for (int i = 0; i < partes.length; i++) {
            if (i == 0) {
                System.out.println(" - " + partes[i].trim());
            } else {
                System.out.println("   + " + partes[i].trim());
            }
        }

        System.out.println();
        System.out.println("PRECIO TOTAL: " + formatear(carro.calcularPrecio()));
        System.out.println();

        System.out.print("Confirmar pedido? (S/N): ");
        String confirmacion = scanner.nextLine().trim().toUpperCase();

        if (confirmacion.equals("S")) {
            gestor.guardarPedido(carro.obtenerDescripcion(), carro.calcularPrecio());
        } else {
            System.out.println();
            System.out.println("Pedido cancelado.");
            System.out.println();
        }
    }

    private static String formatear(double precio) {
        return String.format("%.2f", precio);
    }

    private static void mostrarDespedida() {
        System.out.println();
        System.out.println("Gracias por usar CyberCar Configurator.");
        System.out.println();
    }
}
