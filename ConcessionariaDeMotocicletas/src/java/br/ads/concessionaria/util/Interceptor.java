/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Victorio Zansavio
 */
public class Interceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("Passou interceptor");
        HttpSession s = request.getSession();
        
        /*System.err.println("URL:" + request.getRequestURI());
        if(s.getAttribute("usuarioSession") == null && !request.getRequestURI().endsWith("login")){
            response.sendRedirect("/ConcessionariaDeMotocicletas/login");
            return false;
        }
        */
        
        return true;
        
//To change body of generated methods, choose Tools | Templates.
    }
    
    
}
