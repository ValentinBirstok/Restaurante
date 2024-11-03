public class Plato {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void detallesPlato() {
        System.out.println("Nombre: " + nombre + ", Precio: $" + precio);
    }
}