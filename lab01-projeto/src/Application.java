import controller.usuario.UsuarioFacade;
import ui.ItemUI;
import ui.MenuUI;
import ui.PedidoUI;
import ui.UsuarioUI;

public class Application {
    
    public static void main(String[] args) {
        final UsuarioFacade usuarioFacade = new UsuarioFacade();
        final UsuarioUI usuarioUI = new UsuarioUI(usuarioFacade);

        final ItemUI itemUI = new ItemUI();
        final PedidoUI pedidoUI = new PedidoUI();

        final MenuUI menuUI = new MenuUI();
        menuUI.setUsuarioUI(usuarioUI);
        menuUI.setItemUI(itemUI);
        menuUI.setPedidoUI(pedidoUI);

        menuUI.exibirMenu();
    }

}
