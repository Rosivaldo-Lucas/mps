package controller.usuario.command;

import entity.Usuario;
import infra.UsuarioDao;

import java.util.List;

public class ListarCommand implements Command {
  @Override
  public List<Usuario> execute(final UsuarioDao usuarioDao) {
    return usuarioDao.listar();
  }
}
