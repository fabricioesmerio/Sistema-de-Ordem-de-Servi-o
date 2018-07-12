package br.com.ordemDeServico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.ordemDeServico.model.Cliente;
import br.com.ordemDeServico.model.ClienteDAO;
import javax.annotation.PostConstruct;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente = new Cliente();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private List<Cliente> listaCliente = new ArrayList<>();

    @Override
    public String toString() {
        return "ClienteBean{" + "cliente=" + cliente + ", clienteDAO=" + clienteDAO + ", listaCliente=" + listaCliente + '}';
    }

    public ClienteBean() {

    }

    @PostConstruct
    public void init() {
        listaCliente = clienteDAO.getListCliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cliente);
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
        final ClienteBean other = (ClienteBean) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    /**
     * ******************************************
     */
    public void atualizaCliente() {
        clienteDAO.atualizar(cliente);
        mensagem("Cliente " + cliente.getNome() + " atualizado com sucesso!", "");
        cliente = null;
    }

    public void addCliente() {
        clienteDAO.salvar(cliente);
        mensagem("Sucesso, cliente " + cliente.getNome() + " inseridos com sucesso!", "");
        cliente = null;
        //o objeto cliente recebeu null para evitar que o formulário continue 
        //com os dados preenchidos após salvar o cliente.
    }

    public void removeCliente(Cliente cliente) {
        clienteDAO.remover(cliente);
        mensagem("Excluído com sucesso", "");
    }

    public List listarClientes() {
        return listaCliente = clienteDAO.getListCliente();
    }

    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public String carregaCliente(int id) {
        this.cliente = clienteDAO.getById(id);
        return "cadEquipamento";
    }

    public String carregaClienteEditar(int id) {
        this.cliente = clienteDAO.getById(id);
        return "editaCliente";
    }

}
