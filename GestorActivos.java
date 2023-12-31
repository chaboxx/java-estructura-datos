import java.util.LinkedList;
import java.util.List;

public class GestorActivos {
    private List<Activo> inventario;

    public GestorActivos() {
        this.inventario = new LinkedList<>();
        inventario.add(new Activo("CPU", 50));
        inventario.add(new Activo("Laptop", 100));
        inventario.add(new Activo("Mouse", 70));
        inventario.add(new Activo("Teclado", 60));
        inventario.add(new Activo("Webcam", 80));
        inventario.add(new Activo("Monitor", 100));
    }

    public List<Activo> getInventario() {
        return inventario;
    }

    public void registrarActivo(Activo activo) {
        this.inventario.add(activo);
    }

    public void eliminarActivo(String nombreActivo) {
        Activo activo = buscarActivo(nombreActivo);
        if (activo != null) {
            inventario.remove(activo);
        }
    }

    public void actualizarActivo(String nombreActivo, Activo nuevoActivo) {
        Activo activo = buscarActivo(nombreActivo);
        if (activo != null) {
            activo.setCantidadDisponible(nuevoActivo.getCantidadDisponible());
        }
    }

    private Activo buscarActivo(String nombreActivo) {
        for (Activo activo : inventario) {
            if (activo.getNombre().equals(nombreActivo)) {
                return activo;
            }
        }
        return null;
    }

    public void ordenarPorCantidad() {

        for (int i = 0; i < inventario.size(); i++) {
            for (int j = 0; j < inventario.size() - 1; j++) {
                if (inventario.get(j).getCantidadDisponible() < inventario.get(j + 1).getCantidadDisponible()) {
                    Activo temp = inventario.get(j + 1);
                    inventario.set(j + 1, inventario.get(j));
                    inventario.set(j, temp);
                }
            }
        }
    }

    public void ordenarPorNombre() {

        for (int i = 0; i < inventario.size(); i++) {
            for (int j = 0; j < inventario.size() - 1; j++) {
                if (inventario.get(j).getNombre().compareTo(inventario.get(j + 1).getNombre()) > 0) {
                    Activo temp = inventario.get(j + 1);
                    inventario.set(j + 1, inventario.get(j));
                    inventario.set(j, temp);
                }
            }
        }

    }

    public void registrarSolicitud(Usuario usuario, String nombreActivo, int cantidad) {
        Activo activo = buscarActivo(nombreActivo); // Obtener el activo del inventario por su nombre
        if (activo != null) {
            int cantidadDisponible = activo.getCantidadDisponible();

            if (cantidadDisponible >= cantidad) {
                activo.setCantidadDisponible(cantidadDisponible - cantidad); // Actualizar la cantidad disponible del
                // activo
                System.out.println("Solicitud de " + cantidad + " " + nombreActivo + "(s) registrada por "
                        + usuario.getNombre() + " " + usuario.getApellido() + ".");

            } else {
                System.out.println("No hay suficientes " + nombreActivo + "(s) disponibles para " + usuario.getNombre()
                        + " " + usuario.getApellido() + ".");
            }

            return;

        }

        System.out.println("El activo '" + nombreActivo + "' no está disponible.");

    }

}
