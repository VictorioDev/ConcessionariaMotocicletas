/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Victorio Zansavio
 */
public class MotocicletasAcessoriosDAO extends BaseDAO{
    
    public static void removerMotocicletasAcessorios(int idMotocicleta) throws SQLException{
        openConnection();
        String SQL = "DELETE motocicletasacessorios FROM motocicletasacessorios WHERE idMotocicleta = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setInt(1, idMotocicleta);
        stm.execute();
    }
}
