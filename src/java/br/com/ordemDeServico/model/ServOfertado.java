
package br.com.ordemDeServico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "servico")
public class ServOfertado extends TipoServico implements Serializable{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;    
    
    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<ServOS> svOS = new ArrayList<>();
    

    
    public Integer getId() {
        return id;
    }
    
    
    public void setId(Integer id) {
        this.id = id;
    }

    

    

    

    public List<ServOS> getSvOS() {
        return svOS;
    }

    public void setSvOS(List<ServOS> svOS) {
        this.svOS = svOS;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final ServOfertado other = (ServOfertado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServOfertado{" + "id=" + id + ", svOS=" + svOS + '}';
    }

          
}
