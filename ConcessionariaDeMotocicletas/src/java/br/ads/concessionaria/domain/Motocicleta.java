   

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.domain;

import br.ads.concessionaria.interfaces.MotocicletaNova;
import br.ads.concessionaria.interfaces.MotocicletaUsada;
import java.sql.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Victorio Zansavio
 */
public class Motocicleta {
    private int idMotocicleta;
    
    @Min(value = 1, groups = {MotocicletaUsada.class, MotocicletaNova.class})
    private int ano;
    
    @NotBlank(groups = {MotocicletaUsada.class, MotocicletaNova.class})
    private String chassi;
    
    @NotBlank(groups = {MotocicletaUsada.class, MotocicletaNova.class})
    private String cor;
    
    @NotBlank(groups = {MotocicletaUsada.class, MotocicletaNova.class})
    private String tipoCombustivel;
    
    @Min(value = 1, groups = {MotocicletaUsada.class, MotocicletaNova.class})
    private double valorCompra;
    
    @Min(value = 1, groups = {MotocicletaUsada.class, MotocicletaNova.class})
    private double valorVenda;
    
    private String situacaoMotocicleta;
    
    @Min(value = 0, groups = {MotocicletaUsada.class})
    private int renavam;
    
    @NotBlank(groups = {MotocicletaUsada.class})
    private String placa;
    
    @NotBlank(groups = {MotocicletaUsada.class, MotocicletaNova.class})
    private String motor;
       
    @Min(value = 1, groups = {MotocicletaUsada.class})
    private double valorIPVA;
    
    @NotBlank(groups = {MotocicletaUsada.class})
    private String situacaoIPVA;
    
    private Proprietario proprietario;
    
    private Modelo modelo;

    /**
     * @return the idMotocicleta
     */
    public int getIdMotocicleta() {
        return idMotocicleta;
    }

    /**
     * @param idMotocicleta the idMotocicleta to set
     */
    public void setIdMotocicleta(int idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the chassi
     */
    public String getChassi() {
        return chassi;
    }

    /**
     * @param chassi the chassi to set
     */
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the tipoCombustivel
     */
    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    /**
     * @param tipoCombustivel the tipoCombustivel to set
     */
    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    /**
     * @return the valorCompra
     */
    public double getValorCompra() {
        return valorCompra;
    }

    /**
     * @param valorCompra the valorCompra to set
     */
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * @return the valorVenda
     */
    public double getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the situacaoMotocicleta
     */
    public String getSituacaoMotocicleta() {
        return situacaoMotocicleta;
    }

    /**
     * @param situacaoMotocicleta the situacaoMotocicleta to set
     */
    public void setSituacaoMotocicleta(String situacaoMotocicleta) {
        this.situacaoMotocicleta = situacaoMotocicleta;
    }

    /**
     * @return the renavam
     */
    public int getRenavam() {
        return renavam;
    }

    /**
     * @param renavam the renavam to set
     */
    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * @return the valorIPVA
     */
    public double getValorIPVA() {
        return valorIPVA;
    }

    /**
     * @param valorIPVA the valorIPVA to set
     */
    public void setValorIPVA(double valorIPVA) {
        this.valorIPVA = valorIPVA;
    }

    /**
     * @return the situacaoIPVA
     */
    public String getSituacaoIPVA() {
        return situacaoIPVA;
    }

    /**
     * @param situacaoIPVA the situacaoIPVA to set
     */
    public void setSituacaoIPVA(String situacaoIPVA) {
        this.situacaoIPVA = situacaoIPVA;
    }

    /**
     * @return the proprietario
     */
    public Proprietario getProprietario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
  
}
