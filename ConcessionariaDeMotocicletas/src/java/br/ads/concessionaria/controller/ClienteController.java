/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.ClienteDAO;

import br.ads.concessionaria.domain.Cliente;

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

/**
 *
 * @author Smania
 */
public class ClienteController {
    
    @RequestMapping(value = "clientes", method = RequestMethod.GET)
    public ModelAndView listarClientes(Model m) {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        try {
            listaCliente = ClienteDAO.listarCliente();
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("clientes", listaCliente);
        return new ModelAndView("cliente/indexView");
    }
    @RequestMapping(value = "cliente/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar() {
        return new ModelAndView("cliente/cadastrarView", "cliente", new Cliente());
    }

    
 
    @RequestMapping(value = "cliente/cadastrar", method = RequestMethod.POST)
    public String adicionarProprietario(@ModelAttribute("cliente") Cliente c) {
        try {
            ClienteDAO.incluirCliente(c);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/cliente";
    }

     
    /*@RequestMapping(value = "marcas/alterar/{id}", method = RequestMethod.GET)
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
    
    
      @RequestMapping(value = "marcas/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerMarca(@PathVariable("id") int idMarca) {
        
        try {
            MarcaDAO.excluirMarca(idMarca);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/marcas");
    }*/
    
}
