
package br.com.ordemDeServico.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class TipoServico implements Serializable{
    @NotEmpty(message = "Campo obrigatório!")
    private String servico;
    @NotNull(message = "Campo valor obrigatório!")
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal valor;

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    
}
