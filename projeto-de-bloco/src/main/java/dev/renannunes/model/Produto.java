package dev.renannunes.model;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class Produto {
    @CsvBindByName(column = "IDPRODUTO")
    private Integer idProduto;
    @CsvBindByName(column = "NOME")
    private String nome;
    @CsvBindByName(column = "DESCRICAO")
    private String descricao;
    @CsvBindByName(column = "CATEGORIA")
    private String categoria;
    @CsvBindByName(column = "PRECO")
    private BigDecimal preco;
    @CsvBindByName(column = "TEMPOPREPARO")
    private Integer tempoPreparo;
    @CsvBindByName(column = "DISPONIVEL")
    private Boolean disponivel;
    @CsvBindByName(column = "IMAGEM")
    private String imagem;

    public Produto(){}

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

        return sb.toString();
    }
}
