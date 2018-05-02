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
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class MotocicletaController {

    @RequestMapping(value = "motocicletas", method = RequestMethod.GET)
    public ModelAndView listarMotocicletas(Model m, HttpServletRequest request) {
        String query = request.getParameter("search");
        ArrayList<Motocicleta> listaMotocicletas = new ArrayList<>();
        try {
            listaMotocicletas = MotocicletaDAO.listarMotocicletas(query);

            System.err.println("Size(): " + listaMotocicletas.size());
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("motocicletas", listaMotocicletas);
        return new ModelAndView("motocicletas/IndexViewMotocicletas");
    }

    @RequestMapping(value = "motocicletas/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(Model m, Motocicleta motocicleta) {
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        ArrayList<Modelo> listaModelos = new ArrayList<>();

        try {
            listaProprietarios = ProprietarioDAO.listarProprietarios("");
            listaModelos = ModeloDAO.listarModelos("");
        } catch (SQLException ex) {
            Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        m.addAttribute("proprietarios", listaProprietarios);
        m.addAttribute("modelos", listaModelos);
        return new ModelAndView("motocicletas/CadastrarViewMotocicletas", "motocicleta", motocicleta);
    }

    @RequestMapping(value = "motocicletas/cadastrar", method = RequestMethod.POST)

    public String adicionarMotocicleta(@ModelAttribute("motocicleta") @Valid Motocicleta m,
            BindingResult bindingResult,
            HttpServletRequest request,
            RedirectAttributes attrs) {

        if (bindingResult.hasErrors()) {
            attrs.addFlashAttribute("ano", bindingResult.hasFieldErrors("ano") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("chassi", bindingResult.hasFieldErrors("chassi") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("cor", bindingResult.hasFieldErrors("cor") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("tipoCombustivel", bindingResult.hasFieldErrors("tipoCombustivel") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("valorCompra", bindingResult.hasFieldErrors("valorCompra") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("valorVenda", bindingResult.hasFieldErrors("valorVenda") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("renavam", bindingResult.hasFieldErrors("renavam") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("placa", bindingResult.hasFieldErrors("placa") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("motor", bindingResult.hasFieldErrors("motor") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("valorIPVA", bindingResult.hasFieldErrors("valorIPVA") ? "is-invalid" : "is-valid");

            attrs.addFlashAttribute("motocicleta", m);
            return "redirect:/motocicletas/cadastrar";
        } else {
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

    }

    @RequestMapping(value = "motocicletas/editar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable("id") int idMototicleta, Model model) {
        Motocicleta motocicleta = new Motocicleta();
        ArrayList<Modelo> listaModelos = new ArrayList<>();
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        try {
            listaModelos = ModeloDAO.listarModelos("");
            listaProprietarios = ProprietarioDAO.listarProprietarios("");
            motocicleta = MotocicletaDAO.retornaMotocicletaPorId(idMototicleta);
            model.addAttribute("modelos", listaModelos);
            model.addAttribute("proprietarios", listaProprietarios);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("motocicletas/EditarViewMotocicletas", "motocicleta", motocicleta);
    }

    @RequestMapping(value = "motocicletas/editar/{id}", method = RequestMethod.POST)
    public ModelAndView alterarMotocicleta(@ModelAttribute("motocicleta") @Valid Motocicleta motocicleta,
            BindingResult bindingResult,
            HttpServletRequest request,
            RedirectAttributes attrs) {
        if (bindingResult.hasErrors()) {
            attrs.addFlashAttribute("ano", bindingResult.hasFieldErrors("ano") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("chassi", bindingResult.hasFieldErrors("chassi") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("cor", bindingResult.hasFieldErrors("cor") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("tipoCombustivel", bindingResult.hasFieldErrors("tipoCombustivel") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("valorCompra", bindingResult.hasFieldErrors("valorCompra") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("valorVenda", bindingResult.hasFieldErrors("valorVenda") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("renavam", bindingResult.hasFieldErrors("renavam") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("placa", bindingResult.hasFieldErrors("placa") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("motor", bindingResult.hasFieldErrors("motor") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("valorIPVA", bindingResult.hasFieldErrors("valorIPVA") ? "is-invalid" : "is-valid");

            attrs.addFlashAttribute("motocicleta", motocicleta);
            return new ModelAndView("redirect:/motocicletas/editar/" + motocicleta.getIdMotocicleta());
        } else {
            int idProprietario = Integer.parseInt(request.getParameter("idProprietario"));
            int idModelo = Integer.parseInt(request.getParameter("idModelo"));
            System.err.println("Id modelo alterar: " + idModelo);
            System.err.println("Id proprietario alterar: " + idProprietario);
            Proprietario proprietario = new Proprietario();
            Modelo modelo = new Modelo();
            try {
                proprietario = ProprietarioDAO.retornaProprietarioPorId(idProprietario);
                modelo = ModeloDAO.retornaModeloPorId(idModelo);
                System.err.println("Novo Prop: " + proprietario.getNome());
                motocicleta.setProprietario(proprietario);
                motocicleta.setModelo(modelo);
                MotocicletaDAO.alterarMotocicleta(motocicleta);
            } catch (SQLException ex) {
                Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/motocicletas");
        }

    }

    @RequestMapping(value = "motocicletas/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerMotocicleta(@PathVariable("id") int idMotocicleta) {

        try {
            MotocicletaDAO.removerMotocicleta(idMotocicleta);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/motocicletas");
    }

    @RequestMapping(value = "motocicletas/visualizar/{id}", method = RequestMethod.GET)
    public ModelAndView vidualizarMotocicleta(@PathVariable("id") int idMotocicleta) {
        Motocicleta motocicleta = new Motocicleta();
        try {
            motocicleta = MotocicletaDAO.retornaMotocicletaPorId(idMotocicleta);
        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("motocicletas/VisualizarViewMotocicletas", "motocicleta", motocicleta);
    }
}
