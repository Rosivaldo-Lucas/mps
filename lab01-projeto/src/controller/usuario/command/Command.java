package controller.usuario.command;

import infra.UsuarioDao;

public interface Command {

  Object execute(final UsuarioDao usuarioDao) throws Exception;

}
