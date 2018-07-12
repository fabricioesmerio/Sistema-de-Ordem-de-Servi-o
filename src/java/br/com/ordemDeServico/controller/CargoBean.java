
package br.com.ordemDeServico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.ordemDeServico.model.CargoFuncionario;
import br.com.ordemDeServico.model.CargoFuncionarioDAO;

@ManagedBean
@SessionScoped
public class CargoBean implements Serializable{
    private CargoFuncionario cargoFuncionario = new CargoFuncionario();
    private CargoFuncionarioDAO cargoDAO = new CargoFuncionarioDAO();
    private List<CargoFuncionario> listaCargo = new ArrayList<>();
    
    public CargoBean(){
        
    }

    public CargoFuncionario getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(CargoFuncionario cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public CargoFuncionarioDAO getCargoDAO() {
        return cargoDAO;
    }

    public void setCargoDAO(CargoFuncionarioDAO cargoDAO) {
        this.cargoDAO = cargoDAO;
    }

    public List<CargoFuncionario> getListaCargo() {
        return listaCargo;
    }

    public void setListaCargo(List<CargoFuncionario> listaCargo) {
        this.listaCargo = listaCargo;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cargoFuncionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CargoBean other = (CargoBean) obj;
        if (!Objects.equals(this.cargoFuncionario, other.cargoFuncionario)) {
            return false;
        }
        return true;
    }
    
    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public void addCargo(){
        cargoDAO.salvar(cargoFuncionario);
        cargoFuncionario = new CargoFuncionario();
        mensagem("Dados inseridos com sucesso!", "");
    }
    
    public void atualizaCargo(){
        cargoDAO.atualizar(cargoFuncionario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso.", "Feito!"));
        cargoFuncionario = new CargoFuncionario();   
    }
    
    public void removeCargo(CargoFuncionario cargoFuncionario){
        cargoDAO.remover(cargoFuncionario);
        mensagem("Dados removido com seucesso!", "");
    }
 
    public List listarCargo(){
        return listaCargo = cargoDAO.getListagCargos();
    }
    
    public String carregaCargo(int id){
        this.cargoFuncionario = cargoDAO.getByID(id);
        return "editaCargo";
    }
}
