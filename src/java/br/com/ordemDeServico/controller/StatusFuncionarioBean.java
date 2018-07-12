
package br.com.ordemDeServico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.ordemDeServico.model.StatusFuncionario;
import br.com.ordemDeServico.model.StatusFuncionarioDAO;

@ManagedBean
@SessionScoped
public class StatusFuncionarioBean implements Serializable{
    
    private StatusFuncionario statusFun = new StatusFuncionario();
    private StatusFuncionarioDAO statusFunDAO = new StatusFuncionarioDAO();
    private List<StatusFuncionario> listaStatus = new ArrayList<StatusFuncionario>();
    
    
    
    public StatusFuncionarioBean(){
        
    }

    public StatusFuncionario getStatusFun() {
        return statusFun;
    }

    public void setStatusFun(StatusFuncionario statusFun) {
        this.statusFun = statusFun;
    }

    public StatusFuncionarioDAO getStatusFunDAO() {
        return statusFunDAO;
    }

    public void setStatusFunDAO(StatusFuncionarioDAO statusFunDAO) {
        this.statusFunDAO = statusFunDAO;
    }

    public List<StatusFuncionario> getListaStatus() {
        return listaStatus;
    }

    public void setListaStatus(List<StatusFuncionario> listaStatus) {
        this.listaStatus = listaStatus;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.statusFun);
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
        final StatusFuncionarioBean other = (StatusFuncionarioBean) obj;
        if (!Objects.equals(this.statusFun, other.statusFun)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StatusFuncionarioBean{" + "statusFun=" + statusFun + ", statusFunDAO=" + statusFunDAO + ", listaStatus=" + listaStatus + '}';
    }
    
    
    
    
    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public void addStatusFunc(){
        statusFunDAO.salvar(statusFun);
        mensagem("Status Cadastrado com sucesso!", "");
    }
    
    public void atualizaStatusFunc(){
        statusFunDAO.atualizar(statusFun);
        mensagem("Status atualizado com sucesso!", "");
    }
    
    public void removeStatusFunc(){
        statusFunDAO.remover(statusFun);
        mensagem("Removido com sucesso!", "");
    }
    
    public List listarTodosStatus(){
        return listaStatus = statusFunDAO.getListStatus();
    }
    
}
