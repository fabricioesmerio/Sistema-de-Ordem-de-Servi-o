
package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.Cliente;
import br.com.ordemDeServico.model.ClienteDAO;
import br.com.ordemDeServico.model.Equipamento;
import br.com.ordemDeServico.model.EquipamentoDAO;
import br.com.ordemDeServico.model.TipoEquipamento;
import br.com.ordemDeServico.model.TipoEquipamentoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EquipamentoBean implements Serializable{
    private Equipamento equip;
    private EquipamentoDAO equipDAO;
    private List<TipoEquipamento> listTipo;
    private List<Equipamento> listEquip = new ArrayList<>();
    private TipoEquipamento tipoEqp;
    private ClienteDAO clienteDAO = new ClienteDAO();
    private boolean disabled = true;
    //private Cliente cliente = new Cliente();

    public Equipamento getEquip() {
        return equip;
    }

    public void setEquip(Equipamento equip) {
        this.equip = equip;
    }

    public EquipamentoDAO getEquipDAO() {
        return equipDAO;
    }

    public void setEquipDAO(EquipamentoDAO equipDAO) {
        this.equipDAO = equipDAO;
    }

    public List<TipoEquipamento> getListTipo() {
        return listTipo;
    }

    public void setListTipo(List<TipoEquipamento> listTipo) {
        this.listTipo = listTipo;
    }

    public List<Equipamento> getListEquip() {
        return listEquip;
    }

    public void setListEquip(List<Equipamento> listEquip) {
        this.listEquip = listEquip;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.equip);
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
        final EquipamentoBean other = (EquipamentoBean) obj;
        if (!Objects.equals(this.equip, other.equip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EquipamentoBean{" + "equip=" + equip + ", equipDAO=" + equipDAO + ", listTipo=" + listTipo + '}';
    }
    
    /*************************************************************************/
    
    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public EquipamentoBean(){
        equip = new Equipamento();
        equipDAO = new EquipamentoDAO();
        tipoEqp = new TipoEquipamento();
    }
    
    @PostConstruct
    public void init(){
        TipoEquipamentoDAO tipoEqpDAO = new TipoEquipamentoDAO();
        listTipo = tipoEqpDAO.getListTipoEqp(tipoEqp);
    }
    
    public List selectTipoEqp(){
        return listTipo;
    }
    
    public void addEquipamento(Cliente cliente){
        equip.setCliente(cliente);
        equipDAO.salvar(equip);
        equip = new Equipamento();
        mensagem("Cadastrado com sucesso!", "");
    }
    
    public boolean mostraBtn(){
        if(disabled == true){
            disabled = false;
        }
        return disabled;
    }
       
    public List<Equipamento> listarEquipamento(Cliente cliente){
        return listEquip = equipDAO.getListByCliente(cliente.getId());
    }
    
}
