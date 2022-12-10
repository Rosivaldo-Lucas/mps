package controller.item;

import entity.Item;
import infra.Dao;
import infra.ItemMemoriaFactory;

public class ItemController {
    
    private final ItemController itemController = new ItemController();

    private final Dao itemDao = new ItemMemoriaFactory().criarDao();

    private ItemController() { }

    public ItemController obterInstancia() {
        return this.itemController;
    }

    public void adicionar(final String nome, final Double valor) {
        final Item novoItem = new Item();
        novoItem.setNome(nome);
        novoItem.setValor(valor);

        this.itemDao.salvar(novoItem);
    }

}
