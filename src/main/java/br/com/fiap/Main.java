package br.com.fiap;

import br.com.fiap.carrinho.model.Carrinho;
import br.com.fiap.cliente.model.Cliente;
import br.com.fiap.estoque.model.Estoque;
import br.com.fiap.fornecedor.model.Fornecedor;
import br.com.fiap.pessoa.model.PessoaFisica;
import br.com.fiap.pessoa.model.Sexo;
import br.com.fiap.produto.model.ProdutoPerecivel;
import br.com.fiap.venda.model.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle-fiap");
        EntityManager manager = factory.createEntityManager();

        PessoaFisica chicoBento = new PessoaFisica();
        chicoBento.setSexo(Sexo.MASCULINO)
                .setCPF(getCpf())
                .setNome("Francisco Bento da Silva de Souza")
                .setNascimento(LocalDate.now().minusYears(30));


        Fornecedor fazendeiro = new Fornecedor();
        fazendeiro.setPessoa(chicoBento);

        var alface = new ProdutoPerecivel();
        alface.setNome("Alface americana");
        alface.setFabricacao(LocalDateTime.now().minusDays(5));
        alface.setDescricao("Alface maravilhosa para se fazer um hamburger");
        alface.setFornecedor(fazendeiro);
        alface.setDiasValidade(10);
        alface.setPreco(5);


        var brocolis = new ProdutoPerecivel();
        brocolis.setNome("Brocolis Ninja");
        brocolis.setFabricacao(LocalDateTime.now().minusDays(7));
        brocolis.setDescricao("Este Brocolis na salada ....");
        brocolis.setFornecedor(fazendeiro);
        brocolis.setDiasValidade(10);
        brocolis.setPreco(10);

        Estoque estoque = new Estoque();
        estoque.setLocal("Armazem do Benezinho");
        estoque.addProduto(brocolis);
        estoque.addProduto(alface);

        PessoaFisica ricardo = new PessoaFisica();
        ricardo.setNome("Ricardo Sung Hoon Kim").setNascimento(LocalDate.of(2003, 4, 12));
        ricardo.setCPF(getCpf()).setSexo(Sexo.MASCULINO);

        Cliente vip = new Cliente();
        vip.setPessoa(ricardo);

        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(vip);
        carrinho.addProduto(brocolis).addProduto(alface);

        Venda venda = new Venda();
        venda.setCarrinho(carrinho).setData(LocalDateTime.now());

        venda.setValor(carrinho.getValorTotal());


        System.out.println(venda);


        Long id = 1L;
        findByID(manager, id);
        findAll(manager);

        manager.getTransaction().begin();
        manager.persist(venda);
        manager.getTransaction().commit();

    }


    private static void findAll(EntityManager manager) {
        String jpql = "From Venda";
        List<Venda> list = manager.createQuery(jpql).getResultList();
        list.stream().forEach(System.out::println);
    }

    private static void findByID(EntityManager manager, long id) {
        Venda venda = manager.find(Venda.class, id);
        System.out.println(venda);
    }

    private static String getCpf() {
        return String.valueOf(new Random().nextInt(999999999));
    }

}