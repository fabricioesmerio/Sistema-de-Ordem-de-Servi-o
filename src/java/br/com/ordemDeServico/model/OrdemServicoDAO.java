package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

public class OrdemServicoDAO extends GenericDAO<OrdemServico> implements Serializable {

    private Session sessao;
    private Transaction trans;
    private List<OrdemServico> list;

    
    /*public void save(OrdemServico os) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.save(os);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally {
            sessao.close();
        }
    }

    public void removeOS(OrdemServico os) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.delete(os);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally {
            sessao.close();
        }
    }

    public void refreshOS(OrdemServico os) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.update(os);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally {
            sessao.close();
        }
    }*/

    public List<OrdemServico> getListOS() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cri = sessao.createCriteria(OrdemServico.class).addOrder(Order.desc("id"));
            list = cri.list();
            return list;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public OrdemServico getByID(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            OrdemServico os = new OrdemServico();
            return os = (OrdemServico) sessao.get(OrdemServico.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
}
