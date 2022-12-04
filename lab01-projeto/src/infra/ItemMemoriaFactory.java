package infra;

public class ItemMemoriaFactory extends DaoFactory {

    private final Dao itemDao = new ItemMemoriaDao();

    @Override
    public Dao criarDao() {
        return this.itemDao;
    }

}
