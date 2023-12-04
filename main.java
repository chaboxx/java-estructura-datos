// Clase principal que contiene el método main para probar el sistema
public class main {
    public static void main(String[] args) {
        GestorActivos gestor = new GestorActivos(); // Creación del gestor de activos

        // Creación de usuarios
        Usuario usuario1 = new Usuario("Juan", "Perez", "12345");
        Usuario usuario2 = new Usuario("Maria", "Lopez", "67890");

        // Ejemplo de solicitud de activos por parte de los usuarios
        gestor.registrarSolicitud(usuario1, "CPU", 3);
        gestor.registrarSolicitud(usuario2, "Laptop", 2);
        gestor.registrarSolicitud(usuario1, "Monitor", 5);
        gestor.registrarSolicitud(usuario2, "Teclado", 80); // No hay suficientes disponibles
    }
}
