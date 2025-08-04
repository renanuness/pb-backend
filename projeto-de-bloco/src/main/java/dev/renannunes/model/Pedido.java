package dev.renannunes.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer idPedido;
    private Cliente cliente;
    private LocalDateTime dataPedido;
    private String status;
    private BigDecimal valorTotal;
    private String formaPagamento;
    private String enderecoEntrega;
    private String observacoes;

    private List<ItemPedido> itens;

    public Pedido(Cliente cliente, LocalDateTime dataPedido, String status, String formaPagamento, String enderecoEntrega, String observacoes) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.status = status;
        this.formaPagamento = formaPagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.observacoes = observacoes;
        itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, String observacoes){
        for(var item : itens){
            if(item.getIdProduto() == produto.getId()){
                item.incrementarQuantidade();
                return;
            }
        }

        var item = new ItemPedido(idPedido, produto.getId(), 1, produto.getPreco(), observacoes);
        itens.add(item);
    }
    public void calcularTotal() {
        this.valorTotal = itens.stream()
                .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}