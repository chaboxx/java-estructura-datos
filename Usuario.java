// Clase que representa a un usuario
public class Usuario {
    private String nombre; // Utilización de variables de tipo String para el nombre del usuario
    private String apellido; // Utilización de variables de tipo String para el apellido del usuario
    private String identificacion; // Utilización de variables de tipo String para la identificación del usuario

    // Constructor para inicializar un usuario con nombre, apellido e identificación
    public Usuario(String nombre, String apellido, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
    }

    // Métodos getters para el usuario
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }
}
