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
public class Acessorio {
    private int idAcessorio;
    private String nome;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    public int getIdAcessorio() {
        return idAcessorio;
    }

    public void setIdAcessorio(int idAcessorio) {
        this.idAcessorio = idAcessorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 
    
}
