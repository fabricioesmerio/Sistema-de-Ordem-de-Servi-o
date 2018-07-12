package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.OrdemServico;
import br.com.ordemDeServico.model.ServOS;
import br.com.ordemDeServico.model.ServOSDAO;
import br.com.ordemDeServico.model.ServOfertado;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;

@ManagedBean(name = "servOSBean")
@SessionScoped
public class ServOSBean implements Serializable {

    private ServOS svOS;
    private ServOSDAO svOSDAO;
    @Column(precision = 7, scale = 2)
    private BigDecimal subTotal;

    
    private OrdemServico os;
    private List<ServOS> listarSvOS = new ArrayList<>();

    /*              GET and SET      */
    public ServOS getSvOS() {
        return svOS;
    }

    public void setSvOS(ServOS svOS) {
        this.svOS = svOS;
    }

    public ServOSDAO getSvOSDAO() {
        return svOSDAO;
    }

    public void setSvOSDAO(ServOSDAO svOSDAO) {
        this.svOSDAO = svOSDAO;
    }

    

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public OrdemServico getOs() {
        return os;
    }

    public void setOs(OrdemServico os) {
        this.os = os;
    }
    
    

    /*          FIM  GET and SET      */
 /*          HASH and EQUALS      */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.svOS);
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
        final ServOSBean other = (ServOSBean) obj;
        if (!Objects.equals(this.svOS, other.svOS)) {
            return false;
        }
        return true;
    }

    /*        FIM HASH and EQUALS      */

    public ServOSBean() {
        svOS = new ServOS();
        svOSDAO = new ServOSDAO();
    }

    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void salvaSvOS(ServOfertado sv, OrdemServico o) {
        //String valor = sv.getValor().toString();
        svOS.setOs(o);
        svOS.setServico(sv);
        svOS.setValor(new BigDecimal(sv.getValor().toString()));
        //this.os.setValorTemp(this.os.getValorTemp().add(svOS.getValor()));
        svOSDAO.addServOS(svOS);
        mensagem("Adicionado com Sucesso!", null);
    }

    public void removeSvOS(ServOS sv) {
        svOSDAO.removeServOS(sv);
        mensagem("Removido com Sucesso!", null);
    }

    public List<ServOS> listarServicosOS(int id) {
        listarSvOS = svOSDAO.getServicosByOS(id);
        calculaValores(listarSvOS);
        //os.calculaTotal(listarSvOS, null);
        return listarSvOS;
    }

    public void calculaValores(List<ServOS> list) {
        this.setSubTotal(new BigDecimal("0.00"));
                
        for (ServOS obj : list) {
            this.setSubTotal(this.getSubTotal().add(obj.getValor()));
        }
    }
}
