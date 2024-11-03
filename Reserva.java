import java.util.Scanner;

public class Reserva {
    private int id;
    private int dia;
    private int mes;
    private int hora;
    private int cantPersonas;
    private Cliente cliente;
    private Mesa mesa;

    public Reserva(int id, int dia, int mes, int hora, int cantPersonas, Cliente cliente, Mesa mesa) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
        this.cantPersonas = cantPersonas;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public void cancelarReserva() {
        mesa.marcarDisponible();
    }

    // Metodo para mostrar información de la reserva
    public String detallesMesas() {
        return "Reserva ID: " + id + ", Fecha: " + dia + "/" + mes + ", Hora: " + hora +
                ", Cantidad de Personas: " + cantPersonas + ", Cliente: " + cliente.detallesCliente();
    }
}