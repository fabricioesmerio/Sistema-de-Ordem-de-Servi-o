package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ClienteDAO extends  GenericDAO<Cliente> implements Serializable {

    private Session sessao;
    private Transaction trans;
    private List<Cliente> list;

    
    public List<Cliente> getListCliente() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            Criteria cri = sessao.createCriteria(Cliente.class);
            list = cri.list();
            return list;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public Cliente getById(int id) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Cliente cli = new Cliente();
            return cli = (Cliente) sessao.get(Cliente.class, id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Cliente> getByNome(String nome) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = sessao.createCriteria(Cliente.class);
            criteria.addOrder(Order.asc("nome"));
            criteria.add(Restrictions.like("nome","%" + nome + "%"));
            return criteria.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
    
    public Cliente getIdByNome(String nome){
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Cliente cli = new Cliente();
            return cli = (Cliente) sessao.get(Cliente.class, nome);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }

}
