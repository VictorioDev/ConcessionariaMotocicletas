/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.AcessorioDAO;
import br.ads.concessionaria.dao.CategoriaDAO;
import br.ads.concessionaria.domain.Acessorio;
import br.ads.concessionaria.domain.Categoria;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AcessorioController {
    
    @RequestMapping("acessorios")
    public ModelAndView listarAcessorios(Model m){
        ArrayList<Acessorio> listarAcessorios = new ArrayList<>();
        try {
           listarAcessorios = AcessorioDAO.listarAcessorios();
        } catch (SQLException ex) {
            //return ...
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        m.addAttribute("acessorios", listarAcessorios);
        return new ModelAndView("acessorios/IndexViewAcessorios");
    }
    
    @RequestMapping(value="acessorios/visualizar/{id}", method=RequestMethod.GET)
    public ModelAndView visualizarAcessorios(@PathVariable("id") int id){
        Acessorio a = new Acessorio();
        System.err.println("Id vindo da view: " + id);
        try {
           a = AcessorioDAO.retornarAcessorioPorId(id);
        } catch (SQLException ex) {
            //return ...
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        System.out.println(a.getDescricao());
        return new ModelAndView("acessorios/VisualizarViewAcessorios", "acessorio", a);
    }
    
    @RequestMapping(value = "acessorios/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar() {
        return new ModelAndView("acessorios/CadastrarViewAcessorios", "acessorio", new Acessorio());
    }
    
    @RequestMapping(value = "acessorios/cadastrar", method = RequestMethod.POST)
    public String adicionarAcessorio(@ModelAttribute("acessorio") Acessorio a) {
        try {
            AcessorioDAO.incluirAcessorio(a);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/acessorios";
    }
     
    @RequestMapping(value = "acessorios/editar/{id}", method = RequestMethod.GET)
    public ModelAndView editarAcessorio( @PathVariable("id") int idAcessorio ) {
        Acessorio a = new Acessorio();
        System.out.println("Chegou o id " + idAcessorio);
        try {
            a = AcessorioDAO.retornarAcessorioPorId(idAcessorio);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("acessorios/EditarViewAcessorios", "acessorio", a);
    }
       
    @RequestMapping(value = "acessorios/editar", method = RequestMethod.POST)
    public ModelAndView editarAcessorio(@ModelAttribute("acessorio") Acessorio a) {
        System.out.println("Acessorio id " + a.getIdAcessorio());
        try {
            AcessorioDAO.alterarAcessorio(a);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/acessorios");
    }
        
    @RequestMapping(value = "acessorios/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerAcessorio(@PathVariable("id") int idAcessorio) {
        try {
            AcessorioDAO.removerAcessorio(idAcessorio);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/acessorios");
    }
    
}