package entity;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private Integer codigo;
    private Double valorTotal;
    private List<Item> itens = new ArrayList<>();

    public Integer getCodigo() {
        return codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Double getValorTotal() {
        return valorTotal;
    }
    
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public List<Item> getItens() {
        return itens;
    }
    
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
