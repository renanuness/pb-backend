package dev.renannunes.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDateTime;

public class User {
    @CsvBindByName(column = "IDCLIENTE")
    private Integer id;
    @CsvBindByName(column = "NOME")
    private String nome;
    @CsvBindByName(column = "CPF")
    private String cpf;
    @CsvBindByName(column = "EMAIL")
    private String email;
    @CsvBindByName(column = "TELEFONE")
    private String telefone;
    @CsvBindByName(column = "SENHA")
    private String senha;
    @CsvBindByName(column = "ENDERECOENTREGA")
    private String enderecoEntrega;
    @CsvBindByName(column = "DATACADASTRO")
    @CsvDate("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private LocalDateTime dataCadastro;
    @CsvBindByName(column = "ATIVO")
    private Boolean ativo;

    public User(){}

    public User(Integer id, String nome, String cpf, String email, String telefone, String senha, String enderecoEntrega, LocalDateTime dataCadastro, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.enderecoEntrega = enderecoEntrega;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

    public Integer getId(){
        return id;
    }

    public String getEndereco() {
        return enderecoEntrega;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append("\t");
        sb.append(nome);
        sb.append("\t");
        sb.append(cpf);
        sb.append("\t");
        sb.append(email);
        sb.append("\t\n");

        return sb.toString();
    }

    public void setDataCadastro(String dataString) {
        this.dataCadastro = LocalDateTime.parse(dataString);
    }
}


