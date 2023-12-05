import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GestorActivos gestor = new GestorActivos();
        GestorUsuarios gestorUsuarios = new GestorUsuarios();

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
                System.out.println("1. Administrar Activos");
                System.out.println("2. Administrar Usuarios");

                String opcionAdmin = scanner.nextLine();
                if (opcionAdmin.equals("1")) {
                    administrarActivos(gestor, scanner);

                } else if (opcionAdmin.equals("2")) {
                    administrarUsuarios(gestorUsuarios, scanner);
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
        System.out.println("3. Administrar");
        System.out.println("4. Salir");
    }

    public static void administrarActivos(GestorActivos gestor, Scanner scanner) {
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
        }
    }

    public static void administrarUsuarios(GestorUsuarios gestorUsuarios, Scanner scanner) {
        System.out.println("Introduce una Opcion: ");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Eliminar Usuario");
        System.out.println("3. Actualizar Usuario");
        System.out.println("4. Obtener Usuarios");

        String opcionAdmin = scanner.nextLine();

        if (opcionAdmin.equals("1")) {
            System.out.println("Escribe el nombre del usuario que deseas registrar: ");
            String nombre = scanner.nextLine();
            System.out.println("Escribe el apellido del usuario que deseas registrar: ");
            String apellido = scanner.nextLine();
            System.out.println("Escribe la identificacion del usuario que deseas registrar: ");
            String identificacion = scanner.nextLine();

            gestorUsuarios.registrarUsuario(new Usuario(nombre, apellido, identificacion));
            System.out.println("Usuario registrado con exito");

        } else if (opcionAdmin.equals("2")) {
            System.out.println("Escribe el id del usuario que deseas eliminar: ");
            String id = scanner.nextLine();

            gestorUsuarios.eliminarUsuario(id);
            System.out.println("Usuario eliminado con exito");

        } else if (opcionAdmin.equals("3")) {
            System.out.println("Escribe el id del usuario que deseas actualizar: ");
            String identificacion = scanner.nextLine();
            System.out.println("Escribe el nuevo nombre del usuario: ");
            String nombre = scanner.nextLine();
            System.out.println("Escribe el nuevo apellido del usuario: ");
            String apellido = scanner.nextLine();

            gestorUsuarios.actualizarUsuario(identificacion, new Usuario(nombre, apellido, identificacion));
            System.out.println("Usuario actualizado con exito");

        } else if (opcionAdmin.equals("4")) {
            for (Usuario usuario : gestorUsuarios.getUsuarios()) {
                System.out.println("id: "
                        + usuario.getIdentificacion() + "Usuario: " + usuario.getNombre() + " "
                        + usuario.getApellido());
            }

        } else {
            System.out.println("Opcion no valida");
        }
    }

}
