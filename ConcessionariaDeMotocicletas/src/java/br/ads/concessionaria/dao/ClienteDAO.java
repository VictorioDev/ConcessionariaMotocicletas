/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import br.ads.concessionaria.domain.Cliente;
import java.sql.Date;
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
        stm.setString(11, "2018-03-01");
        stm.setString(12, "Ativo");

        stm.execute();
    }

    public static void alterarCliente(Cliente c) throws SQLException {
        openConnection();
        String SQl = "UPDATE clientes SET tipo=?, nome = ?, razaoSocial= ?, CPF=?,CNPJ=?,endereco=?,telefone=?,email=?,RG=?,dataNascimento=?,status=? WHERE idCliente = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setString(1, c.getTipo());
        smt.setString(2, c.getNome());
        smt.setString(3, c.getRazaoSocial());
        smt.setString(4, c.getCPF());
        smt.setString(5, c.getCNPJ());
        smt.setString(6, c.getEndereco());
        smt.setString(7, c.getTelefone());
        smt.setString(8, c.getEmail());
        smt.setString(9, c.getRG());
        smt.setDate(10, c.getDataNascimento());
        smt.setString(11, c.getStatus());
         smt.setInt(12, c.getIdCliente());
        smt.execute();
        //closeConnection();
    }

    public static Cliente retornarClientePorId(int id) throws SQLException {
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
            c.setRazaoSocial(rs.getString("razaoSocial"));
            c.setCPF(rs.getString("CPF"));
            c.setCNPJ(rs.getString("CNPJ"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            c.setRG(rs.getString("RG"));
            c.setDataNascimento(rs.getDate("dataNascimento"));
            c.setStatus(rs.getString("status"));
        }
        //closeConnection();
        return c;
    }

    public static ArrayList<Cliente> listarCliente(String busca) throws SQLException {
        openConnection();
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        String SQL;
        PreparedStatement smt;

        busca = ( busca == null || busca.isEmpty() ) ? "" : busca;
         
        SQL = "SELECT * FROM clientes clientes WHERE tipo LIKE '%" + busca + "%' "
                + "OR nome LIKE '%" + busca + "%' "
                + "OR razaoSocial LIKE '%" + busca + "%' " 
                + "OR CPF LIKE '%" + busca + "%'"
                + "OR CNPJ LIKE '%" + busca + "%' "
                + "OR endereco LIKE '%" + busca + "%' "
                + "OR telefone LIKE '%" + busca + "%' "
                + "OR email LIKE '%" + busca + "%' "
                + "OR RG LIKE '%" + busca + "%' "
                + "OR dataNascimento LIKE '%" + busca + "%' "
                + "OR idCliente LIKE '%" + busca + "%' ";               
               
        smt = connection.prepareStatement(SQL);
        ResultSet rs = smt.executeQuery();

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setIdCliente(rs.getInt("idCliente"));
            c.setNome(rs.getString("nome"));
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

            listaCliente.add(c);
        }
        //closeConnection();
        return listaCliente;
    }
    
    public static int contarClientes() throws SQLException{
        int total = 0;
        openConnection();
        String SQL = "SELECT COUNT(*) as total FROM clientes";
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        if(rs.first()){
            total = rs.getInt("total");
        }
        return total;
    }

    public static void removerCliente(Cliente c) throws SQLException {
        openConnection();

        String SQL = "DELETE FROM clientes WHERE idCliente = ?";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setInt(1, c.getIdCliente());

        stm.execute();
    }

}
