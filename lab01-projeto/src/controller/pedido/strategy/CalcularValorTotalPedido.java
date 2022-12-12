package controller.pedido.strategy;

import entity.Item;

import java.util.List;

public interface CalcularValorTotalPedido {

  double calcularValor(final List<Item> itens);

}
