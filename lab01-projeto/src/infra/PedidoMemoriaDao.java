package infra;

import entity.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoMemoriaDao implements Dao {

  private final List<Object> pedidos = new ArrayList<>();

  @Override
  public void salvar(final Object object) {
    this.pedidos.add(object);
  }

  @Override
  public Object buscarPorNome(String codio) {
    Pedido pedidoRetorno = null;

    for (final Object o : this.pedidos) {
      final Pedido pedido = (Pedido) o;

      if (pedido.getCodigo().equals(codio)) {
        pedidoRetorno = pedido;
      }
    }

    return pedidoRetorno;
  }

}
