/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.MarcaDAO;
import br.ads.concessionaria.dao.ModeloDAO;
import br.ads.concessionaria.domain.Marca;
import br.ads.concessionaria.domain.Modelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ivens Mathias
 */
@Controller
public class ModeloController {
        
    @RequestMapping(value = "modelos", method = RequestMethod.GET)
    public ModelAndView listarModelos(Model m) {
        ArrayList<Modelo> listaModel = new ArrayList<>();
        try {
            listaModel = ModeloDAO.listarModelos();
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("Tamanho Lista: " + listaModel.size());
        m.addAttribute("modelos", listaModel);
        return new ModelAndView("modelos/indexView");
    }

    @RequestMapping(value = "modelos/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(Model m) {
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        try {
            listaMarcas = MarcaDAO.listarMarcas();
            m.addAttribute("marcas", listaMarcas);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("modelos/cadastrarView", "modelo", new Modelo());
    }

    @RequestMapping(value = "modelos/cadastrar", method = RequestMethod.POST)
    public String adicionarModelo(@ModelAttribute("modelo") Modelo m, HttpServletRequest request) {
        int idMarca = Integer.parseInt(request.getParameter("idMarca"));
        Marca marca = new Marca();
        try {
            marca = MarcaDAO.retornarMarcaPorId(idMarca);
            m.setMarca(marca);
            ModeloDAO.incluirModelo(m);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/modelos";
    }

    @RequestMapping(value = "modelos/alterar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar( @PathVariable("id") int idModelo, Model model ) {
        Modelo m = new Modelo();
        System.err.println("Chegou o id " + idModelo);
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        try {
            m = ModeloDAO.retornaModeloPorId(idModelo);
            listaMarcas = MarcaDAO.listarMarcas();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("marcas", listaMarcas);
        return new ModelAndView("modelos/alterarView", "modelo", m);
    }
    
      @RequestMapping(value = "modelos/alterar", method = RequestMethod.POST)
    public ModelAndView alterarModelo(@ModelAttribute("modelo") Modelo m, HttpServletRequest request) {
        int idMarca = Integer.parseInt(request.getParameter("idMarca"));
        Marca marca = new Marca();
        System.out.println("Modelo id " + m.getIdModelo());
        try {
            marca = MarcaDAO.retornarMarcaPorId(idMarca);
            m.setMarca(marca);
            ModeloDAO.alterarModelo(m);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/modelos");
    }
    
    
      @RequestMapping(value = "modelos/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerModelo(@PathVariable("id") int idModelo) {
        
        try {
            ModeloDAO.excluirModelo(idModelo);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/modelos");
    }
    
    
    @RequestMapping(value = "modelos/visualizar/{id}", method = RequestMethod.GET)
    public ModelAndView visualizarModelo(@PathVariable("id") int idModelo) {
        Modelo modelo = new Modelo();
        try {
            modelo = ModeloDAO.retornaModeloPorId(idModelo);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("modelos/VisualizarView", "modelo", modelo);
    }
}
