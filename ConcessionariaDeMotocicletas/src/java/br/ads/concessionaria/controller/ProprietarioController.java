/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.ProprietarioDAO;
import br.ads.concessionaria.domain.Proprietario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Victorio Zansavio
 */

@Controller
public class ProprietarioController {
    
    
    
    @RequestMapping("proprietarios/listar")
    public ModelAndView listarProprietarios(Model m){
        ArrayList<Proprietario> listaProp = new ArrayList<>();
        try {
           listaProp = ProprietarioDAO.listarProprietarios();
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        for(int i = 0; i < listaProp.size(); i++){
            System.err.println("Nome: " + listaProp.get(i).getNome());
        }
       
        m.addAttribute("proprietarios", listaProp);
        return new ModelAndView("listarProprietarios");
    }
}
