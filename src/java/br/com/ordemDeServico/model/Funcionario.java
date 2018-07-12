package br.com.ordemDeServico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends PessoaFisica implements Serializable {
    
    

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String ctps;
    private String celular;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo",nullable = true)
    private CargoFuncionario cargoFunc;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status")
    private StatusFuncionario status;
    
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<OrdemServico> os = new ArrayList<>();
    
    
    /*-----------------    GET and SET       -----------------------*/

    public StatusFuncionario getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionario status) {
        this.status = status;
    }
    
    public CargoFuncionario getCargoFunc() {
        return cargoFunc;
    }

    public void setCargoFunc(CargoFuncionario cargoFunc) {
        this.cargoFunc = cargoFunc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<OrdemServico> getOs() {
        return os;
    }

    public void setOs(List<OrdemServico> os) {
        this.os = os;
    }

    

    /*--------------------   HASH and EQUALS and TOSTRING     ---------------------*/


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", ctps=" + ctps + ", celular=" + celular + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cargoFunc=" + cargoFunc + ", status=" + status + ", os=" + os + '}';
    }

    
}
