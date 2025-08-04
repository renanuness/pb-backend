package dev.renannunes.model;

import java.math.BigDecimal;

public class ItemPedido {
    private Integer idItem;
    private Integer idPedido;
    private Integer idProduto;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private String observacoes;

    public ItemPedido(Integer idPedido, Integer idProduto, Integer quantidade, BigDecimal precoUnitario, String observacoes) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Integer getIdProduto(){
        return idProduto;
    }

    // Construtores, getters e setters
    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void incrementarQuantidade(){
        quantidade++;
    }
}
