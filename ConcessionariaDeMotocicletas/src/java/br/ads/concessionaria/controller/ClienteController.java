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
 * Controller responsável pelos clientes.
 * @author Smania
 */
@Controller
public class ClienteController {
        
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ModelAndView listarClientes(Model m) {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        try {
            listaCliente = ClienteDAO.listarCliente();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        m.addAttribute("clientes", listaCliente);
        return new ModelAndView("clientes/indexView");
    }
    
    @RequestMapping(value = "/clientes/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar() {
        return new ModelAndView("clientes/cadastrarView", "cliente", new Cliente());
    }

    @RequestMapping(value = "clientes/cadastrar", method = RequestMethod.POST)
    public String adicionarCliente(@ModelAttribute("cliente") Cliente c) {
        try {
            ClienteDAO.incluirCliente(c);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/clientes";
    }  
        
    @RequestMapping( value = "clientes/remover/{id}", method = RequestMethod.GET )
    public String remover( @PathVariable("id") int id ) {
        
        Cliente c = new Cliente();
        c.setIdCliente( id );
        
        try {
            ClienteDAO.removerCliente (c );
        } catch( SQLException ex ) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "redirect:/clientes";
    }
        
 
    
}
