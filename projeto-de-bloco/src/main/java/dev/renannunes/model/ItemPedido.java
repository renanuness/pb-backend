package dev.renannunes.model;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class ItemPedido {
    @CsvBindByName(column = "IDITEM")
    private Integer idItem;
    @CsvBindByName(column = "IDPEDIDO")
    private Integer idPedido;
    @CsvBindByName(column = "IDPRODUTO")
    private Integer idProduto;
    @CsvBindByName(column = "QUANTIDADE")
    private Integer quantidade;
    @CsvBindByName(column = "PRECOUNITARIO")
    private BigDecimal precoUnitario;
    @CsvBindByName(column = "OBSERVACOES")
    private String observacoes;

    public ItemPedido(){}

    public ItemPedido( Integer idItem, Integer idPedido, Integer idProduto, Integer quantidade, BigDecimal precoUnitario, String observacoes) {
        this.idItem = idItem;
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
