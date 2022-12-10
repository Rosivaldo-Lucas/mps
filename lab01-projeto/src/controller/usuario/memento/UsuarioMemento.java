package controller.usuario.memento;

import entity.Usuario;

public class UsuarioMemento {

    private Usuario usuario;

    public UsuarioMemento(final Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
