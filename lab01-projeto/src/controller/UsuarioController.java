package controller;

import java.util.List;

import entity.Usuario;
import exception.UsuarioLoginException;
import exception.UsuarioNaoEncontradoException;
import exception.UsuarioSenhaException;
import infra.UsuarioDao;

public class UsuarioController {

    private final UsuarioDao usuarioDao;

    public UsuarioController(final UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<Usuario> listar() {
        return this.usuarioDao.listar();
    }

    public Usuario buscar(final String login) throws UsuarioNaoEncontradoException {
        final Usuario usuario = this.usuarioDao.buscarPorLogin(login);
        
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

        return usuario;
    }

    public void adicionar(final String login, final String senha) throws UsuarioLoginException, UsuarioSenhaException {
        final UsuarioValidarController usuarioValidarController = new UsuarioValidarController();

        usuarioValidarController.validarLogin(login);
        usuarioValidarController.validarSenha(senha);

        final Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);

        this.usuarioDao.salvar(usuario);
    }

    public void deletar() {

    }

}
