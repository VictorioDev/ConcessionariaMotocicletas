/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ads.concessionaria.dao;

import br.ads.concessionaria.domain.Motocicleta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victorio Zansavio
 */
public class MotocicletaDAO extends BaseDAO {

    public static void incluirMotocicleta(Motocicleta m) throws SQLException {
        openConnection();
        String SQl = "INSERT INTO motocicletas (ano,chassi,cor,tipoCombustivel,valorCompra,valorVenda,situacaoMotocicleta,renavam,placa,motor,dataVistoria,valorIPVA,situacaoIPVA,idProprietario) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQl);
        stm.setInt(1, m.getAno());
        stm.setString(2, m.getChassi());
        stm.setString(3, m.getCor());
        stm.setString(4, m.getTipoCombustivel());
        stm.setDouble(5, m.getValorCompra());
        stm.setDouble(6, m.getValorVenda());
        stm.setString(7, m.getSituacaoMotocicleta());
        stm.setInt(8, m.getRenavam());
        stm.setString(9, m.getPlaca());
        stm.setString(10, m.getMotor());
        stm.setDate(11, m.getDataVistoria());
        stm.setDouble(12, m.getValorIPVA());
        stm.setString(13, m.getSituacaoIPVA());
        stm.setInt(14, m.getProprietario().getIdProprietario());
        stm.execute();
    }

    public static void removerMotocicleta(int idMotocicleta) throws SQLException {
        openConnection();
        String SQL = "DELETE FROM motocicletas where idMotocicleta = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setInt(1, idMotocicleta);
        stm.execute();
        
    }

    public static ArrayList<Motocicleta> listarMotocicletas() throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM motocicletas";
        ArrayList<Motocicleta> motocicletas = new ArrayList<>();
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Motocicleta m = new Motocicleta();
            m.setIdMotocicleta(rs.getInt("idMotocicleta"));
            m.setAno(rs.getInt("ano"));
            m.setChassi(rs.getString("chassi"));
            m.setCor(rs.getString("cor"));
            m.setTipoCombustivel(rs.getString("tipoCombustivel"));
            m.setValorCompra(rs.getDouble("valorCompra"));
            m.setValorVenda(rs.getDouble("valorVenda"));
            m.setSituacaoMotocicleta(rs.getString("situacaoMotocicleta"));
            m.setRenavam(rs.getInt("renavam"));
            m.setPlaca(rs.getString("placa"));
            m.setMotor(rs.getString("motor"));
            m.setDataVistoria(rs.getDate("dataVistoria"));
            m.setValorIPVA(rs.getDouble("valorIPVA"));
            m.setSituacaoIPVA(rs.getString("situacaoIPVA"));
            m.setProprietario(ProprietarioDAO.retornaProprietarioPorId(rs.getInt("idProprietario")));
            m.setModelo(ModeloDAO.retornaModeloPorId(rs.getInt("idModelo")));
            motocicletas.add(m);
        }

        return motocicletas;
    }

    public static Motocicleta retornaMotocicletaPorId(int id) throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM motocicletas WHERE idMotocicleta = ?";
        ArrayList<Motocicleta> motocicletas = new ArrayList<>();
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        Motocicleta m = new Motocicleta();
        if (rs.first()) {
            m.setIdMotocicleta(rs.getInt("idMotocicleta"));
            m.setAno(rs.getInt("ano"));
            m.setChassi(rs.getString("chassi"));
            m.setCor(rs.getString("cor"));
            m.setTipoCombustivel(rs.getString("tipoCombustivel"));
            m.setValorCompra(rs.getDouble("valorCompra"));
            m.setValorVenda(rs.getDouble("valorVenda"));
            m.setSituacaoMotocicleta(rs.getString("situacaoMotocicleta"));
            m.setRenavam(rs.getInt("renavam"));
            m.setPlaca(rs.getString("placa"));
            m.setMotor(rs.getString("motor"));
            m.setDataVistoria(rs.getDate("dataVistoria"));
            m.setValorIPVA(rs.getDouble("valorIPVA"));
            m.setSituacaoIPVA(rs.getString("situacaoIPVA"));
            m.setProprietario(ProprietarioDAO.retornaProprietarioPorId(rs.getInt("idProprietario")));
            m.setModelo(ModeloDAO.retornaModeloPorId(rs.getInt("idModelo")));
        }
        return m;
    }

    public static void alterarMotocicleta(Motocicleta m) throws SQLException {
        openConnection();
        String SQL = "UPDATE motocicletas set ano = ?, chassi = ?, cor = ?, tipoCombustivel = ?, valorCompra = ?,"
                +" valorVenda = ?, situacaoMotocicleta = ?, renavam = ?, placa = ?, motor = ?, dataVistoria = ?," 
                +" valorIPVA = ?, situacaoIPVA = ?, idProprietario = ?, idModelo = ? WHERE idMotocicleta = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setInt(1, m.getAno());
        stm.setString(2, m.getChassi());
        stm.setString(3, m.getCor());
        stm.setString(4, m.getTipoCombustivel());
        stm.setDouble(5, m.getValorCompra());
        stm.setDouble(6, m.getValorVenda());
        stm.setString(7, m.getSituacaoMotocicleta());
        stm.setInt(8, m.getRenavam());
        stm.setString(9, m.getPlaca());
        stm.setString(10, m.getMotor());
        stm.setDate(11, m.getDataVistoria());
        stm.setDouble(12, m.getValorIPVA());
        stm.setString(13, m.getSituacaoIPVA());
        System.err.println("Prop Moto Dao: " + m.getProprietario().getIdProprietario());
        System.err.println("Modelo Moto Dao: " + m.getModelo().getIdModelo());
        System.err.println("Moto : " + m.getIdMotocicleta());
        stm.setInt(14, m.getProprietario().getIdProprietario());
        stm.setInt(15, m.getModelo().getIdModelo());
        stm.setInt(16, m.getIdMotocicleta());
        stm.execute();
    }
}
