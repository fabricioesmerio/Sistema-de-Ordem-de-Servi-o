package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FuncionarioDAO extends GenericDAO<Funcionario> implements Serializable {

    private Session sessao;
    private Transaction trans;
    private List<Funcionario> list;

    

    public List<Funcionario> getListFuncionario() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cri = sessao.createCriteria(Funcionario.class);
            list = cri.list();
            return list;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public Funcionario getById(int codigo) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            Funcionario func = new Funcionario();
            return func = (Funcionario) sessao.get(Funcionario.class, codigo);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
