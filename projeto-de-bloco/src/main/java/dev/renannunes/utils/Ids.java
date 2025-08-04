package dev.renannunes.utils;

public class Ids {
    private Integer idCliente;
    private Integer idProduto;
    private Integer idPedido ;
    private Integer idItem;

    public Ids(Integer idCliente, Integer idProduto, Integer idPedido, Integer idItem){

        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.idPedido = idPedido;
        this.idItem = idItem;
    }


    public Integer getIdCliente() {
        return idCliente;
    }

    public void incrementIdCliente() {
        this.idCliente++;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void incrementIdProduto() {
        this.idProduto++;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void incrementIdPedido() {
        this.idPedido++;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void incrementIdItem() {
        this.idItem++;
    }
}
