package br.com.ordemDeServico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import br.com.ordemDeServico.model.TipoEquipamento;
import br.com.ordemDeServico.model.TipoEquipamentoDAO;

@ManagedBean
@SessionScoped
public class TipoEquipamentoBean implements Serializable {

    private TipoEquipamento tipoEqp = new TipoEquipamento();
    private TipoEquipamentoDAO tipoDAO = new TipoEquipamentoDAO();
    private List<TipoEquipamento> list = new ArrayList<>();

    public TipoEquipamentoBean() {
    }

    public TipoEquipamento getTipoEqp() {
        return tipoEqp;
    }

    public void setTipoEqp(TipoEquipamento tipoEqp) {
        this.tipoEqp = tipoEqp;
    }

    public TipoEquipamentoDAO getTipoDAO() {
        return tipoDAO;
    }

    public void setTipoDAO(TipoEquipamentoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public List<TipoEquipamento> getList() {
        return list;
    }

    public void setList(List<TipoEquipamento> list) {
        this.list = list;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.tipoEqp);
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
        final TipoEquipamentoBean other = (TipoEquipamentoBean) obj;
        if (!Objects.equals(this.tipoEqp, other.tipoEqp)) {
            return false;
        }
        return true;
    }

    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void addTipo() {
        tipoDAO.salvar(tipoEqp);
        tipoEqp.setTipo("");
        mensagem("Sucesso, dados inseridos", "");        
    }

    public void atualizaTipo() {
        tipoDAO.atualizar(tipoEqp);
        mensagem("Sucesso, dados atualizado", "");
    }

    public void removeTipo() {
        tipoDAO.remover(tipoEqp);
        mensagem("Sucesso, dados removidos", "");
    }
    
    public List listarTipoEqp(){
        return list = tipoDAO.getListTipoEqp(tipoEqp);
    }
}
