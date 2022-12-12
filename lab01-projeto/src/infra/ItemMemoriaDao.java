package infra;

import entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemMemoriaDao implements Dao {
    
    private final List<Object> itens = new ArrayList<>();

    @Override
    public void salvar(final Object object) {
        this.itens.add(object);
    }

    @Override
    public Object buscarPorNome(final String nome) {
        Item itemRetorno = null;

        for (final Object o : this.itens) {
            final Item item = (Item) o;

            if (item.getNome().equals(nome)) {
                itemRetorno = item;
            }
        }

        return itemRetorno;
    }

}
