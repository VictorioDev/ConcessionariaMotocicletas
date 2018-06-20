/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.LogDAO;
import br.ads.concessionaria.dao.MarcaDAO;
import br.ads.concessionaria.dao.ModeloDAO;
import br.ads.concessionaria.dao.MotocicletaDAO;
import br.ads.concessionaria.domain.Log;
import br.ads.concessionaria.domain.Marca;
import br.ads.concessionaria.domain.Modelo;
import br.ads.concessionaria.domain.Usuario;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Ivens Mathias
 */
@Controller
public class ModeloController {

    @RequestMapping(value = "modelos", method = RequestMethod.GET)
    public ModelAndView listarModelos(Model m, HttpServletRequest request) {
        String query = request.getParameter("search");
        ArrayList<Modelo> listaModel = new ArrayList<>();
        try {
            listaModel = ModeloDAO.listarModelos(query);
        } catch (SQLException ex) {
            //return new ModelAndView("erro");
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("Tamanho Lista: " + listaModel.size());
        m.addAttribute("modelos", listaModel);
        return new ModelAndView("modelos/IndexViewModelos");
    }

    @RequestMapping(value = "modelos/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(Model m, Modelo modelo) {
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        try {
            listaMarcas = MarcaDAO.listarMarcas("");
            m.addAttribute("marcas", listaMarcas);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("modelos/CadastrarViewModelos", "modelo", modelo);
    }

    @RequestMapping(value = "modelos/cadastrar", method = RequestMethod.POST)
    public String adicionarModelo(@ModelAttribute("modelo") @Valid Modelo m,
            BindingResult bindingResult,
            HttpServletRequest request,
            RedirectAttributes attrs,
            HttpSession session) {
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasFieldErrors("nome")) {
                attrs.addFlashAttribute("nome", "is-invalid");
            } else {
                attrs.addFlashAttribute("nome", "is-valid");
            }

            if (bindingResult.hasFieldErrors("descricao")) {
                attrs.addFlashAttribute("descricao", "is-invalid");
            } else {
                attrs.addFlashAttribute("descricao", "is-valid");
            }

            attrs.addFlashAttribute("modelo", m);

            return "redirect:/modelos/cadastrar";
        } else {
            int idMarca = Integer.parseInt(request.getParameter("idMarca"));
            Marca marca = new Marca();
            try {
                marca = MarcaDAO.retornarMarcaPorId(idMarca);
                m.setMarca(marca);
                ModeloDAO.incluirModelo(m);
                Usuario u = (Usuario) session.getAttribute("usuarioSession");
                Log log = new Log();
                log.setAcao("O modelo " + m.getNome() + " foi cadastrado");
                log.setUsuario(u);
                LogDAO.novoLog(log);
            } catch (SQLException ex) {
                try {
                    Modelo mod = ModeloDAO.retornaModeloPorId(m.getIdModelo());
                    Usuario u = (Usuario) session.getAttribute("usuarioSession");
                    Log log = new Log();
                    log.setAcao("Erro ao cadastrar o modelo " + mod.getNome());
                    log.setUsuario(u);
                    LogDAO.novoLog(log);
                } catch (SQLException ex1) {
                    Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/modelos";
        }

    }

    @RequestMapping(value = "modelos/editar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable("id") int idModelo, Model model) {
        Modelo m = new Modelo();
        System.err.println("Chegou o id " + idModelo);
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        try {
            m = ModeloDAO.retornaModeloPorId(idModelo);
            listaMarcas = MarcaDAO.listarMarcas("");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("marcas", listaMarcas);
        return new ModelAndView("modelos/EditarViewModelos", "modelo", m);
    }

    @RequestMapping(value = "modelos/editar", method = RequestMethod.POST)
    public ModelAndView alterarModelo(@ModelAttribute("modelo") @Valid Modelo m,
            BindingResult bindingResult,
            HttpServletRequest request,
            RedirectAttributes attrs,
            HttpSession session) {
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasFieldErrors("nome")) {
                attrs.addFlashAttribute("nome", "is-invalid");
            } else {
                attrs.addFlashAttribute("nome", "is-valid");
            }

            if (bindingResult.hasFieldErrors("descricao")) {
                attrs.addFlashAttribute("descricao", "is-invalid");
            } else {
                attrs.addFlashAttribute("descricao", "is-valid");
            }

            attrs.addFlashAttribute("modelo", m);

            return new ModelAndView("redirect:/modelos/alterar/" + m.getIdModelo());
        } else {
            int idMarca = Integer.parseInt(request.getParameter("idMarca"));
            Marca marca = new Marca();
            System.out.println("Modelo id " + m.getIdModelo());
            try {
                marca = MarcaDAO.retornarMarcaPorId(idMarca);
                m.setMarca(marca);
                Usuario u = (Usuario) session.getAttribute("usuarioSession");
                Modelo oldModelo = ModeloDAO.retornaModeloPorId(m.getIdModelo());
                ModeloDAO.alterarModelo(m);
                Log log = new Log();
                log.setAcao("O modelo " + oldModelo.getNome() + " foi alterado para " + m.getNome());
                log.setUsuario(u);
                LogDAO.novoLog(log);
            } catch (SQLException ex) {
                try {
                    Usuario u = (Usuario) session.getAttribute("usuarioSession");
                    Log log = new Log();
                    log.setAcao("Erro ao alterar o modelo" + m.getNome());
                    log.setUsuario(u);
                    LogDAO.novoLog(log);
                } catch (SQLException ex1) {
                    Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex1);
                }

                Logger.getLogger(ModeloController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/modelos");
        }

    }

    @RequestMapping(value = "modelos/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerModelo(@PathVariable("id") int idModelo,
            HttpSession session,
            RedirectAttributes attrs) {
        try {
            int total = MotocicletaDAO.contaMotocicletasPorModelo(idModelo);
            Modelo m = ModeloDAO.retornaModeloPorId(idModelo);
            if (total == 0) {
                ModeloDAO.excluirModelo(idModelo);
                Log log = new Log();
                Usuario u = (Usuario) session.getAttribute("usuarioSession");
                log.setAcao("O modelo " + m.getNome() + " foi removido ");
                log.setUsuario(u);
                LogDAO.novoLog(log);
            } else {
                attrs.addFlashAttribute("hasMsg", true);
                attrs.addFlashAttribute("msg", "O modelo " + m.getNome() + " possui motocicletas vinculadas a ele e não poderá ser excluído");
            }

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
        return new ModelAndView("modelos/VisualizarViewModelos", "modelo", modelo);
    }
}
