package br.ads.concessionaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victorio Zansavio
 */

@Controller
public class UsuarioController {
    
    @RequestMapping("usuarios/novo}")
    public String cadastroUsuario(){
        return "usuario";
    }
    
   
}
