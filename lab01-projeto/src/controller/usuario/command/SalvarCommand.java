package controller.usuario.command;

import controller.usuario.validator.UsuarioValidarController;
import entity.Usuario;
import exception.UsuarioLoginException;
import exception.UsuarioSenhaException;
import infra.UsuarioDao;

public class SalvarCommand implements Command {

  private final Usuario usuario;

  public SalvarCommand(final Usuario usuario) {
    this.usuario = usuario;
  }

  @Override
  public Usuario execute(final UsuarioDao usuarioDao) throws UsuarioLoginException, UsuarioSenhaException {
    final UsuarioValidarController usuarioValidarController = new UsuarioValidarController();

    usuarioValidarController.validarLogin(usuario.getLogin());
    usuarioValidarController.validarSenha(usuario.getSenha());

    usuarioDao.salvar(this.usuario);

    return this.usuario;
  }

}
