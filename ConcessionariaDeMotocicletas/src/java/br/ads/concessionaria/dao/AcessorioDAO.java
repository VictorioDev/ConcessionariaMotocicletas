package br.ads.concessionaria.dao;

import static br.ads.concessionaria.dao.BaseDAO.connection;
import static br.ads.concessionaria.dao.BaseDAO.openConnection;
import br.ads.concessionaria.domain.Acessorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcessorioDAO extends BaseDAO {
    
    public static void incluirAcessorio(Acessorio a) throws SQLException {
        openConnection();
        String SQL = "INSERT INTO acessorios (descricao) values (?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setString(1, a.getDescricao());
        stm.execute();
    }

    public static void alterarAcessorio(Acessorio a) throws SQLException {
        openConnection();
        String SQL = "UPDATE acessorios set descricao = ? WHERE idAcessorio = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setString(1, a.getDescricao());
        stm.setInt(2, a.getIdAcessorio());
        stm.execute();
    }

    public static void removerAcessorio(int idAcessorio) throws SQLException {
        openConnection();
        ArrayList<Acessorio> listarAcessorios = new ArrayList<>();
        String SQl = "DELETE FROM acessorios WHERE idAcessorio = ?";
        PreparedStatement smt = connection.prepareStatement(SQl);
        smt.setInt(1, idAcessorio);
        smt.execute();
        //closeConnection();
    }

    public static Acessorio retornarAcessorioPorId(int id) throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM acessorios WHERE idAcessorio = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        //System.err.println("Id vindo da view: " + id);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        Acessorio a = new Acessorio();
        if (rs.first()) {
            a.setIdAcessorio(rs.getInt("idAcessorio"));
            a.setDescricao(rs.getString("descricao"));
        }
        return a;
    }

    public static ArrayList<Acessorio> listarAcessorios() throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM acessorios";
        ArrayList<Acessorio> acessorios = new ArrayList<>();
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Acessorio a = new Acessorio();
            a.setIdAcessorio(rs.getInt("idAcessorio"));
            a.setDescricao(rs.getString("descricao"));
            acessorios.add(a);
        }
        return acessorios;
    }

//    public static void main(String[] args) {
//        Acessorio a = new Acessorio();
//        c.setNome("Esportiva");
//        c.setDescricao("outra categoria da hora");
//        c.setIdCategoria(1);
//
//        try {
//            CategoriaDAO.alterarCategoria(c);
//            ArrayList<Categoria> categorias = new ArrayList();
//            categorias = CategoriaDAO.listarCategorias();
//            for (Categoria cat : categorias) {
//                System.out.println("ID da categoria: " + cat.getIdCategoria());
//                System.out.println("Nome: " + cat.getNome());
//                System.out.println("Descrção: " + cat.getDescricao());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}
