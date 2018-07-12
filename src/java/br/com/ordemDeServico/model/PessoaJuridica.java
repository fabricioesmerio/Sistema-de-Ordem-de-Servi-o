
package br.com.ordemDeServico.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public class PessoaJuridica implements Serializable{
    
    private String nomeFantasia;
    @NotEmpty(message = "O campo Razão Social é obrigatório!")
    private String razaoSocial;
    @NotEmpty(message = "O campo CNPJ é obrigatório!")
    private String cnpj;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
        
}
