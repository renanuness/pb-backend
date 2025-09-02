package dev.renannunes.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvIgnore;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    @CsvBindByName(column = "ID")
    private Integer id;
    @CsvIgnore
    private User cliente;
    @CsvBindByName(column = "DATAPEDIDO")
    @CsvDate("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private LocalDateTime dataPedido;
    @CsvBindByName(column = "STATUS")
    private String status;
    @CsvBindByName(column = "VALORTOTAL")
    private BigDecimal valorTotal;
    @CsvBindByName(column = "FORMAPAGAMENTO")
    private String formaPagamento;
    @CsvBindByName(column = "ENDERECOENTREGA")
    private String enderecoEntrega;
    @CsvBindByName(column = "OBSERVACOES")
    private String observacoes;
    @CsvIgnore
    private List<ItemPedido> itens;

    public Order(){}
    public Order(Integer id, User cliente, LocalDateTime dataPedido, String status, String formaPagamento, String enderecoEntrega, String observacoes) {
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.status = status;
        this.formaPagamento = formaPagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.observacoes = observacoes;
        itens = new ArrayList<>();
    }

    public void adicionarItem(Product produto, String observacoes, Integer idItem){
        for(var item : itens){
            if(item.getIdProduto() == produto.getId()){
                item.incrementarQuantidade();
                return;
            }
        }

        var item = new ItemPedido(idItem, id, produto.getId(), 1, produto.getPreco(), observacoes);
        itens.add(item);
    }
    public void calcularTotal() {
        this.valorTotal = itens.stream()
                .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getId() {
        return id;
    }

    public List<ItemPedido> getItens(){
        return itens;
    }

    public String toString(){
        calcularTotal();
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append("\t");
        sb.append(valorTotal);
        sb.append("\t");

        return sb.toString();
    }
}