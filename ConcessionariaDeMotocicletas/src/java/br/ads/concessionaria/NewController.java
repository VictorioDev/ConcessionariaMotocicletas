/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Victorio Zansavio
 */
@Controller
public class NewController {

    @RequestMapping("/olamundo")
    public String inicio(){
        return "index";
    }
    
}
