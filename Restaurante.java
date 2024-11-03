import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nombre;
    private List<Mesa> mesas;
    private List<Reserva> reservas;
    private Menu menu;

    public Restaurante(String nombre, Menu menu) {
        this.nombre = nombre;
        this.mesas = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.menu = menu;
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas disponibles.");
        } else {
            System.out.println("Lista de Reservas:");
            for (Reserva reserva : reservas) {
                System.out.println(reserva.detallesMesas());
            }
        }
    }

    public void listarMesas() {
        if (mesas.isEmpty()) {
            System.out.println("No hay mesas disponibles.");
        } else {
            System.out.println("Lista de mesas:");
            for (Mesa mesa : mesas) {
                System.out.println(mesa.detallesMesa());
            }
        }
    }

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void eliminarMesa(Mesa mesa) {
        mesas.remove(mesa);
    }

    public void mostrarMenu() {
        menu.listarPlatos();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Mesa buscarMesaPorNumero(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numero) {
                return mesa;
            }
        }
        return null; // Retorna null si no encuentra la mesa
    }
}