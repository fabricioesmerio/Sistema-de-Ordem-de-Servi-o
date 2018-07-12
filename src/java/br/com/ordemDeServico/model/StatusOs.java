
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
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "status_os")
public class StatusOs implements Serializable{
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @NotEmpty(message = "Preencha o campo status!")
    private String status;
    
    @OneToMany(mappedBy = "statusOs", cascade = CascadeType.ALL)
    private List<OrdemServico> os = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrdemServico> getOs() {
        return os;
    }

    public void setOs(List<OrdemServico> os) {
        this.os = os;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final StatusOs other = (StatusOs) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StatusOs{" + "id=" + id + ", status=" + status + ", os=" + os + '}';
    }

    
}
