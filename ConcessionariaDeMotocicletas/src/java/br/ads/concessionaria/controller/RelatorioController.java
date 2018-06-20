/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.FaturaDAO;
import br.ads.concessionaria.dao.LogDAO;
import br.ads.concessionaria.dao.MarcaDAO;
import br.ads.concessionaria.dao.ModeloDAO;
import br.ads.concessionaria.dao.MotocicletaDAO;
import br.ads.concessionaria.dao.VendaDAO;
import br.ads.concessionaria.domain.Fatura;
import br.ads.concessionaria.domain.Log;
import br.ads.concessionaria.domain.Marca;
import br.ads.concessionaria.domain.Modelo;
import br.ads.concessionaria.domain.Motocicleta;
import br.ads.concessionaria.domain.Venda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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

/**
 * Controller dos relatórios
 * @author Luciano Carvalho
 */
@Controller
public class RelatorioController {

    @RequestMapping(value = "relatorios", method = RequestMethod.GET)
    public ModelAndView index(Model m) {
        return new ModelAndView("relatorios/IndexViewRelatorios");
    }
       
    @RequestMapping(value = "relatorios", method = RequestMethod.POST)
    public ModelAndView visualizar( HttpServletRequest request, Model m ) throws SQLException {
        
        // Pegamos o tipo do relatório que o usuário selecionou.
        String tipo = request.getParameter("tipo");
                
        String[] splitInicio = request.getParameter("dataInicio").split("-");
        String[] splitFinal = request.getParameter("dataFinal").split("-");
                
        String dataInicio = ( splitInicio.length > 1 ) ? splitInicio[2] + "/" + splitInicio[1] + "/" + splitInicio[0] : "Desde o início";
        String dataFinal = ( splitFinal.length > 1 ) ? splitFinal[2] + "/" + splitFinal[1] + "/" + splitFinal[0] : "o final";
        
        m.addAttribute("dataInicio", dataInicio );
        m.addAttribute("dataFinal", dataFinal );
                
        // Relatório de vendas.
        if( tipo.equals("vendas") ) {
            ArrayList<Venda> listaVendas = new ArrayList<>();
            listaVendas = VendaDAO.listarVenda("", request.getParameter("dataInicio"), request.getParameter("dataFinal") );
            m.addAttribute("vendas", listaVendas );
            return new ModelAndView("relatorios/RelatorioVendas");
        }
        
        // Relatório de pagamentos.
        if( tipo.equals("pagamentos") ) {
            ArrayList<Fatura> listaPagamentos = new ArrayList<>();
            listaPagamentos = FaturaDAO.listarPagamentos( request.getParameter("dataInicio"), request.getParameter("dataFinal") );
            m.addAttribute("pagamentos", listaPagamentos );
            return new ModelAndView("relatorios/RelatorioPagamentos");
        }
        
        // Relatório de itens mais vendidos.
        if( tipo.equals("itens-mais-vendidos") ) {
            ArrayList<Map> itens = MotocicletaDAO.listarMaisVendidos();
            m.addAttribute("itens", itens );
            return new ModelAndView("relatorios/RelatorioItensMaisVendidos");
        }
        
        // Relatório de estoque.
        if( tipo.equals("estoque") ) {
            ArrayList<Motocicleta> estoque = MotocicletaDAO.listarEstoque();
            m.addAttribute("estoques", estoque );
            return new ModelAndView("relatorios/RelatorioConsultasEstoque");
        }
        
        // Relatório de logs.
        if( tipo.equals("logs") ) {
            ArrayList<Log> logs = LogDAO.listarLogs();
            m.addAttribute("logs", logs );
            return new ModelAndView("relatorios/RelatorioLogs");
        }
        
        return null;
    }
}
