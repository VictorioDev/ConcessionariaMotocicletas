/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import br.ads.concessionaria.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Victorio Zansavio
 */
public class BaseDAO {
    public static Connection connection;
    
    public static  void openConnection(){
        if(connection == null) connection = ConnectionFactory.getConection();
    }
    
    
      
    public static  void closeConnection() throws SQLException{
        if(connection != null) connection.close();
    }
    
}
