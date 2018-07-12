
package br.com.ordemDeServico.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import org.hibernate.validator.constraints.NotEmpty;


@MappedSuperclass
public class PessoaFisica implements Serializable{
    
    @NotEmpty(message = "O nome não pode ser vazio!")
    private String nome;
    @NotEmpty(message = "O CPF deve ser informado!")
    private String cpf;
    private String rg;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    
}
