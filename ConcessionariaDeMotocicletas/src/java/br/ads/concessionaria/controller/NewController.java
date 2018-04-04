/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Victorio Zansavio
 */
@Controller
public class NewController {
    @RequestMapping("/Usuario/atualizar/{id}")
    public String inicio(@PathVariable("id") String id){
        System.err.println();
        return "index";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/painel")
    public String painel() {
        return "painel";
    }
    
    @RequestMapping("/vendas")
    public String vendas() {
        return "vendas/index";
    }    
}
