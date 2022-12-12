package ui;

import java.util.Scanner;

public class MenuUI {

  private UsuarioUI usuarioUI;
  private ItemUI itemUI;
  private PedidoUI pedidoUI;

  public MenuUI() { }

  public void exibirMenu() {
    final Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("--------------SISTEMA--------------");
      System.out.println("1 - Ações Cliente");
      System.out.println("2 - Ações Item");
      System.out.println("3 - Ações Pedido");
      System.out.println("4 - Sair");

      final int op = sc.nextInt();

      if (op == 1) {
        this.usuarioUI.menu();
      } else if (op == 2) {
        this.itemUI.exibirMenuItem();
      } else if (op == 3) {
        this.pedidoUI.exibirMenuPedido();
      } else if (op == 4) {
        break;
      }

      sc.nextLine();
    }

    sc.close();
  }

  public void setUsuarioUI(UsuarioUI usuarioUI) {
    this.usuarioUI = usuarioUI;
  }

  public void setItemUI(ItemUI itemUI) {
    this.itemUI = itemUI;
  }

  public void setPedidoUI(PedidoUI pedidoUI) {
    this.pedidoUI = pedidoUI;
  }

}
