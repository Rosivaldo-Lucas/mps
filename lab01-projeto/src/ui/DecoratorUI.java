package ui;

import entity.Usuario;

public interface DecoratorUI {
    String preparaUsuario(Usuario user);

}

class preparadorSimples implements DecoratorUI {

    public String preparaUsuario(Usuario user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getLogin());
        sb.append("\n");
        sb.append(user.getSenha());
        sb.append("\n");
        sb.append(user.getNome());

        return sb.toString();

    }
}

class preparadorCaixaAlta implements DecoratorUI {

    DecoratorUI decorator;

    public preparadorCaixaAlta(DecoratorUI decorator) {
        this.decorator = decorator;
    }

    public String preparaUsuario(Usuario user) {
        return decorator.preparaUsuario(user).toUpperCase();
    }
}