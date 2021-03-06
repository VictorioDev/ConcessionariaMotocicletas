/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.AcessorioDAO;
import br.ads.concessionaria.dao.CategoriaDAO;
import br.ads.concessionaria.dao.CategoriasMotocicletasDAO;
import br.ads.concessionaria.dao.ModeloDAO;
import br.ads.concessionaria.dao.MotocicletaDAO;
import br.ads.concessionaria.dao.MotocicletasAcessoriosDAO;
import br.ads.concessionaria.dao.ProprietarioDAO;
import br.ads.concessionaria.domain.Acessorio;
import br.ads.concessionaria.domain.Categoria;
import br.ads.concessionaria.domain.Modelo;
import br.ads.concessionaria.domain.Motocicleta;
import br.ads.concessionaria.domain.Proprietario;
import br.ads.concessionaria.interfaces.MotocicletaNova;
import br.ads.concessionaria.interfaces.MotocicletaUsada;
import com.sun.org.apache.xpath.internal.axes.AxesWalker;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        ArrayList<Acessorio> listaAcessorios = new ArrayList<>();

        try {
            listaProprietarios = ProprietarioDAO.listarProprietarios("");
            listaModelos = ModeloDAO.listarModelos("");
            listaCategorias = CategoriaDAO.listarCategorias("");
            listaAcessorios = AcessorioDAO.listarAcessorios("");
        } catch (SQLException ex) {
            Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        m.addAttribute("proprietarios", listaProprietarios);
        m.addAttribute("modelos", listaModelos);
        m.addAttribute("categorias", listaCategorias);
        m.addAttribute("acessorios", listaAcessorios);

        return new ModelAndView("motocicletas/CadastrarViewMotocicletas", "motocicleta", motocicleta);
    }

    @RequestMapping(value = "motocicletas/cadastrarUsada", method = RequestMethod.POST)
    public String adicionarMotocicleta(@ModelAttribute("motocicleta") @Validated(MotocicletaUsada.class) Motocicleta m,
            BindingResult bindingResult,
            HttpServletRequest request,
            RedirectAttributes attrs,
            Errors errors) {

        errors.getAllErrors().forEach((t) -> {
            System.out.println(t);
        });

        String[] acessorios = request.getParameterValues("acessorios[]");
        String[] categorias = request.getParameterValues("categorias[]");

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
            attrs.addFlashAttribute("usada", true);
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

                int ultimoId = MotocicletaDAO.retornarUltimoId();

                System.out.println(ultimoId);

                int i = 0;

                // Acessórios
                while (i < acessorios.length) {
                    AcessorioDAO.inserirMotocicletaAcessorio(ultimoId, Integer.parseInt(acessorios[i]));
                    i++;
                }

                i = 0;

                // Categorias
                while (i < categorias.length) {
                    CategoriaDAO.inserirMotocicletaCategoria(ultimoId, Integer.parseInt(categorias[i]));
                    i++;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/motocicletas";
        }
    }

    @RequestMapping(value = "motocicletas/cadastrarNova", method = RequestMethod.POST)
    public String adicionarMotocicletaNova(@ModelAttribute("motocicleta") @Validated(MotocicletaNova.class) Motocicleta m,
            BindingResult bindingResult,
            HttpServletRequest request,
            RedirectAttributes attrs,
            Errors errors) {

        String[] acessorios = request.getParameterValues("acessorios[]");
        String[] categorias = request.getParameterValues("categorias[]");

        if (bindingResult.hasErrors()) {
            attrs.addFlashAttribute("ano", bindingResult.hasFieldErrors("ano") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("chassi", bindingResult.hasFieldErrors("chassi") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("cor", bindingResult.hasFieldErrors("cor") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("tipoCombustivel", bindingResult.hasFieldErrors("tipoCombustivel") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("valorCompra", bindingResult.hasFieldErrors("valorCompra") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("valorVenda", bindingResult.hasFieldErrors("valorVenda") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("motor", bindingResult.hasFieldErrors("motor") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("motocicleta", m);
            attrs.addFlashAttribute("nova", true);
            return "redirect:/motocicletas/cadastrar";
        } else {
            int idProprietario = Integer.parseInt(request.getParameter("idProprietario"));
            int idModelo = Integer.parseInt(request.getParameter("idModelo"));
            Proprietario proprietario = new Proprietario();
            Modelo modelo = new Modelo();

            try {

                proprietario = ProprietarioDAO.retornaProprietarioPorId(idProprietario);
                modelo = ModeloDAO.retornaModeloPorId(idModelo);
                m.setProprietario(null);
                m.setModelo(modelo);
                MotocicletaDAO.incluirMotocicleta(m);

                int ultimoId = MotocicletaDAO.retornarUltimoId();

                int i = 0;

                // Acessórios
                while (i < acessorios.length) {
                    AcessorioDAO.inserirMotocicletaAcessorio(ultimoId, Integer.parseInt(acessorios[i]));
                    i++;
                }

                i = 0;

                // Categorias
                while (i < categorias.length) {
                    CategoriaDAO.inserirMotocicletaCategoria(ultimoId, Integer.parseInt(categorias[i]));
                    i++;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/motocicletas";
        }
    }

    /*@RequestMapping(value = "motocicletas/cadastrar", method = RequestMethod.POST)
    public String adicionarMotocicletaNova(@ModelAttribute("motocicleta") @Valid Motocicleta m,
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

    }*/
    @RequestMapping(value = "motocicletas/editar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable("id") int idMototicleta, Model model) {
        Motocicleta motocicleta = new Motocicleta();

        ArrayList<Modelo> listaModelos = new ArrayList<>();
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        ArrayList<Categoria> listaCategoriasUsadas = new ArrayList<>();
        ArrayList<Acessorio> listaAcessorios = new ArrayList<>();
        ArrayList<Acessorio> listaAcessoriosUsados = new ArrayList<>();

        try {
            listaModelos = ModeloDAO.listarModelos("");
            listaProprietarios = ProprietarioDAO.listarProprietarios("");

            listaCategorias = CategoriaDAO.listarCategorias("");
            listaCategoriasUsadas = CategoriaDAO.retornaCategoriasDaMotocicleta(idMototicleta);
            listaAcessorios = AcessorioDAO.listarAcessorios("");
            listaAcessoriosUsados = AcessorioDAO.retornaAcessoriosDaMotocicleta(idMototicleta);

            motocicleta = MotocicletaDAO.retornaMotocicletaPorId(idMototicleta);
            model.addAttribute("modelos", listaModelos);
            model.addAttribute("proprietarios", listaProprietarios);
            model.addAttribute("categorias", listaCategorias);
            model.addAttribute("acessorios", listaAcessorios);
            model.addAttribute("acessoriosUsados", listaAcessoriosUsados);
            model.addAttribute("categoriasUsadas", listaCategoriasUsadas);

        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("motocicletas/EditarViewMotocicletas", "motocicleta", motocicleta);
    }

    /*@RequestMapping(value = "motocicletas/editar/{id}", method = RequestMethod.POST)
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

    }*/
    @RequestMapping(value = "motocicletas/editarUsada", method = RequestMethod.POST)
    public ModelAndView alterarMotocicletaUsada(@ModelAttribute("motocicleta") @Validated(MotocicletaUsada.class) Motocicleta motocicleta,
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
            String[] acessorios = request.getParameterValues("acessorios[]");
            String[] categorias = request.getParameterValues("categorias[]");
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
                int ultimoId = motocicleta.getIdMotocicleta();
                MotocicletasAcessoriosDAO.removerMotocicletasAcessorios(ultimoId);
                CategoriasMotocicletasDAO.removerCategoriasMotocicletas(ultimoId);
                int i = 0;
                // Acessórios
                while (i < acessorios.length) {
                    AcessorioDAO.inserirMotocicletaAcessorio(ultimoId, Integer.parseInt(acessorios[i]));
                    i++;
                }

                i = 0;

                // Categorias
                while (i < categorias.length) {
                    CategoriaDAO.inserirMotocicletaCategoria(ultimoId, Integer.parseInt(categorias[i]));
                    i++;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/motocicletas");
        }

    }

    @RequestMapping(value = "motocicletas/editarNova", method = RequestMethod.POST)
    public ModelAndView alterarMotocicletaNova(@ModelAttribute("motocicleta") @Validated(MotocicletaNova.class) Motocicleta motocicleta,
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
            attrs.addFlashAttribute("motor", bindingResult.hasFieldErrors("motor") ? "is-invalid" : "is-valid");
            attrs.addFlashAttribute("motocicleta", motocicleta);
            return new ModelAndView("redirect:/motocicletas/editar/" + motocicleta.getIdMotocicleta());
        } else {
            String[] acessorios = request.getParameterValues("acessorios[]");
            String[] categorias = request.getParameterValues("categorias[]");
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

                int ultimoId = motocicleta.getIdMotocicleta();
                MotocicletasAcessoriosDAO.removerMotocicletasAcessorios(ultimoId);
                CategoriasMotocicletasDAO.removerCategoriasMotocicletas(ultimoId);
                int i = 0;
                // Acessórios
                while (i < acessorios.length) {
                    AcessorioDAO.inserirMotocicletaAcessorio(ultimoId, Integer.parseInt(acessorios[i]));
                    i++;
                }

                i = 0;

                // Categorias
                while (i < categorias.length) {
                    CategoriaDAO.inserirMotocicletaCategoria(ultimoId, Integer.parseInt(categorias[i]));
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/motocicletas");
        }

    }

    @RequestMapping(value = "motocicletas/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerMotocicleta(@PathVariable("id") int idMotocicleta, 
            RedirectAttributes attrs) {

        try {
            MotocicletaDAO.removerMotocicleta(idMotocicleta);
        
        }catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ec){
            attrs.addAttribute("hasMsg", true);
            attrs.addAttribute("msg", "Existem itens veiculadoss a esta motocicleta");
            return new ModelAndView("redirect:/motocicletas");
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
