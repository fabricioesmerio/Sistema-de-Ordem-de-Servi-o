
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
@Table(name = "os")
public class OrdemServico extends Servico implements Serializable{
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String defeito;
    private String obs;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente", nullable = true)
    private Cliente clientes;    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipamento", nullable = true)
    private Equipamento equipamento;    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "funcionario", nullable = true)
    private Funcionario funcionario;    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_os", nullable = true)
    private StatusOs statusOs;     
    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL)
    private List<ServOS> servico = new ArrayList<>();
    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL)
    private List<ProdutoOS> produto = new ArrayList<>();
    
    
    /* --------- GET's and SET's ----------*/

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public StatusOs getStatusOs() {
        return statusOs;
    }

    public void setStatusOs(StatusOs statusOs) {
        this.statusOs = statusOs;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }
    
    public List<ServOS> getServico() {
        return servico;
    }

    public void setServico(List<ServOS> servico) {
        this.servico = servico;
    }

    public List<ProdutoOS> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoOS> produto) {
        this.produto = produto;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final OrdemServico other = (OrdemServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "id=" + id + ", defeito=" + defeito + ", clientes=" + clientes + ", equipamento=" + equipamento + ", funcionario=" + funcionario + ", statusOs=" + statusOs + ", servico=" + servico + ", produto=" + produto + '}';
    }

        
    public void OrdemServico(){
        this.clientes = null;
    }
    
}
