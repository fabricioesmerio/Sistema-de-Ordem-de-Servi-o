
package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.Categoria;
import br.com.ordemDeServico.model.CategoriaDAO;
import br.com.ordemDeServico.model.Fornecedor;
import br.com.ordemDeServico.model.FornecedorDAO;
import br.com.ordemDeServico.model.Produto;
import br.com.ordemDeServico.model.ProdutoDAO;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ProdutoBean extends ItemBean implements Serializable{
    
    private Produto produto;
    private ProdutoDAO produtoDAO;
    private List<Produto> listarProduto;
    private List<Categoria> listagCategoria;
    private List<Fornecedor> listagFornecedor;
    private boolean disabled = true;
    private boolean varCat = false;
    
    
    @PostConstruct
    public void init() {
        CategoriaDAO catDAO = new CategoriaDAO();
        listagCategoria = catDAO.getListCategoria();
        FornecedorDAO fornDAO = new FornecedorDAO();
        listagFornecedor = fornDAO.getListFornecedor();
    }
    
    public ProdutoBean(){
        produto = new Produto();
        produtoDAO = new ProdutoDAO();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public List<Produto> getListarProduto() {
        return listarProduto;
    }

    public void setListarProduto(List<Produto> listarProduto) {
        this.listarProduto = listarProduto;
    }

    public List<Categoria> getListagCategoria() {
        return listagCategoria;
    }

    public void setListagCategoria(List<Categoria> listagCategoria) {
        this.listagCategoria = listagCategoria;
    }

    public List<Fornecedor> getListagFornecedor() {
        return listagFornecedor;
    }

    public void setListagFornecedor(List<Fornecedor> listagFornecedor) {
        this.listagFornecedor = listagFornecedor;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isVarCat() {
        return varCat;
    }

    public void setVarCat(boolean varCat) {
        this.varCat = varCat;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.produto);
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
        final ProdutoBean other = (ProdutoBean) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProdutoBean{" + "produto=" + produto + ", produtoDAO=" + produtoDAO + ", listarProduto=" + listarProduto + '}';
    }
    
    
    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    @Override
    public void salvar(){
        produtoDAO.salvar(produto);
        mensagem("Produto Salvo com Sucesso!!", "");
        produto = new Produto();
    }
    
    @Override
    public void atualizar(){
        produtoDAO.atualizar(produto);
        mensagem("Produto Atualizado com Sucesso!!", "");
    }
    
    @Override
    public void remover(){
        produtoDAO.remover(produto);
        mensagem("Produto Excluído com Sucesso!!", "");
    }
    
    public List listarOsProdutos(){
        return listarProduto = produtoDAO.getListProduto();
    }
    
    public void setaCat(){
        if (!varCat) {
            varCat = true;
        }
    }
    
    public boolean alteraBtn(){
        if (varCat) {
            disabled = false;
        }
        return disabled;
    }
    
}
