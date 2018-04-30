/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import static br.ads.concessionaria.dao.BaseDAO.closeConnection;
import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import br.ads.concessionaria.domain.Marca;
import br.ads.concessionaria.domain.Modelo;
import br.ads.concessionaria.domain.Motocicleta;
import br.ads.concessionaria.domain.Proprietario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victorio Zansavio
 */
public class MarcaDAO {

    public static void incluirMarca(Marca m) throws SQLException {
        openConnection();
        String SQl = "INSERT INTO marcas (nome,descricao) values (?,?)";
        PreparedStatement stm = connection.prepareStatement(SQl);
        stm.setString(1, m.getNome());
        stm.setString(2, m.getDescricao());
        stm.execute();
    }

    public static void alterarMarca(Marca m) throws SQLException {
        openConnection();
        String SQl = "UPDATE marcas SET nome = ?, descricao= ? WHERE idMarca = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setString(1, m.getNome());
        smt.setString(2, m.getDescricao());
        smt.setInt(3, m.getIdMarca());
        smt.execute();
        //closeConnection();
    }

    public static ArrayList<Marca> listarMarcas(String busca) throws SQLException {
        openConnection();
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        String SQL;
        PreparedStatement smt;
        if (busca != null){
            if(busca.isEmpty()){
                SQL = "SELECT * FROM marcas";
                smt = connection.prepareStatement(SQL);
                System.err.println("Busca empty");
            }else {
                SQL = "SELECT * FROM marcas WHERE nome LIKE '%" + busca + "%'";
                smt = connection.prepareStatement(SQL);
                System.err.println("Busca: " + busca);
            }        

        }else {
            SQL = "SELECT * FROM marcas";
            smt = connection.prepareStatement(SQL);
            System.err.println("Busca Null");
        }
       
        ResultSet rs = smt.executeQuery();
         
        while (rs.next()) {   
            Marca m = new Marca();
            m.setIdMarca(rs.getInt("idMarca"));
            m.setNome(rs.getString("nome"));
            m.setDescricao(rs.getString("descricao"));
            listaMarcas.add(m);
        }
        //closeConnection();
        return listaMarcas;
    }
    
    
     public static Marca retornarMarcaPorId(int id) throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM marcas WHERE idMarca = ?";
        PreparedStatement smt = connection.prepareStatement(SQL);
        smt.setInt(1, id);
        ResultSet rs = smt.executeQuery();
         Marca m = new Marca();
        if (rs.first()) {   
            m.setIdMarca(rs.getInt("idMarca"));
            m.setNome(rs.getString("nome"));
            m.setDescricao(rs.getString("descricao"));
        }
        //closeConnection();
        return m;
    }
    
    public static void excluirMarca(int idMarca) throws SQLException {
        openConnection();
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        String SQl = "DELETE FROM marcas WHERE idMarca = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, idMarca);
        smt.execute();
        //closeConnection();
    }
    
    public static int contarMarcas() throws SQLException{
        int total = 0;
        openConnection();
        String SQL = "SELECT COUNT(*) as total FROM marcas";
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        if(rs.first()){
            total = rs.getInt("total");
        }
        return total;
    }


    
}
