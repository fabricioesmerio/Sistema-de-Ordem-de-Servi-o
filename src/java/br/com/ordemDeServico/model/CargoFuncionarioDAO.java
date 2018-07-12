package br.com.ordemDeServico.model;

import java.io.Serializable;
import br.com.ordemDeServico.Util.HibernateUtil;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CargoFuncionarioDAO extends GenericDAO<CargoFuncionario> implements Serializable {

    private Session sessao;
    private Transaction trans;
    private List<CargoFuncionario> listCargo;
    private CargoFuncionario cargoFunc = new CargoFuncionario();

    

    public List<CargoFuncionario> getListagCargos() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            Criteria cri = sessao.createCriteria(CargoFuncionario.class);
            listCargo = cri.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return listCargo;
    }

    public CargoFuncionario getByID(int id) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            CargoFuncionario cargo = new CargoFuncionario();
            return cargo = (CargoFuncionario) sessao.get(CargoFuncionario.class, id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally{
            sessao.close();
        }
        return null;
    }
}
