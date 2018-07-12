
package br.com.ordemDeServico.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class TipoItem implements Serializable{
    @NotEmpty(message = "Este campo não deve ficar em branco!")
    private String descricao;

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
