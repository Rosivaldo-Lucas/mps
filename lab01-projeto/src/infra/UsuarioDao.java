package infra;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao {
    
    private final List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listar() {
        return this.usuarios;
    }

    public Usuario buscarPorLogin(final String login) {
        for (final Usuario usuario : this.usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        
        return null;
    }

    public void salvar(final Usuario usuario) {
        this.usuarios.add(usuario);
    }

}
