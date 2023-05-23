package br.com.fiap.pessoa.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(
        name = "TB_PESSOA_JURIDICA",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_CNPJ", columnNames = "CNPJ")
        }
)
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {
    @Column(name = "CNPJ")
    private String CNPJ;

    @ManyToMany
    @JoinTable(
            name = "TB_PESSOA_JURIDICA_SOCIOS",
            joinColumns = @JoinColumn(name = "pessoa_juridica_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoa_id")
    )
    private Set<Pessoa> socios = new LinkedHashSet<>();

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Set<Pessoa> getSocios() {
        return Collections.unmodifiableSet(socios);
    }

    public void addSocio(Pessoa pessoa) {
        if (Objects.nonNull(pessoa)) {
            if (pessoa.equals(this)) throw new RuntimeException("Eu não posso ser o meu próprio sócio");
            this.socios.add(pessoa);
        }
    }

    public void removerSocio(Pessoa pessoa) {
        this.socios.remove(pessoa);
    }

    @Override
    public String toString() {
        return "{ " +
                "id=" + id +
                ",  nome='" + nome + '\'' +
                ",  nascimento=" + nascimento + '\'' +
                ",  CNPJ='" + CNPJ + '\'' +
                ",  socios=" + socios +
                " } ";
    }
}
