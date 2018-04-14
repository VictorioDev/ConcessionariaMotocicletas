/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victorio Zansavio
 */
public class ConnectionFactory {
    public static Connection getConection(){
      try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sistemaconcessionaria", "root", "");
        } catch (SQLException e) {
            System.err.println("Deu pau");
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        ConnectionFactory.getConection();
    }
    
}
