/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.ModeloDAO;
import br.ads.concessionaria.dao.MotocicletaDAO;
import br.ads.concessionaria.dao.ProprietarioDAO;
import br.ads.concessionaria.domain.Modelo;
import br.ads.concessionaria.domain.Motocicleta;
import br.ads.concessionaria.domain.Proprietario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Victorio Zansavio
 */

@Controller
public class MotocicletaController {
    @RequestMapping(value = "motocicletas", method = RequestMethod.GET)
     public ModelAndView listarMotocicletas(Model m) {
        
        ArrayList<Motocicleta> listaMotocicletas = new ArrayList<>();
        try {
            listaMotocicletas = MotocicletaDAO.listarMotocicletas();
            System.err.println("Size(): " + listaMotocicletas.size());
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("mototicletas", listaMotocicletas);
        return new ModelAndView("motocicletas/indexView");
    }
     
  
    

    @RequestMapping(value = "motocicletas/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(Model m) {
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        ArrayList<Modelo> listaModelos = new ArrayList<>();
        
        try {
            listaProprietarios = ProprietarioDAO.listarProprietarios();
            listaModelos = ModeloDAO.listarModelos();
        } catch (SQLException ex) {
            Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.addAttribute("proprietarios", listaProprietarios);
        m.addAttribute("modelos",listaModelos);
        return new ModelAndView("motocicletas/cadastrarView", "motocicleta", new Motocicleta());
    }
    
    
  
    @RequestMapping(value = "motocicletas/cadastrar", method = RequestMethod.POST)
    public String adicionarProprietario(@ModelAttribute("motocicleta") Motocicleta m, HttpServletRequest request) {
        int idProprietario = Integer.parseInt(request.getParameter("idProprietario"));
        int idModelo = Integer.parseInt(request.getParameter("idModelo"));
        Proprietario proprietario = new Proprietario();
        Modelo modelo = new Modelo();
        try {
            proprietario = ProprietarioDAO.retornaProprietarioPorId(idProprietario);
            modelo = ModeloDAO.retornaModeloPorId(idModelo);
            m.setProprietario(proprietario);
            m.setModelo(modelo);
            MotocicletaDAO.incluirMotocicleta(m);
        } catch (SQLException ex) {
            Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/motocicletas";
    }

    @RequestMapping(value = "motocicletas/alterar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar( @PathVariable("id") int idMototicleta, Model model ) {
        Motocicleta motocicleta = new Motocicleta();
        ArrayList<Modelo> listaModelos = new ArrayList<>();
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        try {
            listaModelos = ModeloDAO.listarModelos();
            listaProprietarios = ProprietarioDAO.listarProprietarios();
            for(Modelo modelo: listaModelos){
                System.err.println("Modelo Id:" + modelo.getIdModelo());
            }
            motocicleta = MotocicletaDAO.retornaMotocicletaPorId(idMototicleta);
            model.addAttribute("modelos", listaModelos);
            model.addAttribute("proprietarios", listaProprietarios);
            System.err.println("Modelo motocicleta: " + motocicleta.getModelo().getIdModelo());
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("motocicletas/alterarView", "motocicleta", motocicleta);
    }
    
     /*
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
    }*/
    
  
}
