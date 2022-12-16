package ui;

import controller.pedido.PedidoController;
import controller.pedido.strategy.CalcularValorTotalPedido;
import controller.pedido.strategy.DezPorcentoDescontoValorTotalPedido;
import controller.pedido.strategy.SemDescontoValorTotalPedido;
import entity.Item;
import entity.Pedido;
import static ui.Clear.clear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoUI {

  private final Scanner sc = new Scanner(System.in);

  private final PedidoController pedidoController = PedidoController.obterInstancia();

  public void exibirMenuPedido() {
    clear();
    while (true) {
      System.out.println("-------------PEDIDO-------------");
      System.out.println("1 - Fazer pedido");
      System.out.println("2 - Buscar pedido");
      System.out.println("3 - Voltar");

      final int op = this.sc.nextInt();

      if (op == 1) {
        clear();
        System.out.print("Código: ");
        final String codigo = this.sc.next();

        final List<String> itens = new ArrayList<>();

        while (true) {
          System.out.print("Informe o nome do item: ");
          final String nomeItem = sc.next();

          itens.add(nomeItem);

          System.out.println("Deseja adicionar mais um item? (s/n)");

          final String resp = this.sc.next();

          if (resp.equals("n")) {
            clear();
            break;
          }
        }

        final CalcularValorTotalPedido calcularValorTotalPedido;

        if (itens.size() >= 2) {
          calcularValorTotalPedido = new DezPorcentoDescontoValorTotalPedido();
        } else {
          calcularValorTotalPedido = new SemDescontoValorTotalPedido();
        }

        this.pedidoController.adicionar(codigo, itens, calcularValorTotalPedido);
      } else if (op == 2) {
        clear();
        System.out.print("Informe o código do pedido: ");

        final String codigo = this.sc.next();

        final Pedido pedido = this.pedidoController.buscarPorCodigo(codigo);

        System.out.println("Código: " + pedido.getCodigo());
        System.out.println("Itens: ");

        int i = 1;

        for (final Item item : pedido.getItens()) {
          System.out.println("Item " + i + ": " + item.getNome());

          i++;
        }

        System.out.println("Valor total pedido: " + pedido.getValorTotal());
      } else if (op == 3) {
        clear();
        break;
      }
    }
  }

}
