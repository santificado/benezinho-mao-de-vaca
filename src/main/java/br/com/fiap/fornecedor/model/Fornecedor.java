package br.com.fiap.fornecedor.model;

import br.com.fiap.pessoa.model.Pessoa;

/**
 * Representa um fornecedor
 */
public class Fornecedor {

    private Long id;

    private Pessoa pessoa;

    public Fornecedor() {
    }

    public Fornecedor(Long id, Pessoa pessoa) {
        this.id = id;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public Fornecedor setId(Long id) {
        this.id = id;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Fornecedor setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }


    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                '}';
    }
}
