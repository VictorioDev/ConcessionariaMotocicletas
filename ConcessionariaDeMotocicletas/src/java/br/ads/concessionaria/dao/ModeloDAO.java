/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import static br.ads.concessionaria.dao.BaseDAO.closeConnection;
import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import br.ads.concessionaria.domain.Modelo;
import br.ads.concessionaria.domain.Motocicleta;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Victorio Zansavio
 */
public class ModeloDAO {
    public static void incluirModelo(Modelo m) throws SQLException {
        openConnection();
        String SQl = "INSERT INTO modelos (nome,descricao,idMarca) values (?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQl);
        stm.setString(1, m.getNome());
        stm.setString(2, m.getDescricao());
        stm.setInt(3, m.getMarca().getIdMarca());
        stm.execute();      
    }
    
    
}
