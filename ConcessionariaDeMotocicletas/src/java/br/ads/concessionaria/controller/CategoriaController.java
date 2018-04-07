package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.CategoriaDAO;
import br.ads.concessionaria.domain.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return new ModelAndView("categorias/IndexView");
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
        return new ModelAndView("categorias/VisualizarView", "categoria", c);
    }
}//fim da classe
