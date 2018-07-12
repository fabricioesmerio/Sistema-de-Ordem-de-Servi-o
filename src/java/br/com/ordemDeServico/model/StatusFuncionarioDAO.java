
package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StatusFuncionarioDAO extends GenericDAO<StatusFuncionario> implements Serializable{
    private Session sessao;
    private Transaction trans;
    private List<StatusFuncionario> list;
    private StatusFuncionario status = new StatusFuncionario();

    

    public List<StatusFuncionario> getListStatus() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            Criteria cri = sessao.createCriteria(StatusFuncionario.class);
            list = cri.list();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
            return list;
    }
    
    public StatusFuncionario getByID(int id){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            StatusFuncionario status = new StatusFuncionario();
            return status = (StatusFuncionario) sessao.get(StatusFuncionario.class, id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
}
