package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.Fornecedor;
import br.com.ordemDeServico.model.FornecedorDAO;
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
public class FornecedorBean implements Serializable {

    Fornecedor fornecedor;
    FornecedorDAO fornecedorDAO;
    private List<Fornecedor> listagFornecedor = new ArrayList<>();

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public FornecedorDAO getFornecedorDAO() {
        return fornecedorDAO;
    }

    public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
        this.fornecedorDAO = fornecedorDAO;
    }

    public List<Fornecedor> getListagFornecedor() {
        return listagFornecedor;
    }

    public void setListagFornecedor(List<Fornecedor> listagFornecedor) {
        this.listagFornecedor = listagFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.fornecedor);
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
        final FornecedorBean other = (FornecedorBean) obj;
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FornecedorBean{" + "fornecedor=" + fornecedor + ", fornecedorDAO=" + fornecedorDAO + ", listagFornecedor=" + listagFornecedor + '}';
    }

    /**
     * ************** MÉTODOS  ******************
     */
    public FornecedorBean() {
        fornecedor = new Fornecedor();
        fornecedorDAO = new FornecedorDAO();
    }

    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void addFornecedor() {
        fornecedorDAO.salvar(fornecedor);
        mensagem("Fornecedor "+fornecedor.getNomeFantasia()+" salvo com sucesso!", "");
        fornecedor = new Fornecedor();
    }
    
    public void atualizaFornecedor() {
        fornecedorDAO.atualizar(fornecedor);
        mensagem("Fornecedor atualizado com sucesso!", "");
    }
    
    public void removeFornecedor() {
        fornecedorDAO.remover(fornecedor);
        mensagem("Fornecedor removido com sucesso!", "");
    }
    
    public List listarFornecedor(){
        return listagFornecedor = fornecedorDAO.getListFornecedor();
    }
}
