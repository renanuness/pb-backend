package dev.renannunes.model;

import java.math.BigDecimal;

public class Produto {
    private Integer idProduto;
    private String nome;
    private String descricao;
    private String categoria;
    private BigDecimal preco;
    private Integer tempoPreparo;
    private Boolean disponivel;
    private String imagem;

    public Produto(Integer idProduto, String nome, String descricao, String categoria, BigDecimal preco, Integer tempoPreparo, Boolean disponivel, String imagem) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.tempoPreparo = tempoPreparo;
        this.disponivel = disponivel;
        this.imagem = imagem;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getId() {
        return idProduto;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(idProduto);
        sb.append("\t");
        sb.append(nome);
        sb.append("\t");
        sb.append(categoria);
        sb.append("\t");
        sb.append(preco);
        sb.append("\t");
        sb.append(tempoPreparo);
        sb.append("\t");

        return toString();
    }
}
