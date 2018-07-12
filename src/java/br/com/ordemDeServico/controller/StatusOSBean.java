package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.StatusOs;
import br.com.ordemDeServico.model.StatusOsDAO;
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
public class StatusOSBean implements Serializable {

    private StatusOs statusOS;
    private StatusOsDAO statusOSDAO;
    private List<StatusOs> listagStatus = new ArrayList<>();

    public StatusOs getStatusOS() {
        return statusOS;
    }

    public void setStatusOS(StatusOs statusOS) {
        this.statusOS = statusOS;
    }

    public StatusOsDAO getStatusOSDAO() {
        return statusOSDAO;
    }

    public void setStatusOSDAO(StatusOsDAO statusOSDAO) {
        this.statusOSDAO = statusOSDAO;
    }

    public List<StatusOs> getListagStatus() {
        return listagStatus;
    }

    public void setListagStatus(List<StatusOs> listagStatus) {
        this.listagStatus = listagStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.statusOS);
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
        final StatusOSBean other = (StatusOSBean) obj;
        if (!Objects.equals(this.statusOS, other.statusOS)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StatusOSBean{" + "statusOS=" + statusOS + ", statusOSDAO=" + statusOSDAO + ", listagStatus=" + listagStatus + '}';
    }

    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public StatusOSBean() {

    }

    @PostConstruct
    public void init() {
        statusOS = new StatusOs();
        statusOSDAO = new StatusOsDAO();
    }

    public void addStatusOS() {
        statusOSDAO.addStatus(statusOS);
        statusOS = new StatusOs();
        mensagem("Adicionado com sucesso!", "");
    }

    public List listarAllStatusOS() {
        return listagStatus = statusOSDAO.getListStatus();
    }

    public void removeStatusOS(StatusOs status) {
        statusOSDAO.removeStatus(status);
        mensagem("Removido com sucesso!", "");
    }

}
