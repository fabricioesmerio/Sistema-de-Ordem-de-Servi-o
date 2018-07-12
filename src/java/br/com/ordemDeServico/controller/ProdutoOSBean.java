
package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.OrdemServico;
import br.com.ordemDeServico.model.Produto;
import br.com.ordemDeServico.model.ProdutoOS;
import br.com.ordemDeServico.model.ProdutoOSDAO;
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

@ManagedBean (name = "produtoOsBean")
@SessionScoped
public class ProdutoOSBean extends ItemServicoBean implements Serializable{
    private ProdutoOS prodOS;
    private ProdutoOSDAO produtoOSDAO;
    private List<ProdutoOS> listarProdOS = new ArrayList<>();
    
    private OrdemServico os;
    @Column(precision = 7, scale = 2)
    private BigDecimal subTotal;

    public ProdutoOS getProdOS() {
        return prodOS;
    }

    public void setProdOS(ProdutoOS prodOS) {
        this.prodOS = prodOS;
    }

    public ProdutoOSDAO getProdutoOSDAO() {
        return produtoOSDAO;
    }

    public void setProdutoOSDAO(ProdutoOSDAO produtoOSDAO) {
        this.produtoOSDAO = produtoOSDAO;
    }


    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.prodOS);
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
        final ProdutoOSBean other = (ProdutoOSBean) obj;
        if (!Objects.equals(this.prodOS, other.prodOS)) {
            return false;
        }
        return true;
    }
    
    public ProdutoOSBean(){
        prodOS = new ProdutoOS();
        produtoOSDAO = new ProdutoOSDAO();
    }
    
    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public void salvarProdOS(Produto p, OrdemServico o){
        prodOS.setOs(o);
        prodOS.setProduto(p);
        prodOS.setValor(new BigDecimal(p.getPrecoVenda().toString()));
        produtoOSDAO.addProdutoOS(prodOS);
        mensagem("Produto Adicionado na Ordem com Sucesso!", null);
    }
    
    public void removeProdOS(ProdutoOS p){
        produtoOSDAO.removeProdutoOS(p);
        mensagem("Produto removido com sucesso!", null);
    }
    
    public List<ProdutoOS> listarProdutosOS(int id){
        listarProdOS = produtoOSDAO.getProdutosByOS(id);
        calculaSubTotal(listarProdOS);
        return listarProdOS;
    }
    
    public void calculaSubTotal(List<ProdutoOS> l){
        this.setSubTotal(new BigDecimal("0.00"));
        for(ProdutoOS obj : l){
            this.setSubTotal(this.getSubTotal().add(obj.getValor()));
        }
    }
}
