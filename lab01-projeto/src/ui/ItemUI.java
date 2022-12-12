package ui;

import controller.item.ItemController;

import java.util.Scanner;

public class ItemUI {

  private final Scanner sc = new Scanner(System.in);

  private final ItemController itemController = ItemController.obterInstancia();

  public void exibirMenuItem() {
    while (true) {
      System.out.println("-------------ITEM-------------");
      System.out.println("1 - Adicionar item");
      System.out.println("2 - Voltar");

      final int op = this.sc.nextInt();

      if (op == 1) {
        System.out.print("Nome item: ");
        final String nome = sc.next();

        System.out.print("Valor item: ");
        final Double valor = sc.nextDouble();

        this.itemController.adicionar(nome, valor);
      } else if (op == 2) {
        break;
      }
    }
  }

}
