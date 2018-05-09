package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.ClienteDAO;
import br.ads.concessionaria.dao.FaturaDAO;
import br.ads.concessionaria.dao.MotocicletaDAO;
import br.ads.concessionaria.dao.ProprietarioDAO;
import br.ads.concessionaria.dao.UsuarioDAO;
import br.ads.concessionaria.dao.VendaDAO;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller padrão do sistema
 *
 * @author Luciano Carvalho
 */
@Controller
public class PainelController {

    @RequestMapping(value = {"/index", "/painel"})
    public String painel( Model m ) {
       
        try {
            m.addAttribute("qtdUsuarios", UsuarioDAO.contarUsuarios() );
            m.addAttribute("qtdMotocicletas", MotocicletaDAO.contarMotocicletas() );
            m.addAttribute("qtdClientes", ClienteDAO.contarClientes() );
            m.addAttribute("qtdProprietarios", ProprietarioDAO.contarProprietarios() );
            m.addAttribute("qtdVendas", VendaDAO.contarVendas() );
            m.addAttribute("qtdFaturas", FaturaDAO.contarFaturas() );
        } catch (SQLException ex) {
            Logger.getLogger(PainelController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "painel/IndexViewPainel";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "LoginView";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session, Model m ) {

        Usuario u = new Usuario();

        try {

            u = UsuarioDAO.retornarUsuarioPorLogin(
                    request.getParameter("login"),
                    request.getParameter("senha")
            );

            if (u != null) {
                session.setAttribute("usuarioSession", u);
            } else {
                m.addAttribute("login", "is-invalid");
                m.addAttribute("senha", "is-invalid");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (u != null) ? "redirect:/painel" : "LoginView";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("usuarioSession");
        return "redirect:/login";
    }
}
