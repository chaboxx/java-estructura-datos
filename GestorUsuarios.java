import java.util.ArrayList;

public class GestorUsuarios {

    ArrayList<Usuario> users = new ArrayList<>();

    public void registrarUsuario(Usuario usuario) {
        this.users.add(usuario);
    }

    public void eliminarUsuario(String identificacion) {
        Usuario usuario = buscarUsuario(identificacion);
        if (usuario != null) {
            users.remove(usuario);
        }
    }

    public void actualizarUsuario(String identificacion, Usuario nuevoUsuario) {
        Usuario usuario = buscarUsuario(identificacion);
        if (usuario != null) {
            usuario.setNombre(nuevoUsuario.getNombre());
            usuario.setApellido(nuevoUsuario.getApellido());
        }
    }

    // Método para buscar un usuario en el inventario
    private Usuario buscarUsuario(String identificacion) {
        for (Usuario usuario : users) {
            if (usuario.getIdentificacion().equals(identificacion)) {
                return usuario;
            }
        }
        return null;
    }
}
