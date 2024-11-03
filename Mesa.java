public class Mesa {
    private int numero;
    private int capacidad;
    private boolean disponible;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.disponible = true;
    }

    public void marcarOcupada() {
        disponible = false;
    }

    public boolean marcarDisponible() {
        return disponible;
    }

    public String detallesMesa() {
        String estado = disponible ? "Disponible" : "Ocupada";
        return "Mesa N°: " + numero + ", Capacidad: " + capacidad + ", Estado: " + estado;
    }

    public int getNumero() {
        return numero;
    }
}