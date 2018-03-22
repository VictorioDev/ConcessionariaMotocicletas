/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.domain;

/**
 *
 * @author Victorio Zansavio
 */
public class Modelo {
    private int idModelos;
    private String nome;
    private String descricao;

    public int getIdModelos() {
        return idModelos;
    }

    public void setIdModelos(int idModelos) {
        this.idModelos = idModelos;
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
