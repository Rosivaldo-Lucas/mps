package controller.usuario.command;

import entity.Usuario;
import infra.UsuarioDao;

public interface Command {

  Object execute(final UsuarioDao usuarioDao) throws Exception;

}
