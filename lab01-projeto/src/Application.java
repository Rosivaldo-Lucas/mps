import controller.usuario.UsuarioFacade;
import ui.UsuarioUI;

public class Application {
    
    public static void main(String[] args) {
        final UsuarioFacade usuarioFacade = new UsuarioFacade();
        final UsuarioUI usuarioUI = new UsuarioUI(usuarioFacade);

        usuarioUI.menu();
    }

}
