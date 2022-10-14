import controller.UsuarioController;
import infra.UsuarioDao;
import ui.UsuarioUI;

public class Application {
    
    public static void main(String[] args) {
        final UsuarioDao usuarioDao = new UsuarioDao();
        final UsuarioController usuarioController = new UsuarioController(usuarioDao);
        final UsuarioUI usuarioUI = new UsuarioUI(usuarioController);

        usuarioUI.menu();
    }

}
