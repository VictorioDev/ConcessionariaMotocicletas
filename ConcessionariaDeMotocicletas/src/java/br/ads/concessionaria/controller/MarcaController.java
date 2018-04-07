/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.MarcaDAO;
import br.ads.concessionaria.dao.ProprietarioDAO;
import br.ads.concessionaria.domain.Marca;
import br.ads.concessionaria.domain.Proprietario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MarcaController {

    @RequestMapping(value = "marcas", method = RequestMethod.GET)
    public ModelAndView listarProprietarios(Model m) {
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        try {
            listaMarcas = MarcaDAO.listarMarcas();
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("marcas", listaMarcas);
        return new ModelAndView("marcas/indexView");
    }
    @RequestMapping(value = "marcas/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar() {
        return new ModelAndView("marcas/cadastrarView", "marca", new Marca());
    }

    
 
    @RequestMapping(value = "marcas/cadastrar", method = RequestMethod.POST)
    public String adicionarProprietario(@ModelAttribute("marca") Marca m) {
        try {
            MarcaDAO.incluirMarca(m);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/marcas";
    }

     
    @RequestMapping(value = "marcas/alterar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar( @PathVariable("id") int idMarca ) {
        Marca m = new Marca();
        System.err.println("Chegou o id " + idMarca);
        try {
            m = MarcaDAO.retornarMarcaPorId(idMarca);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("marcas/alterarView", "marca", m);
    }
    
      
    
      @RequestMapping(value = "marcas/alterar", method = RequestMethod.POST)
    public ModelAndView alterarProprietario(@ModelAttribute("marca") Marca m) {
        System.out.println("Marca id " + m.getIdMarca());
        try {
            MarcaDAO.alterarMarca(m);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/marcas");
    }
    
    /*
      @RequestMapping(value = "proprietarios/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerProprietario(@PathVariable("id") int idProprietario) {
        
        try {
            ProprietarioDAO.excluirProprietario(idProprietario);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/proprietarios");
    }*/
}
