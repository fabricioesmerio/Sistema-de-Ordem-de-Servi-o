
package br.com.ordemDeServico.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.MappedSuperclass;

@ManagedBean(name = "servicoBean")
@MappedSuperclass
public abstract class ServicoBean implements Serializable{
    
    
    public void salvar(){
        
    }
    
    public void atualizar(){
        
    }
    
    public void remover(){
        
    }
    
}
