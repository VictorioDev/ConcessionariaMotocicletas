/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.MotocicletaDAO;
import br.ads.concessionaria.dao.ProprietarioDAO;
import br.ads.concessionaria.dao.UsuarioDAO;
import br.ads.concessionaria.domain.Proprietario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Victorio Zansavio
 */
@Controller
public class ProprietarioController {

    @RequestMapping(value = "proprietarios", method = RequestMethod.GET)
    public ModelAndView listarProprietarios(Model m, HttpServletRequest request) {
        String query = request.getParameter("search");
        ArrayList<Proprietario> listaProp = new ArrayList<>();
        try {
            listaProp = ProprietarioDAO.listarProprietarios(query);
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("proprietarios", listaProp);
        return new ModelAndView("proprietarios/IndexViewProprietarios");
    }

    @RequestMapping(value = "proprietarios/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(Proprietario proprietario) {
        return new ModelAndView("proprietarios/CadastrarViewProprietarios", "proprietario", proprietario);
    }

    @RequestMapping(value = "proprietarios/cadastrar", method = RequestMethod.POST)
    public String adicionarProprietario(@ModelAttribute("proprietario") @Valid Proprietario p,
            BindingResult bindingResult,
            RedirectAttributes attrs) {
        if (bindingResult.hasErrors()) {

            attrs.addFlashAttribute("nome", bindingResult.hasFieldErrors("nome") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("razaoSocial", bindingResult.hasFieldErrors("razaoSocial") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("endereco", bindingResult.hasFieldErrors("endereco") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("telefone", bindingResult.hasFieldErrors("telefone") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("email", bindingResult.hasFieldErrors("email") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("cartorio", bindingResult.hasFieldErrors("cartorio") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("proprietario", p);

            return "redirect:/proprietarios/cadastrar";
        } else {

            try {
                ProprietarioDAO.incluirProprietario(p);
            } catch (SQLException ex) {
                Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/proprietarios";
        }

    }

    @RequestMapping(value = "proprietarios/editar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable("id") int idProprietario) {
        Proprietario p = new Proprietario();
        System.err.println("Chegou o id " + idProprietario);
        try {
            p = ProprietarioDAO.retornaProprietarioPorId(idProprietario);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("proprietarios/EditarViewProprietarios", "proprietario", p);
    }

    @RequestMapping(value = "proprietarios/editar", method = RequestMethod.POST)
    public ModelAndView alterarProprietario(@ModelAttribute("proprietario") @Valid Proprietario p,
            BindingResult bindingResult,
            RedirectAttributes attrs) {
        System.out.println("Proprietario id " + p.getIdProprietario());
        if (bindingResult.hasErrors()) {

            attrs.addFlashAttribute("nome", bindingResult.hasFieldErrors("nome") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("razaoSocial", bindingResult.hasFieldErrors("razaoSocial") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("endereco", bindingResult.hasFieldErrors("endereco") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("telefone", bindingResult.hasFieldErrors("telefone") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("email", bindingResult.hasFieldErrors("email") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("cartorio", bindingResult.hasFieldErrors("cartorio") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("proprietario", p);

            return new ModelAndView("redirect:/proprietarios/editar/" + p.getIdProprietario());
        } else {
            try {
                ProprietarioDAO.alterarProprietario(p);
            } catch (SQLException ex) {
                Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/proprietarios");
        }

    }

    @RequestMapping(value = "proprietarios/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerProprietario(@PathVariable("id") int idProprietario,
                                            RedirectAttributes attrs) {

        try {
            int totalMotocicletas = MotocicletaDAO.contaMotocicletasPorProprietario(idProprietario);
            System.err.println("Total Motocicletas: " + totalMotocicletas);
            if (totalMotocicletas == 0){
                 ProprietarioDAO.excluirProprietario(idProprietario);
            }else {
                Proprietario p = ProprietarioDAO.retornaProprietarioPorId(idProprietario);
                attrs.addFlashAttribute("hasMsg", true);
                attrs.addFlashAttribute("msg", "O usuário " + p.getNome() + " possui mototicletas vinculadas a ele e não poderá ser excluído");
            }
         
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
        return new ModelAndView("proprietarios/VisualizarViewProprietarios", "proprietario", p);
    }
}
