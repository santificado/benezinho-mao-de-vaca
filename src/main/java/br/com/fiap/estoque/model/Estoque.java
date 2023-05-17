package br.com.fiap.estoque.model;

import br.com.fiap.produto.model.Produto;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Estoque {

    private Long id;

    //PRODUTO_ESTOCADO
    private Collection<Produto> produtos = new LinkedHashSet<>();

    private String local;

    public Estoque() {
    }

    public Estoque(Collection<Produto> produtos, String local) {
        this.produtos = produtos;
        this.local = local;
    }

    public Collection<Produto> getProdutos() {
        return Collections.unmodifiableCollection(produtos);
    }

    public Estoque addProduto(Produto produto) {
        this.produtos.add(produto);
        return this;
    }

    public Estoque removeProduto(Produto produto) {
        this.produtos.remove(produto);
        return this;
    }

    public String getLocal() {
        return local;
    }

    public Estoque setLocal(String local) {
        this.local = local;
        return this;
    }


    @Override
    public String toString() {
        return "Estoque{" +
                "produtos=" + produtos +
                ", local='" + local + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Estoque setId(Long id) {
        this.id = id;
        return this;
    }
}
