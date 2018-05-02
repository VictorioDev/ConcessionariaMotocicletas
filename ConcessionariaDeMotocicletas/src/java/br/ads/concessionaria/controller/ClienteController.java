/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import br.ads.concessionaria.dao.ClienteDAO;

import br.ads.concessionaria.domain.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
 * Controller responsável pelos clientes.
 *
 * @author Smania
 */
@Controller
public class ClienteController {

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ModelAndView listarClientes(Model m, HttpServletRequest request) {
        String query = request.getParameter("search");
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        try {
            listaCliente = ClienteDAO.listarCliente(query);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

        m.addAttribute("clientes", listaCliente);
        return new ModelAndView("clientes/IndexViewClientes");
    }

    @RequestMapping(value = "/clientes/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(Cliente c) {
        return new ModelAndView("clientes/CadastrarViewClientes", "cliente", c);
    }

    @RequestMapping(value = "clientes/cadastrar", method = RequestMethod.POST)
    public String adicionarCliente(@ModelAttribute("cliente") @Valid Cliente c,
            BindingResult bindingResult,
            RedirectAttributes attrs) {

        if (bindingResult.hasErrors()) {
            if (bindingResult.hasFieldErrors("tipo")) {
                attrs.addFlashAttribute("tipo", "is-invalid");
            } else {
                attrs.addFlashAttribute("tipo", "is-valid");
            }

            if (bindingResult.hasFieldErrors("nome")) {
                attrs.addFlashAttribute("nome", "is-invalid");
            } else {
                attrs.addFlashAttribute("nome", "is-valid");
            }

            if (bindingResult.hasFieldErrors("razaoSocial")) {
                attrs.addFlashAttribute("razaoSocial", "is-invalid");
            } else {
                attrs.addFlashAttribute("razaoSocial", "is-valid");
            }

            if (bindingResult.hasFieldErrors("endereco")) {
                attrs.addFlashAttribute("endereco", "is-invalid");
            } else {
                attrs.addFlashAttribute("endereco", "is-valid");
            }

            if (bindingResult.hasFieldErrors("telefone")) {
                attrs.addFlashAttribute("telefone", "is-invalid");
            } else {
                attrs.addFlashAttribute("telefone", "is-valid");
            }

            if (bindingResult.hasFieldErrors("email")) {
                attrs.addFlashAttribute("email", "is-invalid");
            } else {
                attrs.addFlashAttribute("email", "is-valid");
            }

            attrs.addFlashAttribute("cliente", c);

            return "redirect:/clientes/cadastrar";
        } else {
            try {
                ClienteDAO.incluirCliente(c);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/clientes";
        }

    }

    //metodo para remover cliente
    @RequestMapping(value = "clientes/remover/{id}", method = RequestMethod.GET)
    public String remover(@PathVariable("id") int id) {

        Cliente c = new Cliente();
        c.setIdCliente(id);

        try {
            ClienteDAO.removerCliente(c);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/clientes";
    }

    @RequestMapping(value = "clientes/editar/{id}", method = RequestMethod.GET)
    public ModelAndView alterarCliente(@PathVariable("id") int idCliente) {
        Cliente c = new Cliente();

        try {
            c = ClienteDAO.retornarClientePorId(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("clientes/EditarViewClientes", "cliente", c);
    }

    //metodo para alterar cliente
    @RequestMapping(value = "clientes/editar", method = RequestMethod.POST)
    public ModelAndView alterarCliente(@ModelAttribute("cliente") @Valid Cliente c,
            BindingResult bindingResult,
            RedirectAttributes attrs) {
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasFieldErrors("tipo")) {
                attrs.addFlashAttribute("tipo", "is-invalid");
            } else {
                attrs.addFlashAttribute("tipo", "is-valid");
            }

            if (bindingResult.hasFieldErrors("nome")) {
                attrs.addFlashAttribute("nome", "is-invalid");
            } else {
                attrs.addFlashAttribute("nome", "is-valid");
            }

            if (bindingResult.hasFieldErrors("razaoSocial")) {
                attrs.addFlashAttribute("razaoSocial", "is-invalid");
            } else {
                attrs.addFlashAttribute("razaoSocial", "is-valid");
            }

            if (bindingResult.hasFieldErrors("endereco")) {
                attrs.addFlashAttribute("endereco", "is-invalid");
            } else {
                attrs.addFlashAttribute("endereco", "is-valid");
            }

            if (bindingResult.hasFieldErrors("telefone")) {
                attrs.addFlashAttribute("telefone", "is-invalid");
            } else {
                attrs.addFlashAttribute("telefone", "is-valid");
            }

            if (bindingResult.hasFieldErrors("email")) {
                attrs.addFlashAttribute("email", "is-invalid");
            } else {
                attrs.addFlashAttribute("email", "is-valid");
            }

            attrs.addFlashAttribute("cliente", c);

            return new ModelAndView("redirect:/clientes/editar/" + c.getIdCliente());
        } else {
            try {
                ClienteDAO.alterarCliente(c);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/clientes");
        }

    }

    @RequestMapping(value = "clientes/visualizar/{id}", method = RequestMethod.GET)
    public ModelAndView visualizar(@PathVariable("id") int id) {

        Cliente c = new Cliente();

        try {
            c = ClienteDAO.retornarClientePorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ModelAndView("clientes/VisualizarViewClientes", "cliente", c);
    }

}
