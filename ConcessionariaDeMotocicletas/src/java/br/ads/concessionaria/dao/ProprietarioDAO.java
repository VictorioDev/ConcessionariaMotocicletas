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
        closeConnection();
    }

    public static void alterarProprietario(Proprietario p) throws SQLException {
        openConnection();
        String SQl = "UPDATE proprietarios SET tipo = ?, nome = ?, razaoSocial = ?, rg = ?, cpf = ?, cnpj = ?, endereco = ?,"
                + " telefone = ?, email = ?, dataNascimento = ?, cartorio = ? WHERE idProprietario = ?";
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
        smt.setInt(12, p.getIdProprietario());
        smt.execute();
        closeConnection();
    }

    public static ArrayList<Proprietario> listarProprietarios() throws SQLException {
        openConnection();
    
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        String SQl = "SELECT * FROM proprietarios";
        PreparedStatement smt = connection.prepareStatement(SQl);
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
        closeConnection();
        return listaProprietarios;
    }

    public static void excluirProprietario(Proprietario p) throws SQLException {
        openConnection();
        ArrayList<Proprietario> listaProprietarios = new ArrayList<>();
        String SQl = "DELETE FROM proprietarios WHERE idProprietario = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, p.getIdProprietario());
        smt.execute();
    }

    public static void main(String[] args) {
        Proprietario p = new Proprietario();
        p.setCartorio("Cartorio teste");
        p.setCnpj("77655009000165");
        p.setCpf("10120916940");
        p.setDataNascimento(new Date(1998, 03, 25));
        p.setEmail("victorio10.0@hotmail.com");
        p.setEndereco("Rua Ana Cirelli");
        p.setNome("Victorio Zansavio");
        p.setRazaoSocial("Teste");
        p.setRg("124878918");
        p.setTelefone("988497735");
        p.setTipo("A");
        p.setIdProprietario(1);
        try {
            //ProprietarioDAO.incluirProprietario(p);
            p.setNome("Victorio");
            ProprietarioDAO.alterarProprietario(p);

            for (Proprietario f : ProprietarioDAO.listarProprietarios()) {
                System.out.println("Nome: " + f.getNome());
            }
            
            ProprietarioDAO.excluirProprietario(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
