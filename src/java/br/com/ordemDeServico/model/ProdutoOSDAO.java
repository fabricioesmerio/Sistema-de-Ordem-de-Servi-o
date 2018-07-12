
package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class ProdutoOSDAO implements Serializable{
    private Session sessao;
    private Transaction trans;
    private List<ProdutoOS> list;

    public void addProdutoOS(ProdutoOS pOS) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.save(pOS);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally {
            sessao.close();
        }
    }

    public void removeProdutoOS(ProdutoOS pOS) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.delete(pOS);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally {
            sessao.close();
        }
    }

    public void refreshProdutoOS(ProdutoOS pOS) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.update(pOS);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally {
            sessao.close();
        }
    }

    public List<ProdutoOS> getListProdutoOS(ProdutoOS pOS) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(ProdutoOS.class);
        list = cri.list();
        return list;
    }
    
    public List<ProdutoOS> getProdutosByOS(int id){
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cri = sessao.createCriteria(ProdutoOS.class);
            cri.createCriteria("os").add(Restrictions.idEq(id));
            list = cri.list();
            return list;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
}
