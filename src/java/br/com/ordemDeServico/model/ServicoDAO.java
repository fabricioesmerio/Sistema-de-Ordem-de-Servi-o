
package br.com.ordemDeServico.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ServicoDAO implements Serializable{
    
    
    public ServicoDAO(){
        
    }
    
    /**
     * Método responsável por salvar.
     */
    public void save(){
        
    }
    
    /**
     * Método responsável por excluir.
     */
    public void delete(){
        
    }
    
    /**
     * Método responsável por atualizar.
     */
    public void update(){
        
    }
    
}
