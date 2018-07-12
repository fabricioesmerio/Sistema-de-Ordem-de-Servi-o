package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDAO<Entity> {

    public void salvar(Entity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.save(entity);
            trans.commit();
        } catch (RuntimeException e) {
            if (trans != null) {
                trans.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void atualizar(Entity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(entity);
            trans.commit();
        } catch (RuntimeException e) {
            if (trans != null) {
                trans.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void remover(Entity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.delete(entity);
            trans.commit();
        } catch (RuntimeException e) {
            if (trans != null) {
                trans.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

}
