package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.OrdemServico;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ControllerPagina implements Serializable {
    
    private OrdemServico os;
    

    public String chamaIndex() {
        return "index";
    }
    
    /**           TELA DE CADASTROS           **/
    
    public String chamaCadCliente() {
        return "cadCliente";
    }

    public String chamaCadTipoEqp() {
        return "cadTipoEquipamento";
    }
    
    public String chamaCadCargo(){
        return "cadCargo";
    }
    
    public String chamaCadFuncionario(){
        return "cadFuncionario";
    }

    public String chamaCadFornecedor(){
        return "cadFornecedor";
    }
    
    public String chamaCadProduto(){
        return "cadProduto";
    }
    
    public String chamaCadStatusFunc(){
        return "cadStatusFunc";
    }
    
    public String chamaCadCatProduto(){
        return "cadCategoria";
    }
    
    public String chamaCadEquipamento(){
        return "cadEquipamento";
    }
    
    /**
     * Método responsável por chamar a tela de cadastro
     * dos serviços ofertados pela empresa
     * 
     * @cadServicoOfer 
     */
    public String chamaCadServicoOfer(){
        return "cadServicoOfer";
    }
    
    public String chamaCadOS(){
        os = new OrdemServico();
        return "cadOS";
    }
    
    public String chamaCadStatusOS(){
        return "cadStatusOS";
    }
    
    
    /**         FIM TELA DE CADASTROS          **/
    
    
    /**         LISTAGENS         **/
    
    public String chamaListaCliente(){
        return "listagemCliente";
    }
    
    public String chamaListaFornecedor(){
        return "listagemFornecedor";
    }
    
    public String chamaListaFuncionario(){
        return "listagemFuncionario";
    }
    
    /**          FIM LISTAGENS         **/
    
    public String chamaPesquisaOS(){
        return "pesquisaOS";
    }
}
