package controller.usuario.command;

import entity.Usuario;
import infra.UsuarioDao;

public class AtualizarNomeCommand implements Command {

  private final String login;
  private final String novoNome;

  public AtualizarNomeCommand(final String login, final String novoNome) {
    this.login = login;
    this.novoNome = novoNome;
  }

  @Override
  public Object execute(final UsuarioDao usuarioDao) throws Exception {
    usuarioDao.atualizarNomeUsuario(this.login, this.novoNome);

    final Usuario usuario = usuarioDao.buscarPorLogin(login);

    return usuario;
  }

}
