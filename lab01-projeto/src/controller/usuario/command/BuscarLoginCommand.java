package controller.usuario.command;

import entity.Usuario;
import exception.UsuarioNaoEncontradoException;
import infra.UsuarioDao;

public class BuscarLoginCommand implements Command {

  private String login;

  public BuscarLoginCommand(final String login) {
    this.login = login;
  }

  @Override
  public Object execute(final UsuarioDao usuarioDao) throws Exception {
    final Usuario usuario = usuarioDao.buscarPorLogin(this.login);

    if (usuario == null) {
      throw new UsuarioNaoEncontradoException("Usuário não encontrado");
    }

    return usuario;
  }

}
