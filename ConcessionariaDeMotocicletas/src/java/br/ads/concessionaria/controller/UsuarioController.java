package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.UsuarioDAO;
import br.ads.concessionaria.domain.Usuario;
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
 * Controller de Usuários
 * @author Luciano Carvalho
 */
@Controller
public class UsuarioController {
    
    /**
     * Método pricipal que lista todos os usuários do sistema.
     * @param m
     * @return 
     */
    @RequestMapping("usuarios")
    public ModelAndView usuarios( Model m ) {
        
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
                
        try {
            listaUsuarios = UsuarioDAO.listarUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.addAttribute("usuarios", listaUsuarios );
        
        return new ModelAndView("usuarios/IndexView");
    }
    
    /**
     * Método que carrega os dados do usuário para visualização.
     * @param id
     * @return 
     */
    @RequestMapping( value = "usuarios/visualizar/{id}", method = RequestMethod.GET )
    public ModelAndView visualizar( @PathVariable("id") int id ) {
        
        Usuario u = new Usuario();
        
        try {
            u = UsuarioDAO.retornarUsuarioPorId(id);
        } catch( SQLException ex ) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ModelAndView("usuarios/VisualizarView", "usuario", u );
    }
    
    /**
     * Método para exibir o formulário de cadastro.
     * @return 
     */
    @RequestMapping(value = "/usuarios/cadastrar", method = RequestMethod.GET )
    public ModelAndView cadastrar() {
        return new ModelAndView("usuarios/CadastrarView", "usuario", new Usuario() );
    }
    
    /**
     * Método que recebe o envio do formulário de cadastro.
     * @param u
     * @return 
     */
    @RequestMapping(value = "/usuarios/cadastrar", method = RequestMethod.POST )
    public String cadastrar( @ModelAttribute("usuario") Usuario u ) {
        try {
            UsuarioDAO.incluirUsuario( u );
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "redirect:/usuarios";
    }
    
    /**
     * Método para carregar o formulário de edição de um usuário.
     * @param id
     * @return 
     */
    @RequestMapping( value = "usuarios/editar/{id}", method = RequestMethod.GET )
    public ModelAndView editar( @PathVariable("id") int id ) {        
        
        Usuario u = new Usuario();
        
        try {
            u = UsuarioDAO.retornarUsuarioPorId( id );    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ModelAndView("usuarios/EditarView", "usuario", u );
    }
    
    /**
     * Método que recebe a requisição de edição de um usuário.
     * @param u
     * @return 
     */    
    @RequestMapping( value = "usuarios/editar/{id}", method = RequestMethod.POST )
    public String editar( @ModelAttribute("usuario") Usuario u ) {
       
        try {
            UsuarioDAO.alterarUsuario( u );
        } catch( SQLException ex ) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "redirect:/usuarios";
    }
    
    /**
     * Método para remover um usuário do sistema.
     * @param id
     * @return 
     */
    @RequestMapping( value = "usuarios/remover/{id}", method = RequestMethod.GET )
    public String remover( @PathVariable("id") int id ) {
        
        Usuario u = new Usuario();
        u.setIdUsuario( id );
        
        try {
            UsuarioDAO.removerUsuario( u );
        } catch( SQLException ex ) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "redirect:/usuarios";
    }
}