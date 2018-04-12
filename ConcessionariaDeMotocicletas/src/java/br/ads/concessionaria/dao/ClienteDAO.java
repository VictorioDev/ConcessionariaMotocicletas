/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import static br.ads.concessionaria.dao.BaseDAO.closeConnection;
import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import br.ads.concessionaria.domain.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Smania
 */
public class ClienteDAO {
    
    public static void incluirCliente(Cliente c) throws SQLException {
        openConnection();
        String SQl = "INSERT INTO clientes (tipo,nome,razaoSocial,CPF,CNPJ,endereco,telefone,email,RG,dataNascimento,dataCadastro,status) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQl);
        stm.setString(1, c.getTipo());
        stm.setString(2, c.getNome());
        stm.setString(3, c.getRazaoSocial());
        stm.setString(4, c.getCPF());
        stm.setString(5, c.getCNPJ());
        stm.setString(6, c.getEndereco());
        stm.setString(7, c.getTelefone());
        stm.setString(8, c.getEmail());
        stm.setString(9, c.getRG());
        stm.setDate(10, c.getDataNascimento());
        stm.setDate(11, c.getDataCadastro());
        stm.setString(12, c.getStatus());
  
        stm.execute();
    }

    public static void alterarCliente(Cliente c) throws SQLException {
        openConnection();
        String SQl = "UPDATE clientes SET nome = ?, razaoSocial= ?, CPF=?,CNPJ=?,endereco=?,telefone=?,email=?,RG=?,dataNascimento=?,dataCadastro=?,status=? WHERE idCliente = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setString(1, c.getNome());
        smt.setString(3, c.getRazaoSocial());
        smt.setString(4, c.getCPF());
        smt.setString(5, c.getCNPJ());
        smt.setString(6, c.getEndereco());
        smt.setString(7, c.getTelefone());
        smt.setString(8, c.getEmail());
        smt.setString(9, c.getRG());
        smt.setDate(10, c.getDataNascimento());
        smt.setDate(11, c.getDataCadastro());
        smt.setString(12, c.getStatus());
        smt.execute();
        //closeConnection();
    }

    public static ArrayList<Cliente> listarCliente() throws SQLException {
        openConnection();
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        String SQL = "SELECT * FROM clientes";
        PreparedStatement smt = connection.prepareStatement(SQL);
        ResultSet rs = smt.executeQuery();
         
        while (rs.next()) {   
            Cliente c = new Cliente();
            c.setIdCliente(rs.getInt("idCliente"));
            c.setTipo(rs.getString("tipo"));
            c.setRazaoSocial(rs.getString("razaoSocial"));
            c.setCPF(rs.getString("CPF"));
            c.setCNPJ(rs.getString("CNPJ"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            c.setRG(rs.getString("RG"));
            c.setDataNascimento(rs.getDate("dataNascimento"));
            c.setDataCadastro(rs.getDate("dataCadastro"));
            c.setStatus(rs.getString("status"));
            
            listarCliente().add(c);
        }
        //closeConnection();
        return listaCliente;
    }
    
    
     public static Cliente retornarClienteporid(int id) throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM clientes WHERE idCliente = ?";
        PreparedStatement smt = connection.prepareStatement(SQL);
        smt.setInt(1, id);
        ResultSet rs = smt.executeQuery();
         Cliente c = new Cliente();
        if (rs.first()) {   
            c.setIdCliente(rs.getInt("idCliente"));
            c.setNome(rs.getString("nome"));
            c.setTipo(rs.getString("tipo"));
        }
        //closeConnection();
        return c;
    }
    
    public static void excluirCliente(int idCliente) throws SQLException {
        openConnection();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String SQl = "DELETE FROM clientes WHERE iCliente = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, idCliente);
        smt.execute();
        //closeConnection();
    }
    
}
