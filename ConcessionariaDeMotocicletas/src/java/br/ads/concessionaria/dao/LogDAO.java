/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import br.ads.concessionaria.domain.Log;
import br.ads.concessionaria.domain.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victorio Zansavio
 */
public class LogDAO extends BaseDAO{
    
    public static void novoLog(Log l) throws SQLException{
        openConnection();
        String SQL = "INSERT INTO logs (acao, data, idUsuario) VALUES (?,CURDATE(),?)";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setString(1, l.getAcao());
        stm.setInt(2, l.getUsuario().getIdUsuario());
        stm.execute();
    }
    
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setIdUsuario(1);
        try {
            LogDAO.novoLog(new Log("Cadastrando usuario", u));
        } catch (SQLException ex) {
            Logger.getLogger(LogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
