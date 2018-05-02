/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.controller;

import br.ads.concessionaria.dao.MarcaDAO;
import br.ads.concessionaria.dao.ModeloDAO;
import br.ads.concessionaria.domain.Marca;
import br.ads.concessionaria.domain.Modelo;
import java.sql.SQLException;
import java.util.ArrayList;
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
}
