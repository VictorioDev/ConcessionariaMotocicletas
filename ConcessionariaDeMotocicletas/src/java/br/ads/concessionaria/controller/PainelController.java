package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.UsuarioDAO;
import br.ads.concessionaria.domain.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller padrão do sistema
 * @author Luciano Carvalho
 */
@Controller
public class PainelController {
        
    @RequestMapping( value = { "/index", "/painel" } )
    public String painel( Model m ) {
        
        m.addAttribute("qtdMotocicletas", 0 );
        m.addAttribute("qtdProprietarios", 0 );
        m.addAttribute("qtdUsuarios", 0 );
        m.addAttribute("qtdClientes", 0 );
        m.addAttribute("qtdVendas", 0 );
        m.addAttribute("qtdFaturas", 0 );
        
        return "IndexView";
    }
    
    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String login() {
        return "LoginView";
    }
    
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public String login( HttpServletRequest request, HttpSession session ) {
        
        Usuario u = new Usuario();
        
        try {
            
            u = UsuarioDAO.retornarUsuarioPorLogin(
                   request.getParameter("login"),
                   request.getParameter("senha")
            );
                        
            if( u != null ) {
                session.setAttribute("usuarioSession", u );
            }
           
        } catch( SQLException ex ) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ( u != null ) ? "redirect:/painel" : "LoginView";
    }
    
    @RequestMapping( value = "/logout", method= RequestMethod.GET )
    public String logout( HttpSession session ) {
        session.removeAttribute("usuarioSession");
        return "redirect:/login";
    }
}
