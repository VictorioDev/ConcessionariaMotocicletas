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
public class CategoriaMotocicleta {
    private Motocicleta motocicleta;
    private Categoria caategoria;

    public Motocicleta getMotocicleta() {
        return motocicleta;
    }

    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }

    public Categoria getCaategoria() {
        return caategoria;
    }

    public void setCaategoria(Categoria caategoria) {
        this.caategoria = caategoria;
    }
    
    
}
