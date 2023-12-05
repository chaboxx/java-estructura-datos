import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GestorActivos gestor = new GestorActivos();

        Scanner scanner = new Scanner(System.in);
        imprimirOpciones();

        String opcion = scanner.nextLine();

        while (!opcion.equals("4")) {

            if (opcion.equals("4")) {
                break;
            }

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

                gestor.registrarSolicitud(new Usuario(nombreUsuario, apellidoUsuario, identificacion), nombre,
                        cantidad);

            } else if (opcion.equals("2")) {
                for (Activo activo : gestor.getInventario()) {
                    System.out
                            .println("Activo: " + activo.getNombre() + " Cantidad: " + activo.getCantidadDisponible());
                }

            } else if (opcion.equals("3")) {
                System.out.println("Introduce una Opcion: ");
                System.out.println("1. Registrar Activo");
                System.out.println("2. Eliminar Activo");
                System.out.println("3. Actualizar Activo");
                System.out.println("4. Ordenar Activos por cantidad disponible");
                System.out.println("5. Ordenar Activos por nombre");

                String opcionAdmin = scanner.nextLine();

                if (opcionAdmin.equals("1")) {
                    System.out.println("Escribe el nombre del activo que deseas registrar: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Escribe la cantidad que deseas registrar: ");
                    String c = scanner.nextLine();
                    Integer cantidad = Integer.parseInt(c);

                    gestor.registrarActivo(new Activo(nombre, cantidad));
                    System.out.println("Activo registrado con exito");

                } else if (opcionAdmin.equals("2")) {
                    System.out.println("Escribe el nombre del activo que deseas eliminar: ");
                    String nombre = scanner.nextLine();

                    gestor.eliminarActivo(nombre);
                    System.out.println("Activo eliminado con exito");

                } else if (opcionAdmin.equals("3")) {
                    System.out.println("Escribe el nombre del activo que deseas actualizar: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Escribe la nuevo cantidad del activo: ");
                    String c = scanner.nextLine();
                    Integer cantidad = Integer.parseInt(c);

                    gestor.actualizarActivo(nombre, new Activo(nombre, cantidad));
                    System.out.println("Activo actualizado con exito");

                } else if (opcionAdmin.equals("4")) {
                    gestor.ordenarPorCantidad();
                    System.out.println("Activos ordenados por cantidad disponible");

                } else if (opcionAdmin.equals("5")) {
                    gestor.ordenarPorNombre();
                    System.out.println("Activos ordenados por nombre");

                } else {
                    System.out.println("Opcion no valida");
                }

            } else {
                System.out.println("Opcion no valida");
            }

            imprimirOpciones();
            opcion = scanner.nextLine();
        }

    }

    public static void imprimirOpciones() {
        System.out.println("Introduce una Opcion: ");
        System.out.println("1. Solicitar Activo(s)");
        System.out.println("2. Ver inventario de Activos actual");
        System.out.println("3. Administrar Activos");
        System.out.println("4. Salir");
    }
}
