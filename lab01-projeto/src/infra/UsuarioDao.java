package infra;

import entity.Usuario;

import java.util.List;

public interface UsuarioDao {

  List<Usuario> listar();

  Usuario buscarPorLogin(final String login);

  void salvar(final Usuario usuario);

  void atualizarNomeUsuario(final String login, final String novoNomeUsuario);

}
