import java.util.InputMismatchException;
import java.util.Scanner;

public class Administracion {
    private Restaurante restaurante;

    public Administracion(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void agregarMesa() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduce el número de mesa:");
            int numero = sc.nextInt();

            if (restaurante.buscarMesaPorNumero(numero) != null) {
                System.out.println("La mesa con el número " + numero + " ya existe. No se puede agregar nuevamente.");
                return;
            }

            System.out.println("Introduce la cantidad de personas:");
            int cantidad = sc.nextInt();

            Mesa mesa = new Mesa(numero, cantidad);
            restaurante.agregarMesa(mesa);
            System.out.println("Mesa agregada: " + mesa.detallesMesa());
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número.");
            sc.nextLine(); // Limpia el scanner para evitar bucles infinitos
        }
    }
    public void eliminarMesa(Mesa mesa) {
        restaurante.eliminarMesa(mesa);
        System.out.println("Mesa eliminada: " + mesa);

    }
}