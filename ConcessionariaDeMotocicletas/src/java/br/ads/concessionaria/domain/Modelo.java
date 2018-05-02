/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.domain;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Victorio Zansavio
 */
public class Modelo {
    private int idModelo;
    
    @NotBlank
    private String nome;
    
    @NotBlank
    private String descricao;
    
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelos) {
        this.idModelo = idModelos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
