/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import br.ads.concessionaria.domain.Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ivens Mathias
 */ 
public class ModeloDAO extends BaseDAO  {
    public static void incluirModelo(Modelo m) throws SQLException {
        openConnection();
        String SQl = "INSERT INTO modelos (nome,descricao,idMarca) VALUES (?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQl);
        stm.setString(1, m.getNome());
        stm.setString(2, m.getDescricao());
        stm.setInt(3, m.getMarca().getIdMarca());
        stm.execute(); 
        //closeConnection();
    }
    
public static void alterarModelo(Modelo m) throws SQLException {
        openConnection();
        String SQl = "UPDATE modelos SET nome = ?, descricao = ?, IdMarca = ? WHERE idModelo = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        System.err.println("Alterando modelo id: " + m.getIdModelo());
        smt.setString(1, m.getNome());
        smt.setString(2, m.getDescricao());
        smt.setInt(3, m.getMarca().getIdMarca());
        smt.setInt(4, m.getIdModelo());
        smt.execute();
        //closeConnection();
    }

    public static ArrayList<Modelo> listarModelos() throws SQLException {
        openConnection();

        ArrayList<Modelo> listaModelos = new ArrayList<>();
        String SQl = "SELECT * FROM modelos";
        PreparedStatement smt = connection.prepareStatement(SQl);
        ResultSet rs = smt.executeQuery();
        while (rs.next()) {
            Modelo m = new Modelo();
            m.setNome(rs.getString("nome"));
            m.setDescricao(rs.getString("descricao"));
            m.setMarca(MarcaDAO.retornarMarcaPorId(rs.getInt("idMarca")));
            m.setIdModelo(rs.getInt("idModelo"));
            listaModelos.add(m);
        }
        //closeConnection();
        return listaModelos;
    }

    public static Modelo retornaModeloPorId(int id) throws SQLException {
        openConnection();
        String SQl = "SELECT * FROM modelos WHERE idModelo = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, id);
        ResultSet rs = smt.executeQuery();
        Modelo m = new Modelo();
        if (rs.first()) {
            m.setNome(rs.getString("nome"));
            m.setDescricao(rs.getString("descricao"));
            m.setIdModelo(rs.getInt("idModelo"));
            m.setMarca(MarcaDAO.retornarMarcaPorId(rs.getInt("idMarca")));
        }

        //closeConnection();
        return m;
    }

    public static void excluirModelo(int idModelo) throws SQLException {
        openConnection();
        ArrayList<Modelo> listaModelo = new ArrayList<>();
        String SQl = "DELETE FROM modelos WHERE idModelo = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, idModelo);
        smt.execute();
        //closeConnection();
    }

    
}

    

