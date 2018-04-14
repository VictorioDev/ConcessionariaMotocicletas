package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.CategoriaDAO;
import br.ads.concessionaria.domain.Categoria;
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

@Controller
public class CategoriaController {
    
    @RequestMapping("categorias")
    public ModelAndView listarCategorias(Model m){
        ArrayList<Categoria> listarCategorias = new ArrayList<>();
        try {
           listarCategorias = CategoriaDAO.listarCategorias();
        } catch (SQLException ex) {
            //return ...
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        m.addAttribute("categorias", listarCategorias);
        return new ModelAndView("categorias/IndexViewCategorias");
    }
    
    @RequestMapping(value="categorias/visualizar/{id}", method=RequestMethod.GET)
    public ModelAndView visualizarCategorias(@PathVariable("id") int id){
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
    public ModelAndView cadastrar() {
        return new ModelAndView("categorias/CadastrarViewCategorias", "categoria", new Categoria());
    }
    
    @RequestMapping(value = "categorias/cadastrar", method = RequestMethod.POST)
    public String adicionarCategoria(@ModelAttribute("categoria") Categoria c) {
        try {
            CategoriaDAO.incluirCategoria(c);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/categorias";
    }
     
    @RequestMapping(value = "categorias/editar/{id}", method = RequestMethod.GET)
    public ModelAndView editarCategoria( @PathVariable("id") int idCategoria ) {
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
    public ModelAndView editarCategoria(@ModelAttribute("categoria") Categoria c) {
        System.out.println("Categoria id " + c.getIdCategoria());
        try {
            CategoriaDAO.alterarCategoria(c);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/categorias");
    }
        
    @RequestMapping(value = "categorias/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerCategoria(@PathVariable("id") int idCategoria) {
        try {
            CategoriaDAO.removerCategoria(idCategoria);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/categorias");
    }
}//fim da classe
