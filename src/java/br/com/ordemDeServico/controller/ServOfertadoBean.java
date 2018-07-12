
package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.ServOfertado;
import br.com.ordemDeServico.model.ServOfertadoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ServOfertadoBean extends TipoServicoBean implements Serializable{
    
    private ServOfertado servOfer;
    private ServOfertadoDAO servOferDAO;
    private List<ServOfertado> listagServOfertado = new ArrayList<>();

    public ServOfertado getServOfer() {
        return servOfer;
    }

    public void setServOfer(ServOfertado servOfer) {
        this.servOfer = servOfer;
    }

    public ServOfertadoDAO getServOferDAO() {
        return servOferDAO;
    }

    public void setServOferDAO(ServOfertadoDAO servOferDAO) {
        this.servOferDAO = servOferDAO;
    }

    public List<ServOfertado> getListagServOfertado() {
        return listagServOfertado;
    }

    public void setListagServOfertado(List<ServOfertado> listagServOfertado) {
        this.listagServOfertado = listagServOfertado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.servOfer);
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
        final ServOfertadoBean other = (ServOfertadoBean) obj;
        if (!Objects.equals(this.servOfer, other.servOfer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServOfertadoBean{" + "servOfer=" + servOfer + ", servOferDAO=" + servOferDAO + ", listagServOfertado=" + listagServOfertado + '}';
    }
    
    /*    MÉTODOS    */
    
    public ServOfertadoBean(){
        servOfer = new ServOfertado();
        servOferDAO = new ServOfertadoDAO();
    }
    
     public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
     
    @Override
     public void salvar() {
        servOferDAO.addServicoOS(servOfer);
        mensagem("Serviço Salvo com sucesso!", "");
        servOfer = new ServOfertado();
    }
     
     public List listagemServOfertado(){
         return listagServOfertado = servOferDAO.getListServicoOS();
     }
     
    @Override
     public void remover(){
         servOferDAO.removeServicoOS(servOfer);
         mensagem("Removido com sucesso!!", "");
     }
     
    @Override
     public void atualizar(){
         servOferDAO.refreshServicoOS(servOfer);
         mensagem("Atualizado com sucesso!!", "");
     }
}
