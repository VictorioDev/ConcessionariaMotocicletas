package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.FaturaDAO;
import br.ads.concessionaria.domain.Fatura;
import br.ads.concessionaria.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller de vendas.
 * @author Luciano Carvalho
 */
@Controller
public class FaturaController {
    
    @RequestMapping("faturas")
    public ModelAndView faturas( Model m, HttpServletRequest request ){
        
        String query = request.getParameter("search");
        
        ArrayList<Fatura> listaFaturas = new ArrayList<>();
                
        try {
            listaFaturas = FaturaDAO.listarFatura( query );
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.addAttribute("faturas", listaFaturas );
        
        return new ModelAndView("faturas/IndexViewFaturas");
    }
    
    /**
     * Método que carrega os dados de uma fatura para visualização.
     * @param id
     * @return 
     */
    @RequestMapping( value = "faturas/visualizar/{id}", method = RequestMethod.GET )
    public ModelAndView visualizar( @PathVariable("id") int id ) {
        
        Fatura f = new Fatura();
        
        try {
            f = FaturaDAO.retornarFaturaPorId(id);
        } catch( SQLException ex ) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ModelAndView("faturas/VisualizarViewFaturas", "fatura", f );
    }
    
    /**
     * Método para dar baixa em uma fatura.
     * @param id
     * @return 
     */
    @RequestMapping( value = "faturas/baixar/{id}", method = RequestMethod.GET )
    public ModelAndView baixar( @PathVariable("id") int id ) {
                
        Fatura f = new Fatura();
        
        try {
            f = FaturaDAO.retornarFaturaPorId(id);
        } catch( SQLException ex ) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ModelAndView("faturas/BaixarViewFaturas", "fatura", f );
    }

    @RequestMapping( value = "faturas/baixar/{id}", method = RequestMethod.POST )
    public String baixar( HttpServletRequest request, HttpSession session ) throws SQLException {
        
        Usuario u               = (Usuario) session.getAttribute("usuarioSession");
        int idFatura            = Integer.parseInt( request.getParameter("idFatura") );
        String tipoPagamento    = request.getParameter("tipoPagamento");
        double valorPago        = Double.parseDouble( request.getParameter("juros") );
                
        FaturaDAO.baixarFatura( idFatura, tipoPagamento, valorPago, u.getIdUsuario() );
        
        return "redirect:/faturas";
    }
}
