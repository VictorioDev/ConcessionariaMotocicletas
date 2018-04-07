/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Victorio Zansavio
 */
@Controller
public class PainelController {
    
    @RenderMapping("/")
    public ModelAndView home(){
        return new ModelAndView("redirect:/painel");
    }
}
