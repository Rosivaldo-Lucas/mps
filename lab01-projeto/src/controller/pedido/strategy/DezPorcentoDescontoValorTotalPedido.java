package controller.pedido.strategy;

import entity.Item;

import java.util.List;

public class DezPorcentoDescontoValorTotalPedido implements CalcularValorTotalPedido {

  @Override
  public double calcularValor(final List<Item> itens) {
    double valorTotalPedido = 0;

    for (final Item item : itens) {
      final Double valorItem = item.getValor();

      valorTotalPedido += valorItem;
    }

    return valorTotalPedido * 0.10;
  }

}
