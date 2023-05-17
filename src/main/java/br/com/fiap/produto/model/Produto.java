package br.com.fiap.produto.model;

import br.com.fiap.fornecedor.model.Fornecedor;

import java.time.LocalDateTime;

public abstract class Produto {


    Long id;

    private String nome;

    private String descricao;

    private double preco;

    private LocalDateTime fabricacao;


    private Fornecedor fornecedor;


    public Produto() {
    }

    public Produto(String nome, String descricao, double preco, LocalDateTime fabricacao, Fornecedor fornecedor) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.fabricacao = fabricacao;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDateTime getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(LocalDateTime fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", fabricacao=" + fabricacao +
                ", fornecedor=" + fornecedor +
                '}';
    }
}
