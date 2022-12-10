package infra;

import entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public List<Usuario> listar() {
        return this.usuarios;
    }

    @Override
    public Usuario buscarPorLogin(final String login) {
        for (final Usuario usuario : this.usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        
        return null;
    }

    @Override
    public void salvar(final Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void atualizarNomeUsuario(final String login, final String novoNomeUsuario) {
        for (final Usuario usuario : this.usuarios) {
            if (usuario.getLogin().equals(login)) {
                usuario.setNome(novoNomeUsuario);

                break;
            }
        }
    }

}
