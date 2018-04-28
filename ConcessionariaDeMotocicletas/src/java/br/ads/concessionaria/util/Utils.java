/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.util;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Victorio Zansavio
 */
public class Utils {
    public static String changeCharset(String s){
        try {
            return new String(s.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
    
    public static String activeMenu(String module, String url){
        String parts[] = url.split("/");
        for(int i = 0; i < parts.length; i++){
            System.out.println(parts[i]);
            if(parts[i].trim().equalsIgnoreCase(module)) return "selected";
        }
        return "";
    }
}