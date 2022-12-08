package entity;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    
    private List<Pedido> pedidos = new ArrayList<>();
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
