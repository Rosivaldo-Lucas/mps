package controller.pedido;

import controller.item.ItemController;
import controller.pedido.strategy.CalcularValorTotalPedido;
import entity.Item;
import entity.Pedido;
import infra.Dao;
import infra.ItemMemoriaFactory;
import infra.PedidoMemoriaFactory;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

  private static final PedidoController pedidoController = new PedidoController();

  private final ItemController itemController = ItemController.obterInstancia();

  private final Dao pedidoDao = new PedidoMemoriaFactory().criarDao();

  private PedidoController() { }

  public static PedidoController obterInstancia() {
    return pedidoController;
  }

  public void adicionar(final String codigo, final List<String> itens, final CalcularValorTotalPedido calcularValorTotalPedido) {
    final List<Item> itensPedido = new ArrayList<>();

    for (final String nomeItem : itens) {
      final Item item = this.itemController.buscarPorNome(nomeItem);

      if (item != null) {
        itensPedido.add(item);
      }
    }

    final Pedido pedido = new Pedido();
    pedido.setCodigo(codigo);
    pedido.setItens(itensPedido);

    final double valorTotalPedido = calcularValorTotalPedido.calcularValor(itensPedido);

    pedido.setValorTotal(valorTotalPedido);

    this.pedidoDao.salvar(pedido);
  }

  public Pedido buscarPorCodigo(final String codigo) {
    final Pedido pedido = (Pedido) this.pedidoDao.buscarPorNome(codigo);

    return pedido;
  }

}
