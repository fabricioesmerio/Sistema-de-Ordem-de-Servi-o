package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ServOSDAO implements Serializable {

    private Session sessao;
    private Transaction trans;
    private List<ServOS> list;

    public void addServOS(ServOS sv) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.save(sv);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally{
            sessao.close();
        }
    }
    
    public void removeServOS (ServOS sv){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.delete(sv);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally{
            sessao.close();
        }
    }
    
    public void refreshServOS(ServOS sv){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.update(sv);
            trans.commit();
        } catch (PersistenceException e) {
            trans.rollback();
        } finally{
            sessao.close();
        }
    }
    
    public List<ServOS> getListServOS (ServOS sv){
        sessao = HibernateUtil.getSessionFactory().openSession();
        try{
        Criteria cri = sessao.createCriteria(ServOS.class);
        list = cri.list();
        return list;            
        } catch(RuntimeException e){
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
    
    public List<ServOS> getServicosByOS(int id){
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cri = sessao.createCriteria(ServOS.class);
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
