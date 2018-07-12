package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class EquipamentoDAO extends GenericDAO<Equipamento> implements Serializable {

    private Session sessao;
    private Transaction trans;
    private List<Equipamento> list;


    public List<Equipamento> getListEquipamento() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Equipamento.class);
        list = cri.list();
        return list;
    }
    
    public List<Equipamento> getListByCliente(Integer id){
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cri = sessao.createCriteria(Equipamento.class);
            //cri.createAlias("cliente", "e").add(Restrictions.like("e.cliente", id));
            cri.createCriteria("cliente").add(Restrictions.idEq(id));
            list = cri.list();
            return list;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    } 
    
    /*
    public List<Equipamento> getListByCliente(int cliente) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            SQLQuery sql = sessao.createSQLQuery("SELECT * FROM equipamento WHERE cliente = "+ cliente);
            return sql.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }*/

    public Equipamento getByID(Integer cod) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Equipamento eqp = new Equipamento();
            return eqp = (Equipamento) sessao.get(Equipamento.class, cod);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return null;
    }
}
