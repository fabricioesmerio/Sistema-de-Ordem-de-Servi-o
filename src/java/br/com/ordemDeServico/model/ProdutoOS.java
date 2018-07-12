
package br.com.ordemDeServico.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto_os")
public class ProdutoOS extends ItemServico implements Serializable{
    
        
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
        
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "os", nullable = true)
    private OrdemServico os;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto", nullable = true)
    private Produto produto;   
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrdemServico getOs() {
        return os;
    }

    public void setOs(OrdemServico os) {
        this.os = os;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final ProdutoOS other = (ProdutoOS) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProdutoOS{" + "id=" + id + ", os=" + os + ", produto=" + produto + '}';
    }

}
