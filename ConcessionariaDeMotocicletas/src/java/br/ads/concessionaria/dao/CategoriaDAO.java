package br.ads.concessionaria.dao;

import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import br.ads.concessionaria.domain.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO extends BaseDAO {

    public static void incluirCategoria(Categoria c) throws SQLException {
        openConnection();
        String SQL = "INSERT INTO categorias (nome, descricao) values (?, ?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setString(1, c.getNome());
        stm.setString(2, c.getDescricao());
        stm.execute();
    }

    public static void alterarCategoria(Categoria c) throws SQLException {
        openConnection();
        String SQL = "UPDATE categorias set nome = ?, descricao = ? WHERE idCategoria = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setString(1, c.getNome());
        stm.setString(2, c.getDescricao());
        stm.setInt(3, c.getIdCategoria());
        stm.execute();
    }

    public static void removerCategoria(int idCategoria) throws SQLException {
        openConnection();
        ArrayList<Categoria> listarCategorias = new ArrayList<>();
        String SQl = "DELETE FROM categorias WHERE idCategoria = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, idCategoria);
        smt.execute();
        //closeConnection();
    }

    public static Categoria retornarCategoriaPorId(int id) throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM categorias WHERE idCategoria = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        //System.err.println("Id vindo da view: " + id);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        Categoria c = new Categoria();
        if (rs.first()) {

            c.setIdCategoria(rs.getInt("idCategoria"));
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
        }

        return c;
    }

    public static ArrayList<Categoria> listarCategorias() throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM categorias";
        ArrayList<Categoria> categorias = new ArrayList<>();
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Categoria c = new Categoria();
            c.setIdCategoria(rs.getInt("idCategoria"));
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
            categorias.add(c);
        }
        return categorias;
    }

    public static void main(String[] args) {
        Categoria c = new Categoria();
        c.setNome("Esportiva");
        c.setDescricao("outra categoria da hora");
        c.setIdCategoria(1);

        try {
            CategoriaDAO.alterarCategoria(c);
            ArrayList<Categoria> categorias = new ArrayList();
            categorias = CategoriaDAO.listarCategorias();
            for (Categoria cat : categorias) {
                System.out.println("ID da categoria: " + cat.getIdCategoria());
                System.out.println("Nome: " + cat.getNome());
                System.out.println("Descrção: " + cat.getDescricao());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}//fim da classe
