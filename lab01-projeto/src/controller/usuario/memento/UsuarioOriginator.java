package controller.usuario.memento;

import entity.Usuario;

public class UsuarioOriginator {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuarios) {
        this.usuario = usuarios;
    }

    public UsuarioMemento salvarEstadoUsuario() {
        return new UsuarioMemento(this.usuario);
    }

    public void resetarEstadoUsuario(final UsuarioMemento usuarioMemento) {
        final Usuario usuario = usuarioMemento.getUsuario();

        this.usuario = usuario;
    }

}
