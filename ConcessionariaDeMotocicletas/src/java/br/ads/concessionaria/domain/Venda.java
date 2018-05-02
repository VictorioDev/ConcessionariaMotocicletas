/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.domain;

import java.lang.annotation.Native;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Victorio Zansavio
 */
public class Venda {
    private int idVenda;
    
   
    private String dataVenda;
   
    @Min(value = 1)
    private int quantidadeParcelas;
        
    private double valor;
    
    @Min(value = 1)
    @Max(value = 31)
    private int diaPreferencial;
    
   
    private String status;
    
    private Cliente cliente;
    private Usuario usuario;
    private Motocicleta motocicleta;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDiaPreferencial() {
        return diaPreferencial;
    }

    public void setDiaPreferencial(int diaPreferencial) {
        this.diaPreferencial = diaPreferencial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Motocicleta getMotocicleta() {
        return motocicleta;
    }

    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }
    
    
}
