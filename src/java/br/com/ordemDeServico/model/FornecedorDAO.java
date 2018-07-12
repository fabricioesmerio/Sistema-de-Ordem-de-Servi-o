package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FornecedorDAO extends GenericDAO<Fornecedor> implements Serializable {

    private Session sessao;
    private Transaction trans;
    private List<Fornecedor> list;

    
    public List<Fornecedor> getListFornecedor() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            Criteria cri = sessao.createCriteria(Fornecedor.class);
            list = cri.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return list;
    }
    
    public Fornecedor getById(int id){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            Fornecedor forn = new Fornecedor();
            return forn = (Fornecedor) sessao.get(Fornecedor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return null;
    }
}
