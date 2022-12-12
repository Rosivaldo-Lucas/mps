package controller.item;

import entity.Item;
import infra.Dao;
import infra.ItemMemoriaFactory;

public class ItemController {
    
    private static final ItemController itemController = new ItemController();

    private final Dao itemDao = new ItemMemoriaFactory().criarDao();

    private ItemController() { }

    public static ItemController obterInstancia() {
        return itemController;
    }

    public void adicionar(final String nome, final Double valor) {
        final Item novoItem = new Item();
        novoItem.setNome(nome);
        novoItem.setValor(valor);

        this.itemDao.salvar(novoItem);
    }

    public Item buscarPorNome(final String nome) {
        final Item item = (Item) this.itemDao.buscarPorNome(nome);

        return item;
    }

}
