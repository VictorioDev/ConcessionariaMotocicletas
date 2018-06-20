/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.domain;

import java.sql.Date;

/**
 *
 * @author Victorio Zansavio
 */
public class Fatura {
    private int idFatura;
    private int numeroParcela;
    private Date dataEmissao;
    private Date dataVencimento;
    private double valorParcela;
    private String status;
    private String dataPagamento;
    private String tipoPagamento;
    private double valorPago;
    private Usuario usuarioBaixa;
    private Venda venda; 

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }
    
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    public double getValorPago() {
        return this.valorPago;
    }
    
    public void setValorPago( double valorPago ) {
        this.valorPago = valorPago;
    }

    public Usuario getUsuarioBaixa() {
        return this.usuarioBaixa;
    }
    
    public void setUsuarioBaixa( Usuario usuarioBaixa ) {
        this.usuarioBaixa = usuarioBaixa;
    }
    
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    
}
