package infra;

import java.util.ArrayList;
import java.util.List;

public class ItemMemoriaDao implements Dao {
    
    private final List<Object> itens = new ArrayList<>();

    @Override
    public void salvar(final Object object) {
        itens.add(object);
    }

}
