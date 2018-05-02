/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.MarcaDAO;

import br.ads.concessionaria.domain.Marca;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Victorio Zansavio
 */
@Controller
public class MarcaController {

    @RequestMapping(value = "marcas", method = RequestMethod.GET)
    public ModelAndView listarMarcas(Model m, HttpServletRequest request) {
        String query = request.getParameter("search");

        ArrayList<Marca> listaMarcas = new ArrayList<>();
        try {
            listaMarcas = MarcaDAO.listarMarcas(query);
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("marcas", listaMarcas);
        return new ModelAndView("marcas/indexView");
    }

    @RequestMapping(value = "marcas/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(Marca m) {
        return new ModelAndView("marcas/cadastrarView", "marca", m);
    }

    @RequestMapping(value = "marcas/cadastrar", method = RequestMethod.POST)
    public ModelAndView adicionarMarca(@ModelAttribute("marca") @Valid Marca m,
            BindingResult result,
            RedirectAttributes attrs
    ) {
        if (result.hasErrors()) {
            if (result.hasFieldErrors("nome")) {
                System.err.println("Nome com erro!");
                attrs.addFlashAttribute("nome", "is-invalid");
            } else {

                attrs.addFlashAttribute("nome", "is-valid");
            }

            if (result.hasFieldErrors("descricao")) {
                attrs.addFlashAttribute("descricao", "is-invalid");
                System.err.println("Descricao com erro!");
            } else {

                attrs.addFlashAttribute("descricao", "is-valid");
            }
            attrs.addFlashAttribute("marca", m);
            return new ModelAndView("redirect:/marcas/cadastrar");
        } else {
            try {
                MarcaDAO.incluirMarca(m);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/marcas");
        }

    }

    @RequestMapping(value = "marcas/alterar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable("id") int idMarca) {
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
    public ModelAndView alterarProprietario(@ModelAttribute("marca") @Valid Marca m,
            BindingResult bindingResult,
            RedirectAttributes attrs) {
        if (bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("nome")){
                attrs.addFlashAttribute("nome", "is-invalid");
            }else {
                attrs.addFlashAttribute("nome", "is-valid");
            }
            
            if(bindingResult.hasFieldErrors("descricao")){
                attrs.addFlashAttribute("descricao", "is-invalid");
            }else {
                attrs.addFlashAttribute("descricao", "is-valid");
            }
            
            
            attrs.addFlashAttribute("marca", m);
            return new ModelAndView("redirect:/marcas/alterar/"+ m.getIdMarca());
            
        } else {

            System.out.println("Marca id " + m.getIdMarca());
            try {
                MarcaDAO.alterarMarca(m);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/marcas");
        }

    }

    @RequestMapping(value = "marcas/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerMarca(@PathVariable("id") int idMarca) {

        try {
            MarcaDAO.excluirMarca(idMarca);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/marcas");
    }

    @RequestMapping(value = "marcas/visualizar/{id}", method = RequestMethod.GET)
    public ModelAndView visualizarMarca(@PathVariable("id") int idMarca, Model m) {
        Marca marca = new Marca();
        try {
            marca = MarcaDAO.retornarMarcaPorId(idMarca);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("marcas/VisualizarView", "marca", marca);
    }
}
