package br.com.ordemDeServico.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Servico implements Serializable{

    @NotNull(message = "A data é de preenchimento obrigatório!")
    @Temporal(TemporalType.DATE)
    private Date dtEntrada;
    
    @Temporal(TemporalType.DATE)
    private Date dtAtendimento;
    
    @Temporal(TemporalType.DATE)
    private Date dtFechamento;
    
    @Column(precision = 7, scale = 2)
    private BigDecimal vlrTotalServico = new BigDecimal("0.00");

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Date getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(Date dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

    public Date getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(Date dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public BigDecimal getVlrTotalServico() {
        return vlrTotalServico;
    }

    public void setVlrTotalServico(BigDecimal vlrTotalServico) {
        this.vlrTotalServico = vlrTotalServico;
    }


}
