package br.com.fiap.pessoa.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PESSOA_FISICA",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_CPF", columnNames = "NR_CPF")
        })
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {
    @Column(name = "NR_CPF")
    private String CPF;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_FILHOS",
            joinColumns = {
                    @JoinColumn(
                            name = "ID_PAI",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(name = "FK_PAI_FILHO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ID_FILHO",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(name = "FK_FILHO_PAI")
                    )
            }
    )
    private Set<PessoaFisica> filhos = new LinkedHashSet<>();


    public PessoaFisica() {
    }
    public PessoaFisica(Long id, String nome, LocalDate nascimento, String CPF, Sexo sexo, Set<PessoaFisica> filhos) {
        super(id, nome, nascimento);
        this.CPF = CPF;
        this.sexo = sexo;
        this.filhos = filhos;
    }


    public PessoaFisica addFilho(PessoaFisica filho) {
        if (filho.equals(this)) throw new RuntimeException("Eu não posso ser ao mesmo tempo pai e filho");
        //Adiciono um filho meu
        this.filhos.add(filho);
        return this;
    }

    public PessoaFisica removeFilho(PessoaFisica filho) {
        this.filhos.remove(filho);
        return this;
    }

    public String getCPF() {
        return CPF;
    }

    public PessoaFisica setCPF(String CPF) {
        this.CPF = CPF;
        return this;
    }


    public Sexo getSexo() {
        return sexo;
    }

    public PessoaFisica setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public Set<PessoaFisica> getFilhos() {
        return Collections.unmodifiableSet(filhos);
    }


    @Override
    public String toString() {
        return "{ " +
                "id=" + id +
                ",  nome='" + nome + '\'' +
                ",  nascimento=" + nascimento + '\'' +
                ",  CPF='" + CPF + '\'' +
                ",  sexo=" + sexo +
                ",  filhos=" + filhos +
                " } ";
    }
}