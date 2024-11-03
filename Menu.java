import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Plato> platos;

    public Menu() {
        this.platos = new ArrayList<>(); // Inicializa la lista de platos
    }

    public boolean agregarPlato(Plato plato) {
        return platos.add(plato);
    }

    public boolean eliminarPlato(Plato plato) {
        return platos.remove(plato);
    }

    public void listarPlatos() {
        if (platos.isEmpty()) {
            System.out.println("No hay platos disponibles.");
        } else {
            System.out.println("Lista de Platos:");
            for (Plato plato : platos) {
                plato.detallesPlato(); // Llama al metodo detallesPlato() de cada plato
            }
        }
    }
    public List<Plato> obtenerPlatos() {
        return platos;
    }

}