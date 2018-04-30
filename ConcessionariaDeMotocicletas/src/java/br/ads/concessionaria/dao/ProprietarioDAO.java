/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import br.ads.concessionaria.domain.Proprietario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victorio Zansavio
 */
public class ProprietarioDAO extends BaseDAO {

    public static void incluirProprietario(Proprietario p) throws SQLException {
        openConnection();
        String SQl = "INSERT INTO proprietarios (tipo,nome,razaoSocial,rg,cpf,cnpj,endereco,telefone,email,dataNascimento,cartorio) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setString(1, p.getTipo());
        smt.setString(2, p.getNome());
        smt.setString(3, p.getRazaoSocial());
        smt.setString(4, p.getRg());
        smt.setString(5, p.getCpf());
        smt.setString(6, p.getCnpj());
        smt.setString(7, p.getEndereco());
        smt.setString(8, p.getTelefone());
        smt.setString(9, p.getEmail());
        smt.setDate(10, p.getDataNascimento());
        smt.setString(11, p.getCartorio());
        smt.execute();
        //closeConnection();
    }

    public static ArrayList<Proprietario> retornaProprietarioPorNome(String busca) {
        openConnection();
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        String SQL = "SELECT * FROM proprietarios where nome like '" + busca + "%' ";
        System.out.println(SQL);
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proprietario p = new Proprietario();
                p.setTipo(rs.getString("tipo"));
                p.setNome(rs.getString("nome"));
                p.setRazaoSocial(rs.getString("razaoSocial"));
                p.setRg(rs.getString("RG"));
                p.setCpf(rs.getString("CPF"));
                p.setCnpj(rs.getString("CNPJ"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setEmail(rs.getString("email"));
                p.setDataNascimento(rs.getDate("dataNascimento"));
                p.setCartorio(rs.getString("cartorio"));
                p.setIdProprietario(rs.getInt("idProprietario"));
                listaProprietarios.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProprietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProprietarios;
    }
    
    
    public static int contarProprietarios() throws SQLException {
        int total = 0;
        openConnection();
        String SQL = "SELECT COUNT(*) as total FROM proprietarios";
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        if (rs.first()) {
            total = rs.getInt("total");
        }
        return total;
    }

    public static void alterarProprietario(Proprietario p) throws SQLException {
        openConnection();
        String SQl = "UPDATE proprietarios SET tipo = ?, nome = ?, razaoSocial = ?, rg = ?, cpf = ?, cnpj = ?, endereco = ?,"
                + " telefone = ?, email = ?, dataNascimento = ?, cartorio = ? WHERE idProprietario = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        System.err.println("Alterando proprietario id: " + p.getIdProprietario());
        smt.setString(1, p.getTipo());
        smt.setString(2, p.getNome());
        smt.setString(3, p.getRazaoSocial());
        smt.setString(4, p.getRg());
        smt.setString(5, p.getCpf());
        smt.setString(6, p.getCnpj());
        smt.setString(7, p.getEndereco());
        smt.setString(8, p.getTelefone());
        smt.setString(9, p.getEmail());
        smt.setDate(10, p.getDataNascimento());
        smt.setString(11, p.getCartorio());
        smt.setInt(12, p.getIdProprietario());
        smt.execute();
        //closeConnection();
    }

    public static ArrayList<Proprietario> listarProprietarios(String busca) throws SQLException {
        openConnection();

        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        String SQL;
        PreparedStatement smt;
        
        if (busca != null) {
            if (busca.isEmpty()) {
                SQL = "SELECT * FROM proprietarios";
                smt = connection.prepareStatement(SQL);  
            }else {
                SQL = "SELECT * FROM proprietarios WHERE tipo like '%" + busca + "%' "
                + "or nome like '%" + busca + "%' "
                + "or razaoSocial like '%" + busca + "%' "
                + "or rg like '%" + busca + "%' "
                + "or cpf like '%" + busca + "%' "
                + "or cnpj like '%" + busca + "%' "
                + "or endereco like '%" + busca + "%' "
                + "or telefone like '%" + busca + "%' "
                + "or email like '%" + busca + "%' "
                + "or dataNascimento like '%" + busca + "%' "
                + "or cartorio like '%" + busca + "%' "
                + "or idProprietario like '%" + busca + "%'";
                smt = connection.prepareStatement(SQL);
            }
        } else {
            SQL = "SELECT * FROM proprietarios";
            smt = connection.prepareStatement(SQL);
        }
        
        System.err.println("SQL: \n" + SQL);
        ResultSet rs = smt.executeQuery();

        while (rs.next()) {
            Proprietario p = new Proprietario();
            p.setTipo(rs.getString("tipo"));
            p.setNome(rs.getString("nome"));
            p.setRazaoSocial(rs.getString("razaoSocial"));
            p.setRg(rs.getString("RG"));
            p.setCpf(rs.getString("CPF"));
            p.setCnpj(rs.getString("CNPJ"));
            p.setEndereco(rs.getString("endereco"));
            p.setTelefone(rs.getString("telefone"));
            p.setEmail(rs.getString("email"));
            p.setDataNascimento(rs.getDate("dataNascimento"));
            p.setCartorio(rs.getString("cartorio"));
            p.setIdProprietario(rs.getInt("idProprietario"));
            listaProprietarios.add(p);
        }
        //closeConnection();
        return listaProprietarios;
    }

    public static Proprietario retornaProprietarioPorId(int id) throws SQLException {
        openConnection();
        String SQl = "SELECT * FROM proprietarios WHERE idProprietario = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, id);
        ResultSet rs = smt.executeQuery();
        Proprietario p = new Proprietario();
        if (rs.first()) {
            p.setTipo(rs.getString("tipo"));
            p.setNome(rs.getString("nome"));
            p.setRazaoSocial(rs.getString("razaoSocial"));
            p.setRg(rs.getString("RG"));
            p.setCpf(rs.getString("CPF"));
            p.setCnpj(rs.getString("CNPJ"));
            p.setEndereco(rs.getString("endereco"));
            p.setTelefone(rs.getString("telefone"));
            p.setEmail(rs.getString("email"));
            p.setDataNascimento(rs.getDate("dataNascimento"));
            p.setCartorio(rs.getString("cartorio"));
            p.setIdProprietario(rs.getInt("idProprietario"));
        }

        //closeConnection();
        return p;
    }

    public static void excluirProprietario(int idProprietario) throws SQLException {
        openConnection();
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        String SQl = "DELETE FROM proprietarios WHERE idProprietario = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, idProprietario);
        smt.execute();
        //closeConnection();
    }

    public static void main(String[] args) {
        ArrayList<Proprietario> listaProp = ProprietarioDAO.retornaProprietarioPorNome("V");
        for (Proprietario p : listaProp) {
            System.err.println(p.getNome());
        }
    }
}
