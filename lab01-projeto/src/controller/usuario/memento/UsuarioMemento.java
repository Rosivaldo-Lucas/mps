package controller.usuario.memento;

import controller.usuario.command.Command;

public class UsuarioMemento {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

}
