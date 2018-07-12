package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.CargoFuncionario;
import br.com.ordemDeServico.model.CargoFuncionarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.ordemDeServico.model.Funcionario;
import br.com.ordemDeServico.model.FuncionarioDAO;
import br.com.ordemDeServico.model.StatusFuncionario;
import br.com.ordemDeServico.model.StatusFuncionarioDAO;

@ManagedBean
@SessionScoped
public class FuncionarioBean implements Serializable {

    private Funcionario funcionario = new Funcionario();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private List<Funcionario> listfuncionario = new ArrayList<>();
    private List<CargoFuncionario> listagCargos;
    private List<StatusFuncionario> listagStatus;
    CargoFuncionario cargo;
    StatusFuncionario status;
    private boolean disabled = true;
    private boolean varCargo = false;
    

    public FuncionarioBean() {
        cargo = new CargoFuncionario();
        status = new StatusFuncionario();

    }

    public List<StatusFuncionario> getListagStatus() {
        return listagStatus;
    }

    public void setListagStatus(List<StatusFuncionario> listagStatus) {
        this.listagStatus = listagStatus;
    }

    public List<CargoFuncionario> getListagCargos() {
        return listagCargos;
    }

    public void setListagCargos(List<CargoFuncionario> listagCargos) {
        this.listagCargos = listagCargos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public List<Funcionario> getListfuncionario() {
        return listfuncionario;
    }

    public void setListfuncionario(List<Funcionario> listfuncionario) {
        this.listfuncionario = listfuncionario;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isVarCargo() {
        return varCargo;
    }

    public void setVarCargo(boolean varCargo) {
        this.varCargo = varCargo;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.funcionario);
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
        final FuncionarioBean other = (FuncionarioBean) obj;
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }

    @PostConstruct
    public void init() {
        CargoFuncionarioDAO cargoDAO = new CargoFuncionarioDAO();
        listagCargos = cargoDAO.getListagCargos();
        StatusFuncionarioDAO statusDAO = new StatusFuncionarioDAO();
        listagStatus = statusDAO.getListStatus();
    }

    public void addFuncionario() {

        funcionarioDAO.salvar(funcionario);
        mensagem("Sucesso! Funcionário " + funcionario.getNome() + " cadastrado com êxito.", "");
        funcionario = new Funcionario();
    }

    public void atualizaFuncionario() {
        funcionarioDAO.atualizar(funcionario);
        mensagem("Funcionário " + funcionario.getNome() + " atualizado com sucesso!", "");
        funcionario = new Funcionario();
    }

    public List listaSelectCargos() {

        return listagCargos;
    }

    public List listarFuncionario() {
        return listfuncionario = funcionarioDAO.getListFuncionario();
    }

    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public String carregaFuncionario(int id) {
        this.funcionario = funcionarioDAO.getById(id);
        return "editaFuncionario";
    }

    public void setaCargo(){
        if (varCargo == false){
            varCargo = true;
        }
    }
    public boolean alteraBtn() {
        
        if (varCargo == true) {
            disabled = false;
        }

        return disabled;
        
    }
}
