package infra;

public class PedidoMemoriaFactory extends DaoFactory {

  private final Dao pedidoDao = new PedidoMemoriaDao();

  @Override
  public Dao criarDao() {
    return this.pedidoDao;
  }

}
