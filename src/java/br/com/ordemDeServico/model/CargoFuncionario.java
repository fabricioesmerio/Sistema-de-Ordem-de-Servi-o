
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
@Table(name = "cargo_funcionario")
public class CargoFuncionario implements Serializable{
    
       
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @NotEmpty(message = "Este campo não deve ficar em braco!")
    private String cargo;
    
    @OneToMany(mappedBy = "cargoFunc", cascade = CascadeType.ALL)
    private List<Funcionario> funcionario = new ArrayList<>();

    /*--------------------       GET and SET        ----------------------------*/
    
    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    /*--------------------       HASH and EQUALS and TOSTRING        ----------------------------*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final CargoFuncionario other = (CargoFuncionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CargoFuncionario{" + "id=" + id + ", cargo=" + cargo + ", funcionario=" + funcionario + '}';
    }

      
    
}
