import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();

        // Agregar algunos platos al menú
        Plato milanesa = new Plato("Milanesa", 150);
        Plato fideos = new Plato("Fideos", 110);
        Plato hamburguesa = new Plato("Hamburguesa", 180);
        menu.agregarPlato(milanesa);
        menu.agregarPlato(fideos);
        menu.agregarPlato(hamburguesa);

        Restaurante restaurante = new Restaurante("Pertuti", menu);
        Administracion administracion = new Administracion(restaurante);

        // Menú de opciones
        int opcion;
        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Administrar mesas");
            System.out.println("2. Administrar clientes");
            System.out.println("3. Administrar menú");
            System.out.println("4. Listar reservas");
            System.out.println("5. Listar mesas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Opciones para administración de mesas
                    System.out.println("\n--- Administración de Mesas ---");
                    System.out.println("1. Agregar mesa");
                    System.out.println("2. Eliminar mesa");
                    System.out.print("Elige una opción: ");
                    int mesaOpcion = sc.nextInt();
                    if (mesaOpcion == 1) {
                        administracion.agregarMesa();
                    } else if (mesaOpcion == 2) {
                        System.out.println("Introduce el número de mesa a eliminar:");
                        int numMesa = sc.nextInt();
                        Mesa mesa = restaurante.buscarMesaPorNumero(numMesa);
                        if (mesa != null) {
                            administracion.eliminarMesa(mesa);
                        } else {
                            System.out.println("La mesa no existe.");
                        }
                    }
                    break;

                case 2:
                    // Opciones para administración de clientes
                    System.out.println("\n--- Administración de Clientes ---");
                    System.out.println("Introduce el nombre del cliente:");
                    String nombre = sc.next();
                    System.out.println("Introduce el teléfono del cliente:");
                    int telefono = sc.nextInt();
                    System.out.println("Introduce el correo del cliente:");
                    String correo = sc.next();
                    Cliente cliente = new Cliente(nombre, telefono, correo);
                    cliente.registrar(restaurante);
                    break;

                case 3:
                    // Opciones para administración del menú
                    System.out.println("\n--- Administración del Menú ---");
                    System.out.println("1. Agregar plato");
                    System.out.println("2. Eliminar plato");
                    System.out.println("3. Listar platos");
                    System.out.print("Elige una opción: ");
                    int menuOpcion = sc.nextInt();
                    if (menuOpcion == 1) {
                        System.out.println("Introduce el nombre del plato:");
                        String nombrePlato = sc.next();
                        System.out.println("Introduce el precio del plato:");
                        double precio = sc.nextDouble();
                        Plato nuevoPlato = new Plato(nombrePlato, precio);
                        menu.agregarPlato(nuevoPlato);
                    } else if (menuOpcion == 2) {
                    System.out.println("Introduce el nombre del plato a eliminar:");
                    String nombrePlato = sc.next();
                    Plato platoAEliminar = null;
                    for (Plato plato : menu.obtenerPlatos()) {
                        if (plato.getNombre().equals(nombrePlato)) {
                            platoAEliminar = plato;
                            break;
                        }
                    }
                    if (platoAEliminar != null) {
                        menu.eliminarPlato(platoAEliminar);
                    } else {
                        System.out.println("El plato no existe.");
                    }
                    } else if (menuOpcion == 3) {
                        menu.listarPlatos();
                    }
                    break;

                case 4:
                    restaurante.listarReservas();
                    break;

                case 5:
                    restaurante.listarMesas();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}
