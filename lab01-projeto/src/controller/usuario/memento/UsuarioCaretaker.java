package controller.usuario.memento;

import java.util.Stack;

public class UsuarioCaretaker {
    
    private final Stack<UsuarioMemento> usuariosMemento = new Stack<>();

    public void salvarVersaoUsuarios(final UsuarioMemento usuarioMemento) {
        this.usuariosMemento.push(usuarioMemento);
    }

    public UsuarioMemento restaurarVersaoUsuarios() {
        return this.usuariosMemento.pop();
    }

}
