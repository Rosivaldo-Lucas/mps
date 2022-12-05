import controller.UsuarioController;
import controller.UsuarioAdapterController;
import infra.UsuarioDao;
import ui.UsuarioUI;

public class Application {
    
    public static void main(String[] args) {
        final UsuarioDao usuarioDao = new UsuarioDao();
        final UsuarioAdapterController usuarioFromArchiveController = new UsuarioAdapterController();
        final UsuarioController usuarioController = new UsuarioController(usuarioDao);
        final UsuarioUI usuarioUI = new UsuarioUI(usuarioController);

        usuarioUI.menu();
    }

}
