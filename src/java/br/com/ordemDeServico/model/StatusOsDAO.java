package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StatusOsDAO implements Serializable {

    private Session sessao;
    private Transaction trans;
    private List<StatusOs> list;

    public void addStatus(StatusOs status) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.save(status);
            trans.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            sessao.close();
        }
    }

    public void removeStatus(StatusOs status) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.delete(status);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally {
            sessao.close();
        }
    }

    public void refreshStatus(StatusOs status) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.update(status);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally {
            sessao.close();
        }
    }

    public List<StatusOs> getListStatus() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cri = sessao.createCriteria(StatusOs.class);
            list = cri.list();
            return list;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }

    public Object getByID(Integer id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            StatusOs status = new StatusOs();
            return status = (StatusOs) sessao.get(StatusOs.class, id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
