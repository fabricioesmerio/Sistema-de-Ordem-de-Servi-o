
package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.Categoria;
import br.com.ordemDeServico.model.CategoriaDAO;
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
public class CategoriaBean extends TipoItemBean implements Serializable{
    
    private Categoria categoria;
    private CategoriaDAO categoriaDAO;
    private List<Categoria> listaCat = new ArrayList<>();
    
    public CategoriaBean(){
        categoria = new Categoria();
        categoriaDAO = new CategoriaDAO();
    }
    
    @PostConstruct
    public void init(){
        categoria = new Categoria();
        categoriaDAO = new CategoriaDAO();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.categoria);
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
        final CategoriaBean other = (CategoriaBean) obj;
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }
    
    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    @Override
    public void salvar(){
        categoriaDAO.salvar(categoria);
        mensagem("Categoria "+categoria.getDescricao()+" salva com Sucesso!!", "");
        categoria = new Categoria();
    }
    
    public List listarCategoria(){
        return listaCat = categoriaDAO.getListCategoria();
    }
    
    @Override
    public void remover(){
        categoriaDAO.remover(categoria);
        mensagem("Removido com sucesso!", "");
    }
    
    public String atualizarCategoria(){
        categoriaDAO.atualizar(categoria);
        mensagem("Atualizado com sucesso! ", "");
        categoria = new Categoria();
        return "cadCategoria";
    }
    
    public String chamaEditar(int id){
        this.categoria = categoriaDAO.getById(id);
        return "editaCategoria";
    }
}
