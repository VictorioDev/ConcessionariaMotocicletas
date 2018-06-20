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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victorio Zansavio
 */
public class MotocicletaDAO extends BaseDAO {

    public static void incluirMotocicleta(Motocicleta m) throws SQLException {
        openConnection();
        String SQl = "INSERT INTO motocicletas (ano,chassi,cor,tipoCombustivel,valorCompra,valorVenda,situacaoMotocicleta,renavam,placa,motor,valorIPVA,situacaoIPVA,idProprietario, idModelo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
        stm.setDouble(11, m.getValorIPVA());
        stm.setString(12, m.getSituacaoIPVA());
        
        if( m.getProprietario() == null ) {
            stm.setNull(13, java.sql.Types.INTEGER );
        } else {
            stm.setInt(13, m.getProprietario().getIdProprietario() );
        }
        
        stm.setInt(14, m.getModelo().getIdModelo());
        stm.execute();
    }

    public static void removerMotocicleta(int idMotocicleta) throws SQLException {
        openConnection();
        String SQL = "DELETE FROM motocicletas WHERE idMotocicleta = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setInt(1, idMotocicleta);
        stm.execute();
    }

    public static int contarMotocicletas() throws SQLException {
        int total = 0;
        openConnection();
        String SQL = "SELECT COUNT(*) as total FROM motocicletas";
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        if (rs.first()) {
            total = rs.getInt("total");
        }
        return total;
    }
    
    public static int contaMotocicletasPorModelo(int idModelo){
        openConnection();
        String SQL = "SELECT COUNT(motocicletas.idMotocicleta) AS Total FROM Motocicletas WHERE motocicletas.idModelo = ? GROUP BY motocicletas.idModelo";
        int resultado = 0;
        try {
            PreparedStatement stm = connection.prepareCall(SQL);
            stm.setInt(1, idModelo);
            ResultSet rs = stm.executeQuery();
            if (rs.first())
                resultado = rs.getInt("Total");
        } catch (SQLException ex) {
            Logger.getLogger(MotocicletaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public static void alterarSituacaoMotocicleta(String situacao, int idMotocicleta) throws SQLException {
        openConnection();
        String SQL = "UPDATE motocicletas SET situacaoMotocicleta = ? WHERE idMotocicleta = ?";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setString(1, situacao);
        stm.setInt(2, idMotocicleta);
        stm.execute();
    }

    public static int contaMotocicletasPorProprietario(int idProprietario) throws SQLException {
        openConnection();
        int total = 0;
        String SQL = "SELECT COUNT(motocicletas.idMotocicleta) as Total FROM motocicletas WHERE motocicletas.idProprietario = ? GROUP BY motocicletas.idProprietario";
        PreparedStatement stm = connection.prepareCall(SQL);
        stm.setInt(1, idProprietario);
        ResultSet rs = stm.executeQuery();
        rs.first();
        total = rs.getInt("Total");
        return total;
    }

    public static ArrayList<Motocicleta> listarMotocicletasDisponiveis() throws SQLException {
        openConnection();
        PreparedStatement stm;

        ArrayList<Motocicleta> motocicletas = new ArrayList<>();
        
        String SQL = "SELECT * FROM motocicletas WHERE situacaoMotocicleta = 'Disponível'";

        stm = connection.prepareCall(SQL);
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
            m.setValorIPVA(rs.getDouble("valorIPVA"));
            m.setSituacaoIPVA(rs.getString("situacaoIPVA"));
            m.setProprietario(ProprietarioDAO.retornaProprietarioPorId(rs.getInt("idProprietario")));
            m.setModelo(ModeloDAO.retornaModeloPorId(rs.getInt("idModelo")));
            motocicletas.add(m);
        }

        return motocicletas;
     }
    
    public static ArrayList<Motocicleta> listarMotocicletas(String busca) throws SQLException {
        openConnection();
        PreparedStatement stm;

        ArrayList<Motocicleta> motocicletas = new ArrayList<>();

        busca = (busca == null || busca.isEmpty()) ? "" : busca;

        String SQL = "SELECT * FROM motocicletas WHERE ano LIKE '%" + busca + "%' "
                + "OR chassi LIKE '%" + busca + "%' "
                + "OR cor LIKE '%" + busca + "%' "
                + "OR tipoCombustivel LIKE '%" + busca + "%' "
                + "OR valorCompra LIKE '%" + busca + "%' "
                + "OR valorVenda LIKE '%" + busca + "%' "
                + "OR situacaoMotocicleta LIKE '%" + busca + "%' "
                + "OR renavam LIKE '%" + busca + "%' "
                + "OR placa LIKE '%" + busca + "%' "
                + "OR motor LIKE '%" + busca + "%' "
                + "OR dataVistoria LIKE '%" + busca + "%' "
                + "OR valorIPVA LIKE '%" + busca + "%' "
                + "OR situacaoIPVA LIKE '%" + busca + "% ' "
                + "OR idProprietario LIKE '%" + busca + "%' ";

        stm = connection.prepareCall(SQL);
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
                + " valorVenda = ?, situacaoMotocicleta = ?, renavam = ?, placa = ?, motor = ?, "
                + " valorIPVA = ?, situacaoIPVA = ?, idProprietario = ?, idModelo = ? WHERE idMotocicleta = ?";
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
        stm.setDouble(11, m.getValorIPVA());
        stm.setString(12, m.getSituacaoIPVA());       
        stm.setInt(13, m.getProprietario().getIdProprietario());
        stm.setInt(14, m.getModelo().getIdModelo());
        stm.setInt(15, m.getIdMotocicleta());
        stm.execute();
    }

    public static ArrayList<Map> listarMaisVendidos() throws SQLException {
        
        openConnection();
        
        String SQL = "SELECT marcas.idMarca, marcas.nome AS nomeMarca, modelos.idModelo, modelos.nome AS nomeModelo, COUNT( vendas.idVenda ) AS contador, SUM( vendas.valor ) AS total " +
                    "FROM vendas " +
                    "JOIN motocicletas ON vendas.idMotocicleta = motocicletas.idMotocicleta " +
                    "JOIN modelos ON motocicletas.idModelo = modelos.idModelo " +
                    "JOIN marcas ON modelos.idMarca = marcas.idMarca " +
                    "GROUP BY motocicletas.idModelo " +
                    "ORDER BY contador DESC";
        
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Map> lista = new ArrayList<Map>();
        
        while ( rs.next() ) {
            
            Map<String,String> item = new HashMap<String,String>();
        
            item.put("idMarca", rs.getString("idMarca") );
            item.put("nomeMarca", rs.getString("nomeMarca") );
            item.put("idModelo", rs.getString("idModelo") );
            item.put("nomeModelo", rs.getString("nomeModelo") );
            item.put("contador", rs.getString("contador") );
            item.put("total", rs.getString("total") );
            
            lista.add( item );
        }
        
        return lista;        
    }
    
    public static ArrayList<Motocicleta> listarEstoque() throws SQLException {
        openConnection();
        
        String SQL = "SELECT * FROM motocicletas WHERE situacaoMotocicleta = 'Disponível'";
        PreparedStatement stm = connection.prepareCall(SQL);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Motocicleta> estoque = new ArrayList<Motocicleta>();
        
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
            m.setValorIPVA(rs.getDouble("valorIPVA"));
            m.setSituacaoIPVA(rs.getString("situacaoIPVA"));
            m.setProprietario(ProprietarioDAO.retornaProprietarioPorId(rs.getInt("idProprietario")));
            m.setModelo(ModeloDAO.retornaModeloPorId(rs.getInt("idModelo")));
            estoque.add(m);
        }
        
        return estoque;
    }
    
    public static int retornarUltimoId() throws SQLException {
        openConnection();
        int ultimoId;
        
        String SQL = "SELECT MAX( motocicletas.idMotocicleta ) AS maximo FROM motocicletas";
        PreparedStatement smt = connection.prepareStatement( SQL );
        ResultSet rs = smt.executeQuery();
        rs.first();
        
        ultimoId = rs.getInt("maximo");
        return ultimoId;
    }
    
    public static void main(String[] args) {
        try {
            int result = MotocicletaDAO.contaMotocicletasPorProprietario(20);
            System.err.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(MotocicletaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
