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
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Victorio Zansavio
 */
@Controller
public class ProprietarioController {

    @RequestMapping(value = "proprietarios", method = RequestMethod.GET)
    public ModelAndView listarProprietarios(Model m) {
        
        ArrayList<Proprietario> listaProp = new ArrayList<>();
        try {
            listaProp = ProprietarioDAO.listarProprietarios();
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("proprietarios", listaProp);
        return new ModelAndView("proprietarios/indexView");
    }

    @RequestMapping(value = "proprietarios/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar() {
        return new ModelAndView("proprietarios/cadastrarView", "proprietario", new Proprietario());
    }

    @RequestMapping(value = "proprietarios/cadastrar", method = RequestMethod.POST)
    public String adicionarProprietario(@ModelAttribute("proprietario") Proprietario p) {
        try {
            ProprietarioDAO.incluirProprietario(p);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/proprietarios";
    }

    @RequestMapping(value = "proprietarios/alterar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar( @PathVariable("id") int idProprietario ) {
        Proprietario p = new Proprietario();
        System.err.println("Chegou o id " + idProprietario);
        try {
            p = ProprietarioDAO.retornaProprietarioPorId(idProprietario);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("proprietarios/alterarView", "proprietario", p);
    }
    
      @RequestMapping(value = "proprietarios/alterar", method = RequestMethod.POST)
    public ModelAndView alterarProprietario(@ModelAttribute("proprietario") Proprietario p) {
        System.out.println("Proprietario id " + p.getIdProprietario());
        try {
            ProprietarioDAO.alterarProprietario(p);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/proprietarios");
    }
    
    
    @RequestMapping(value = "proprietarios/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerProprietario(@PathVariable("id") int idProprietario) {
        
        try {
            ProprietarioDAO.excluirProprietario(idProprietario);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/proprietarios");
    }
    
     @RequestMapping(value = "proprietarios/visualizar/{id}", method = RequestMethod.GET)
    public ModelAndView visualizarProprietario(@PathVariable("id") int idProprietario) {
        Proprietario p = new Proprietario();
        try {
            p = ProprietarioDAO.retornaProprietarioPorId(idProprietario);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("proprietarios/VisualizarView", "proprietario", p);
    }
}
