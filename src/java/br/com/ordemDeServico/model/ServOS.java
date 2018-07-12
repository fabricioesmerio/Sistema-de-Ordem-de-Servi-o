package br.com.ordemDeServico.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servico_os")
public class ServOS implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    
    
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal valor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "os", nullable = true)
    private OrdemServico os;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico", nullable = true)
    private ServOfertado servico;
    

    /*
        GET AND SET
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public OrdemServico getOs() {
        return os;
    }

    public void setOs(OrdemServico os) {
        this.os = os;
    }

    public ServOfertado getServico() {
        return servico;
    }

    public void setServico(ServOfertado servico) {
        this.servico = servico;
    }

    
    
    /*
        FIM GET AND SET
     */
 /*
        HASH AND EQUALS
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServOS other = (ServOS) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /*
        FIM HASH AND EQUALS
     */
    @Override
    public String toString() {
        return "ServOS{" + "id=" + id + ", valor=" + valor + '}';
    }

}
