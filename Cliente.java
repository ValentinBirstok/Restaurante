import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {
    private String nombre;
    private int telefono;
    private String correo;
    private static int ReservaId = 1; // Variable para la identificación de la reserva

    public Cliente(String nombre, int telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public void registrar(Restaurante restaurante) {
        Scanner sc = new Scanner(System.in);

        try {
            int dia, mes, hora, cantidad, numeroMesa;

            while (true) {
                System.out.println("Introduce el día de la reserva (1-31):");
                dia = sc.nextInt();
                if (dia >= 1 && dia <= 31) break;
                else System.out.println("Día no válido. Debe estar entre 1 y 31.");
            }

            while (true) {
                System.out.println("Introduce el mes de la reserva (1-12):");
                mes = sc.nextInt();
                if (mes >= 1 && mes <= 12) break;
                else System.out.println("Mes no válido. Debe estar entre 1 y 12.");
            }

            while (true) {
                System.out.println("Introduce la hora de la reserva (0-23):");
                hora = sc.nextInt();
                if (hora >= 0 && hora <= 23) break;
                else System.out.println("Hora no válida. Debe estar entre 0 y 23.");
            }

            System.out.println("Introduce la cantidad de personas:");
            cantidad = sc.nextInt();

            System.out.println("Introduce el número de la mesa:");
            numeroMesa = sc.nextInt();

            Mesa mesa = restaurante.buscarMesaPorNumero(numeroMesa);

            if (mesa != null) {
                if (mesa.marcarDisponible()) {
                    Reserva reserva = new Reserva(ReservaId++, dia, mes, hora, cantidad, this, mesa);
                    restaurante.agregarReserva(reserva);
                    mesa.marcarOcupada();
                    System.out.println("Reserva creada: " + reserva.detallesMesas());
                } else {
                    System.out.println("La mesa " + numeroMesa + " ya está ocupada.");
                }
            } else {
                System.out.println("La mesa " + numeroMesa + " no existe en el restaurante.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número.");
            sc.nextLine(); // Limpiar el scanner
        }
    }


    public String detallesCliente() {
        return nombre + ", Teléfono: " + telefono + ", Correo: " + correo;
    }
}
