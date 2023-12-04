import java.util.Scanner;
import java.util.Random;

// Clase principal que contiene el método main para probar el sistema
public class main {
    public static void main(String[] args) {
        GestorActivos gestor = new GestorActivos(); // Creación del gestor de activos

        Activo gpus = new Activo("GPUS", 100);
        gestor.registrarActivo("GPUS", gpus);
        gestor.eliminarActivo("Laptop");
        gestor.actualizarActivo("CPU", new Activo("CPU", 100));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una Opcion: ");
        System.out.println("1. Solicitar Activo(s)");
        System.out.println("2. Ver inventario de Activos actual");

        String opcion = scanner.nextLine();

        if (opcion.equals("1")) {
            System.out.println("Escriba su nombre por favor: ");
            String nombreUsuario = scanner.nextLine();
            System.out.println("Escriba su apellido por favor: ");
            String apellidoUsuario = scanner.nextLine();

            System.out.println("Escribe el nombre del activo que deseas: ");
            String nombre = scanner.nextLine();
            System.out.println("Escribe la cantidad que deseas: ");
            String c = scanner.nextLine();
            Integer cantidad = Integer.parseInt(c);

            Random random = new Random();
            int randomNumber = random.nextInt(100);
            String identificacion = Integer.toString(randomNumber);

            gestor.registrarSolicitud(new Usuario(nombreUsuario, apellidoUsuario, identificacion), nombre, cantidad);

        } else if (opcion.equals("2")) {
            gestor.getInventario().forEach((key, value) -> {
                System.out.println("Activo: " + key + " Cantidad: " + value.getCantidadDisponible());
            });

        } else {
            System.out.println("Opcion no valida");
        }

    }
}
