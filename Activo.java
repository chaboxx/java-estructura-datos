// Clase que representa un activo
public class Activo {
    private String nombre; // Utilización de variables de tipo String para el nombre del activo
    private int cantidadDisponible; // Utilización de variables de tipo int para la cantidad disponible del activo

    // Constructor para inicializar un activo con un nombre y cantidad inicial
    public Activo(String nombre, int cantidadInicial) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadInicial;
    }

    // Métodos getters y setters para el activo
    public String getNombre() {
        return nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int nuevaCantidad) {
        cantidadDisponible = nuevaCantidad;
    }
}
