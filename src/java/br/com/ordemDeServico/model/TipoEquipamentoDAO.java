
package br.com.ordemDeServico.model;

import br.com.ordemDeServico.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TipoEquipamentoDAO extends GenericDAO<TipoEquipamento> implements Serializable{
    private Session sessao;
    private Transaction trans;
    private List<TipoEquipamento> list;

    

    public List<TipoEquipamento> getListTipoEqp(TipoEquipamento tpEqp) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try{
        Criteria cri = sessao.createCriteria(TipoEquipamento.class);
        list = cri.list();
        return list;
        }catch(RuntimeException e){
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
    
    public TipoEquipamento getById(int id){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            TipoEquipamento tipo = new TipoEquipamento();
            return tipo = (TipoEquipamento) sessao.get(TipoEquipamento.class, id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
}
