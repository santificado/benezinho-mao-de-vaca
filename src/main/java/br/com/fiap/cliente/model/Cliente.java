package br.com.fiap.cliente.model;

import br.com.fiap.pessoa.model.Pessoa;

public class Cliente {

    private Long id;

    private Pessoa pessoa;

    public Cliente() {
    }

    public Cliente(Long id, Pessoa pessoa) {
        this.id = id;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public Cliente setId(Long id) {
        this.id = id;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Cliente setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                '}';
    }
}
