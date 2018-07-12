
package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CategoriaDAO extends GenericDAO<Categoria> implements Serializable{
    private Session sessao;
    private Transaction trans;
    private List<Categoria> list;

    

    public List<Categoria> getListCategoria() {
        try{
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Categoria.class);
        list = cri.list();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return list;
    }
    
    public Categoria getById(int id){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            Categoria categoria = new Categoria();
            return categoria = (Categoria) sessao.get(Categoria.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
}
