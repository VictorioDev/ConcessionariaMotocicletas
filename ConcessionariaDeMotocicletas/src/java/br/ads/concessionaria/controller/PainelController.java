package br.ads.concessionaria.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller padrão do sistema
 * @author Luciano Carvalho
 */
@Controller
public class PainelController {
        
    @RequestMapping( value = { "/index", "/painel" } )
    public String painel( Model m ) {
        
        m.addAttribute("nome", "Usuário");
        m.addAttribute("qtdMotocicletas", 0 );
        m.addAttribute("qtdProprietarios", 0 );
        m.addAttribute("qtdUsuarios", 0 );
        m.addAttribute("qtdClientes", 0 );
        m.addAttribute("qtdVendas", 0 );
        m.addAttribute("qtdFaturas", 0 );
        
        return "IndexView";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "LoginView";
    }
}
