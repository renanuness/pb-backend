package dev.renannunes.model;

import java.time.LocalDateTime;

public class Cliente {
    private Integer idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private String enderecoEntrega;
    private LocalDateTime dataCadastro;
    private Boolean ativo;

    public Cliente(Integer idCliente, String nome, String cpf, String email, String telefone, String senha, String enderecoEntrega, LocalDateTime dataCadastro, Boolean ativo) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.enderecoEntrega = enderecoEntrega;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

    public String getEndereco() {
        return enderecoEntrega;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(idCliente);
        sb.append("\t");
        sb.append(nome);
        sb.append("\t");
        sb.append(cpf);
        sb.append("\t");
        sb.append(email);
        sb.append("\t");

        return sb.toString();
    }

}


