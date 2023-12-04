import java.util.HashMap;
import java.util.Map;

// Clase que gestiona los activos y las solicitudes de los usuarios
public class GestorActivos {
    private Map<String, Activo> inventario; // Utilización de un HashMap para almacenar los activos disponibles

    // Constructor para inicializar el gestor de activos e inicializar el inventario
    public GestorActivos() {
        this.inventario = new HashMap<>(); // Creación de un HashMap para el inventario de activos

        // Inicialización del inventario con activos y cantidades disponibles
        inventario.put("CPU", new Activo("CPU", 50));
        inventario.put("Laptop", new Activo("Laptop", 100));
        inventario.put("Mouse", new Activo("Mouse", 70));
        inventario.put("Teclado", new Activo("Teclado", 60));
        inventario.put("Webcam", new Activo("Webcam", 80));
        inventario.put("Monitor", new Activo("Monitor", 100));
    }

    public Map<String, Activo> getInventario() {
        return inventario;
    }

    public void registrarActivo(String key, Activo activo) {
        this.inventario.put(key, activo);
    }

    public void eliminarActivo(String keyActivo) {
        inventario.remove(keyActivo);
    }

    public void actualizarActivo(String keyActivo, Activo activo) {
        inventario.replace(keyActivo, activo);
    }

    // Método para registrar las solicitudes de los usuarios
    public void registrarSolicitud(Usuario usuario, String nombreActivo, int cantidad) {
        Activo activo = inventario.get(nombreActivo); // Obtener el activo del inventario por su nombre
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