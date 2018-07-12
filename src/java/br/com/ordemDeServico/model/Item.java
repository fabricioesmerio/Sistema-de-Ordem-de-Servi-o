
package br.com.ordemDeServico.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Item implements Serializable{
    
    private String descricao;
    @NotNull(message = "O campo preço de custo não pode ficar vazio.")
    @Column(precision = 7, scale = 2)
    private BigDecimal precoCusto;

    @Column(precision = 7, scale = 2)
    private BigDecimal precoVenda;
    
    
    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }
         
    
}
