package br.ads.concessionaria.controller;
import br.ads.concessionaria.dao.CategoriaDAO;
import br.ads.concessionaria.dao.LogDAO;
import br.ads.concessionaria.domain.Categoria;
import br.ads.concessionaria.domain.Log;
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

@Controller
public class CategoriaController {

    @RequestMapping("categorias")
    public ModelAndView listarCategorias(Model m, HttpServletRequest request) {
        String query = request.getParameter("search");
        ArrayList<Categoria> listarCategorias = new ArrayList<>();
        try {
            listarCategorias = CategoriaDAO.listarCategorias(query);
        } catch (SQLException ex) {
            //return ...
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("categorias", listarCategorias);
        return new ModelAndView("categorias/IndexViewCategorias");
    }

    @RequestMapping(value = "categorias/visualizar/{id}", method = RequestMethod.GET)
    public ModelAndView visualizarCategorias(@PathVariable("id") int id) {
        Categoria c = new Categoria();
        System.err.println("Id vindo da view: " + id);
        try {
            c = CategoriaDAO.retornarCategoriaPorId(id);
        } catch (SQLException ex) {
            //return ...
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(c.getNome());
        return new ModelAndView("categorias/VisualizarViewCategorias", "categoria", c);
    }

    @RequestMapping(value = "categorias/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar(Categoria c) {
        return new ModelAndView("categorias/CadastrarViewCategorias", "categoria", c);
    }

    @RequestMapping(value = "categorias/cadastrar", method = RequestMethod.POST)
    public String adicionarCategoria(@ModelAttribute("categoria") @Valid Categoria c,
            BindingResult bindingResult,
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

            attrs.addFlashAttribute("categoria", c);
            return "redirect:/categorias/cadastrar";
        } else {
            try {
                CategoriaDAO.incluirCategoria(c);
                Log log = new Log();
                Usuario u = (Usuario) session.getAttribute("usuarioSession");
                log.setAcao("O acessorio " + c.getNome() + " foi cadastrado");
                log.setUsuario(u);
                LogDAO.novoLog(log);
            } catch (SQLException ex) {
                Log log = new Log();
                Usuario u = (Usuario) session.getAttribute("usuarioSession");
                log.setAcao("Erro ao cadastrar o acessorio " + c.getNome());
                log.setUsuario(u);
                try {
                    LogDAO.novoLog(log);
                } catch (SQLException ex1) {
                    Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/categorias";
        }

    }

    @RequestMapping(value = "categorias/editar/{id}", method = RequestMethod.GET)
    public ModelAndView editarCategoria(@PathVariable("id") int idCategoria) {
        Categoria c = new Categoria();
        System.out.println("Chegou o id " + idCategoria);
        try {
            c = CategoriaDAO.retornarCategoriaPorId(idCategoria);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("categorias/EditarViewCategorias", "categoria", c);
    }

    @RequestMapping(value = "categorias/editar", method = RequestMethod.POST)
    public ModelAndView editarCategoria(@ModelAttribute("categoria") @Valid Categoria c,
            BindingResult bindingResult,
            RedirectAttributes attrs,
            HttpSession session) {
        System.out.println("Categoria id " + c.getIdCategoria());
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

            attrs.addFlashAttribute("categoria", c);
            return new ModelAndView("redirect:/categorias/editar/" + c.getIdCategoria());
        } else {
            try {
                CategoriaDAO.alterarCategoria(c);
                Categoria cat = CategoriaDAO.retornarCategoriaPorId(c.getIdCategoria());
                Log log = new Log();
                Usuario u = (Usuario) session.getAttribute("usuarioSession");
                log.setAcao("A categoria " + c.getNome() + " foi alterada para " + cat.getNome());
                log.setUsuario(u);
                LogDAO.novoLog(log);
            } catch (SQLException ex) {

                try {
                    Categoria cat = CategoriaDAO.retornarCategoriaPorId(c.getIdCategoria());
                    Log log = new Log();
                    Usuario u = (Usuario) session.getAttribute("usuarioSession");
                    log.setAcao("Erro ao mudar a categoria " + c.getNome() + "para " + cat.getNome());
                    log.setUsuario(u);
                    LogDAO.novoLog(log);
                } catch (SQLException ex1) {
                    
                    Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ModelAndView("redirect:/categorias");
        }

    }

    @RequestMapping(value = "categorias/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerCategoria(@PathVariable("id") int idCategoria,
            HttpSession session) {
        try {
            Categoria c = CategoriaDAO.retornarCategoriaPorId(idCategoria);
            CategoriaDAO.removerCategoria(idCategoria);
            Log log = new Log();
            Usuario u = (Usuario) session.getAttribute("usuarioSession");
            log.setAcao("A categoria " + c.getNome() + " foi removida");
            log.setUsuario(u);
            LogDAO.novoLog(log);
        } catch (SQLException ex) {
            try {
                Categoria c = CategoriaDAO.retornarCategoriaPorId(idCategoria);
                Log log = new Log();
                Usuario u = (Usuario) session.getAttribute("usuarioSession");
                log.setAcao("Erro ao remover a categoria " + c.getNome());
                log.setUsuario(u);
                LogDAO.novoLog(log);
            } catch (SQLException e) {
                Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/categorias");
    }
}//fim da classe
