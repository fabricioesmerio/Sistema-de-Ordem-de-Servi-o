package br.com.ordemDeServico.controller;

import br.com.ordemDeServico.model.Cliente;
import br.com.ordemDeServico.model.ClienteDAO;
import br.com.ordemDeServico.model.Equipamento;
import br.com.ordemDeServico.model.EquipamentoDAO;
import br.com.ordemDeServico.model.Funcionario;
import br.com.ordemDeServico.model.FuncionarioDAO;
import br.com.ordemDeServico.model.OrdemServico;
import br.com.ordemDeServico.model.OrdemServicoDAO;
import br.com.ordemDeServico.model.Produto;
import br.com.ordemDeServico.model.ProdutoDAO;
import br.com.ordemDeServico.model.ServOS;
import br.com.ordemDeServico.model.ServOSDAO;
import br.com.ordemDeServico.model.ServOfertado;
import br.com.ordemDeServico.model.ServOfertadoDAO;
import br.com.ordemDeServico.model.StatusOs;
import br.com.ordemDeServico.model.StatusOsDAO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;

@ManagedBean(name = "ordemServicoBean")
@SessionScoped
public class OrdemServicoBean extends ServicoBean implements Serializable {

    private OrdemServico os;
    private OrdemServicoDAO osDAO;
    private List<OrdemServico> listOS = new ArrayList<>();
    private Cliente cliente;
    private ClienteDAO clienteDAO;
    private List<Cliente> listagCliente;
    private List<StatusOs> listStatus = new ArrayList<>();
    private StatusOs status;
    private StatusOsDAO statusOsDAO;
    private Equipamento equip;
    private EquipamentoDAO equipDAO;
    private List<Equipamento> listagEqp = new ArrayList<>();
    private boolean mostrar = false;
    private List<Equipamento> listaTudoEqp = new ArrayList<>();
    private Funcionario funcionario;
    private FuncionarioDAO funcionarioDAO;
    private List<Funcionario> listagFuncionario = new ArrayList<>();
    private ServOfertado svOfer;
    private ServOfertadoDAO svOferDAO;
    private List<ServOfertado> listSvOfer = new ArrayList<>();
    private ServOS svOS = new ServOS();
    private ServOSDAO svOsDAO = new ServOSDAO();
    private List<ServOS> listSvOS = new ArrayList<>();
    private Produto produto;
    private ProdutoDAO produtoDAO;
    private List<Produto> listProdutos = new ArrayList<>();
    @Column(precision = 7, scale = 2)
    private BigDecimal valorTemp = new BigDecimal("0.00");
    private boolean varEqp = false;
    private boolean disabled = true;
    private boolean btnAtualizarOS = true;
    private boolean varFunc = false;

    @ManagedProperty(value = "#{servOSBean}")
    private ServOSBean svOSB;
    @ManagedProperty(value = "#{produtoOsBean}")
    private ProdutoOSBean pOSB;

    public List<Cliente> getListagCliente() {
        return listagCliente;
    }

    public void setListagCliente(List<Cliente> listagCliente) {
        this.listagCliente = listagCliente;
    }

    public OrdemServico getOs() {
        return os;
    }

    public void setOs(OrdemServico os) {
        this.os = os;
    }

    public OrdemServicoDAO getOsDAO() {
        return osDAO;
    }

    public void setOsDAO(OrdemServicoDAO osDAO) {
        this.osDAO = osDAO;
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

    public List<StatusOs> getListStatus() {
        return listStatus;
    }

    public void setListStatus(List<StatusOs> listStatus) {
        this.listStatus = listStatus;
    }

    public StatusOs getStatus() {
        return status;
    }

    public void setStatus(StatusOs status) {
        this.status = status;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public List<Equipamento> getListagEqp() {
        return listagEqp;
    }

    public void setListagEqp(List<Equipamento> listagEqp) {
        this.listagEqp = listagEqp;
    }

    public List<Equipamento> getListaTudoEqp() {
        return listaTudoEqp;
    }

    public void setListaTudoEqp(List<Equipamento> listaTudoEqp) {
        this.listaTudoEqp = listaTudoEqp;
    }

    public List<OrdemServico> getListOS() {
        return listOS;
    }

    public void setListOS(List<OrdemServico> listOS) {
        this.listOS = listOS;
    }

    public List<Funcionario> getListagFuncionario() {
        return listagFuncionario;
    }

    public void setListagFuncionario(List<Funcionario> listagFuncionario) {
        this.listagFuncionario = listagFuncionario;
    }

    public List<ServOfertado> getListSvOfer() {
        return listSvOfer;
    }

    public void setListSvOfer(List<ServOfertado> listSvOfer) {
        this.listSvOfer = listSvOfer;
    }

    public BigDecimal getValorTemp() {
        return valorTemp;
    }

    public void setValorTemp(BigDecimal valorTemp) {
        this.valorTemp = valorTemp;
    }

    public ServOSBean getSvOSB() {
        return svOSB;
    }

    public void setSvOSB(ServOSBean svOSB) {
        this.svOSB = svOSB;
    }

    public ProdutoOSBean getpOSB() {
        return pOSB;
    }

    public void setpOSB(ProdutoOSBean pOSB) {
        this.pOSB = pOSB;
    }

    public boolean isVarEqp() {
        return varEqp;
    }

    public void setVarEqp(boolean varEqp) {
        this.varEqp = varEqp;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isBtnAtualizarOS() {
        return btnAtualizarOS;
    }

    public void setBtnAtualizarOS(boolean btnAtualizarOS) {
        this.btnAtualizarOS = btnAtualizarOS;
    }

    public boolean isVarFunc() {
        return varFunc;
    }

    public void setVarFunc(boolean varFunc) {
        this.varFunc = varFunc;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.os);
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
        final OrdemServicoBean other = (OrdemServicoBean) obj;
        if (!Objects.equals(this.os, other.os)) {
            return false;
        }
        return true;
    }

    public OrdemServicoBean() {
        funcionario = new Funcionario();
        funcionarioDAO = new FuncionarioDAO();
        svOfer = new ServOfertado();
        svOferDAO = new ServOfertadoDAO();
        os = new OrdemServico();
        osDAO = new OrdemServicoDAO();
        produto = new Produto();
        produtoDAO = new ProdutoDAO();
        listSvOS = null;
    }

    @PostConstruct
    public void init() {

        cliente = new Cliente();
        clienteDAO = new ClienteDAO();
        status = new StatusOs();
        statusOsDAO = new StatusOsDAO();
        equip = new Equipamento();
        equipDAO = new EquipamentoDAO();
        listStatus = statusOsDAO.getListStatus();
        listagCliente = clienteDAO.getListCliente();
        listagFuncionario = funcionarioDAO.getListFuncionario();
    }

    public void mensagem(String summary, String detail) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    @Override
    public void salvar() {
        osDAO.salvar(os);
        mensagem("Sucesso ao cadastrar a OS número " + this.os.getId() + " para o cliente " + this.os.getClientes().getNome(), null);
        this.os = new OrdemServico();
        this.os.setClientes(null);
        this.mostrar = false;
    }

    public boolean carrega() {
        if (this.os.getClientes() != null) {
            listagEqp = equipDAO.getListByCliente(this.os.getClientes().getId());
            return mostrar = true;
        }
        return mostrar;
    }

    public List<OrdemServico> listarOS() {
        return listOS = osDAO.getListOS();
    }

    /**
     * Função que carrega a OS corrente e prepara a tela de Edição. Nessa
     * próxima tela serão cadastrados os Funcionário responsável, serviços
     * executados e os produtos (peças) utilizados na Ordem. Após carregado a OS
     * corrente, será redirecionada a tela de Edição de OS.
     *
     * @return tela de edição
     */
    public String preparaOS(int id) {
        this.os = osDAO.getByID(id);
        if (os.getStatusOs().getStatus().equals("Fechada") || os.getStatusOs().getStatus().equals("Cancelada")) {
            mensagem("A ordem não pode mais ser Editada!", "");
            return null;
        }
        return "editaOS";
    }

    public List<ServOfertado> geraDataTableServico() {
        return listSvOfer = svOferDAO.getListServicoOS();
    }

    public List<Produto> geraDataTableProduto() {
        return listProdutos = produtoDAO.getListProduto();
    }

    public void addServicoOS(ServOfertado s) {
        this.svOSB.salvaSvOS(s, this.os);
    }

    public void addProdutoOS(Produto p) {
        this.pOSB.salvarProdOS(p, this.os);
    }

    public List<ServOS> geraTableServ() {

        if (listSvOS == null) {
            listSvOS = svOsDAO.getServicosByOS(this.getOs().getId());
            if (listSvOS != null) {
                for (ServOS obj : listSvOS) {
                    System.out.println("Saída: " + obj.getValor());
                    this.setValorTemp(this.getValorTemp().add(obj.getValor()));
                }
            }
        }
        return listSvOS;
    }

    public String atualizarOS() {
        this.os.setVlrTotalServico(this.pOSB.getSubTotal().add(svOSB.getSubTotal()));
        Date date = new Date();
        if (this.os.getDtAtendimento() == null) {
            this.os.setDtAtendimento(date);
        }
        if (this.os.getStatusOs().getStatus().equals("Fechada") || this.os.getStatusOs().getStatus().equals("Cancelada")) {
            this.os.setDtFechamento(date);
        }
        osDAO.atualizar(this.os);
        mensagem("Ordem de Serviço Atualizada", null);
        os = new OrdemServico();
        return "pesquisaOS";
    }
    
    public void setaEqp(){
        if (!varEqp) {
            varEqp = true;
        }
    }
    
    public boolean alteraBtn(){
        if (varEqp) {
            disabled = false;
        }
        return disabled;
    }
    
    public void setaFunc(){
        if (!varFunc) {
            varFunc = true;
        }
    }
    
    public boolean alteraBtnAlterar(){
        if (btnAtualizarOS) {
            btnAtualizarOS = false;
        }
        return btnAtualizarOS;
    }
}
