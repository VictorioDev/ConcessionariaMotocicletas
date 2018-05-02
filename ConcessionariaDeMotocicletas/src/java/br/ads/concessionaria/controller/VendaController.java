package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.ClienteDAO;
import br.ads.concessionaria.dao.FaturaDAO;
import br.ads.concessionaria.dao.MotocicletaDAO;
import br.ads.concessionaria.dao.VendaDAO;
import br.ads.concessionaria.domain.Cliente;
import br.ads.concessionaria.domain.Fatura;
import br.ads.concessionaria.domain.Motocicleta;
import br.ads.concessionaria.domain.Usuario;
import br.ads.concessionaria.domain.Venda;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller de vendas.
 * @author Luciano Carvalho
 */
@Controller
public class VendaController {
    
    @RequestMapping("vendas")
    public ModelAndView vendas( Model m ){
        
        ArrayList<Venda> listaVendas = new ArrayList<>();
                
        try {
            listaVendas = VendaDAO.listarVenda();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.addAttribute("vendas", listaVendas );
        
        return new ModelAndView("vendas/IndexView");
    }
    
    
    /**
     * Método que carrega os dados de uma venda para visualização.
     * @param id
     * @return 
     */
    @RequestMapping( value = "vendas/visualizar/{id}", method = RequestMethod.GET )
    public ModelAndView visualizar( @PathVariable("id") int id ) {
        
        Venda v = new Venda();
        
        try {
            v = VendaDAO.retornarVendaPorId(id);
        } catch( SQLException ex ) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ModelAndView("vendas/VisualizarView", "venda", v );
    }
    
    /**
     * Método para exibir o formulário de cadastro.
     * @return 
     */
    @RequestMapping(value = "/vendas/cadastrar", method = RequestMethod.GET )
    public ModelAndView cadastrar( Model m ) throws SQLException {
        
        ArrayList<Motocicleta> listaMotocicletas = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        try {
            listaMotocicletas = MotocicletaDAO.listarMotocicletas("");
            listaClientes = ClienteDAO.listarCliente("");
        } catch (SQLException ex) {
            Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.addAttribute("motocicletas", listaMotocicletas );
        m.addAttribute("clientes", listaClientes );
        
        return new ModelAndView("vendas/CadastrarView", "venda", new Venda() );
    }
    
    /**
     * Método que recebe o formulário para cadastrar uma venda.
     * @param v
     * @param request
     * @return 
     */
    @RequestMapping(value = "/vendas/cadastrar", method = RequestMethod.POST )
    public String cadastrar( @ModelAttribute("venda") Venda v, HttpServletRequest request, HttpSession session ) throws ParseException {
     
        int idCliente = Integer.parseInt( request.getParameter("idCliente") );
        int idMotocicleta = Integer.parseInt( request.getParameter("idMotocicleta") );
        
        boolean personalizarValor = ( request.getParameter("personalizarValor") == null ) ? false : true;
        
        Usuario u = (Usuario) session.getAttribute("usuarioSession");
        Cliente c = new Cliente();
        Motocicleta m = new Motocicleta();
                
        try {
            c = ClienteDAO.retornarClientePorId( idCliente );
            m = MotocicletaDAO.retornaMotocicletaPorId( idMotocicleta );
            
            v.setCliente( c );
            v.setMotocicleta( m );
            v.setUsuario( u );
            
            if( personalizarValor ) {
                v.setValor( Double.parseDouble( request.getParameter("valor") ) );
            } else {
                v.setValor( m.getValorVenda() );
            }
            
            v.setStatus("Concluída");
                        
            int idVenda = VendaDAO.incluirVenda( v );
            
            // TO DO: Dar baixa na motocicleta.
            
            // Adicionamos um mês na data atual para a geração das faturas.
            // Ou seja, todas as faturas são jogadas para um mês à frente.
            // O DateFormat vai nos auxiliar a formatar as datas.
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            
            Calendar cal = Calendar.getInstance();
            
            Date dataEmissao = new Date( fmt.parse( fmt.format( cal.getTime() ) ).getTime() );
            
            // Já adicionamos um mês antes da geração das faturas.
            cal.add( Calendar.MONTH, 1 );
            
            // Mudamos a data da fatura para o dia preferencial.
            cal.set( Calendar.DAY_OF_MONTH, v.getDiaPreferencial() );
            
            int i = 1;
            
            while( i <= v.getQuantidadeParcelas() ) {
                
                Fatura f = new Fatura();
                
                // Puxamos a data de vencimento.
                Date dataVencimento = new Date( fmt.parse( fmt.format( cal.getTime() ) ).getTime() );
                
                f.setDataEmissao( dataEmissao );
                f.setDataVencimento( dataVencimento );
                f.setNumeroParcela( i );
                f.setValorParcela( v.getValor() / v.getQuantidadeParcelas() );
                f.setStatus("Não paga");
                f.setVenda( VendaDAO.retornarVendaPorId( idVenda ) );
                                
                FaturaDAO.incluirFatura(f);
                
                // Adicionamos mais um mês para continuar o ciclo.
                cal.add( Calendar.MONTH, 1 );
                
                i++;
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(MotocicletaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "redirect:/vendas";
    }
    
    /**
     * Método para cancelar uma venda.
     * @param id
     * @return 
     */
    @RequestMapping( value = "vendas/cancelar/{id}", method = RequestMethod.GET )
    public String cancelar( @PathVariable("id") int id ) throws SQLException {
        
        // Alteramos o status da venda para cancelada.
        VendaDAO.cancelarVenda(id);
        
        // Excluímos todas as faturas.
        FaturaDAO.excluirFaturasVenda(id);
        
        // TO DO: retornamos a motocicleta para em estoque.
        
        return "redirect:/vendas";
    }
}
