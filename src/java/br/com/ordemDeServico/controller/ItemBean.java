
package br.com.ordemDeServico.controller;

import javax.faces.bean.ManagedBean;
import javax.persistence.MappedSuperclass;

@ManagedBean(name = "itemBean")
@MappedSuperclass
public abstract class ItemBean {
    
    public void salvar(){
        
    }
    
    public void atualizar(){
        
    }
    
    public void remover(){
        
    }
    
}
