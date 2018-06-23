/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Victorio Zansavio
 */
public class CategoriasMotocicletasDAO extends BaseDAO {

    public static void removerCategoriasMotocicletas(int idMotocicleta) throws SQLException {
        openConnection();
        String SQL = "DELETE categoriasmotocicletas FROM categoriasmotocicletas WHERE idMotocicleta = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setInt(1, idMotocicleta);
        stm.execute();
    }
}
