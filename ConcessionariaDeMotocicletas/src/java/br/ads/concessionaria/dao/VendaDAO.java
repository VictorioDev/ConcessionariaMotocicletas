package br.ads.concessionaria.dao;
import br.ads.concessionaria.domain.Usuario;
import br.ads.concessionaria.domain.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DAO da tabela de vendas.
 * @author Luciano Carvalho
 */
public class VendaDAO extends BaseDAO {

    /**
     * Método para incluir uma nova venda.
     * @param v
     * @return
     * @throws SQLException 
     */
    public static int incluirVenda( Venda v ) throws SQLException {
        openConnection();
        
        int idVenda = 0;
        
        String SQL = "INSERT INTO vendas" +
                     "( dataVenda, quantidadeParcelas, valor, diaPreferencial, idCliente, idUsuario, status, idMotocicleta )" +
                     " VALUES ( NOW(), ?, ?, ?, ?, ?, ?, ? )";
        
        PreparedStatement stm = connection.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
        
        stm.setInt( 1, v.getQuantidadeParcelas() );
        stm.setDouble( 2, v.getValor() );
        stm.setInt( 3, v.getDiaPreferencial() );
        stm.setInt( 4, v.getCliente().getIdCliente() );
        stm.setInt( 5, v.getUsuario().getIdUsuario() );
        stm.setString( 6, v.getStatus() );
        stm.setInt( 7, v.getMotocicleta().getIdMotocicleta() );
        
        stm.executeUpdate();
               
        ResultSet generatedKeys = stm.getGeneratedKeys();
        
        if ( generatedKeys.next() ) {
            idVenda = generatedKeys.getInt(1);
        }
        
        return idVenda;
    }

    /**
     * Método para listar todas as vendas.
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Venda> listarVenda() throws SQLException {
        openConnection();

        ArrayList<Venda> listaVendas = new ArrayList<>();
        String SQL = "SELECT * FROM vendas";
        PreparedStatement smt = connection.prepareStatement( SQL );
        
        ResultSet rs = smt.executeQuery();
        
        while( rs.next() ) {
            
            Venda v = new Venda();
            
            v.setIdVenda( rs.getInt("idVenda") );
            v.setDataVenda( rs.getString("dataVenda") );
            v.setQuantidadeParcelas( rs.getInt("quantidadeParcelas") );
            v.setValor( rs.getDouble("valor") );
            v.setDiaPreferencial( rs.getInt("diaPreferencial") );
            v.setStatus( rs.getString("status") );
            
            v.setCliente( ClienteDAO.retornarClientePorId( rs.getInt("idCliente") ) );
            v.setMotocicleta( MotocicletaDAO.retornaMotocicletaPorId( rs.getInt("idMotocicleta") ) );
            v.setUsuario( UsuarioDAO.retornarUsuarioPorId( rs.getInt("idUsuario") ) );
            
            listaVendas.add( v );
        }
                
        return listaVendas;
    }

    /**
     * Método para retornar uma venda pelo ID.
     * @param id
     * @return
     * @throws SQLException 
     */
    public static Venda retornarVendaPorId( int id ) throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM vendas WHERE idVenda = ?";
        PreparedStatement smt = connection.prepareStatement( SQL );
        smt.setInt( 1, id );
        
        ResultSet rs = smt.executeQuery();
        Venda v = new Venda();
        
        if( rs.first() ) {
            v.setIdVenda( rs.getInt("idVenda") );
            v.setDataVenda( rs.getString("dataVenda") );
            v.setQuantidadeParcelas( rs.getInt("quantidadeParcelas") );
            v.setValor( rs.getDouble("valor") );
            v.setDiaPreferencial( rs.getInt("diaPreferencial") );
            v.setStatus( rs.getString("status") );
            
            v.setCliente( ClienteDAO.retornarClientePorId( rs.getInt("idCliente") ) );
            v.setMotocicleta( MotocicletaDAO.retornaMotocicletaPorId( rs.getInt("idMotocicleta") ) );
            v.setUsuario( UsuarioDAO.retornarUsuarioPorId( rs.getInt("idUsuario") ) );
        }
        
        return v;
    }
    
    /**
     * Método para alterar uma venda.
     * @param u
     * @throws SQLException 
     */
    public static void cancelarVenda( int id ) throws SQLException {
        openConnection();
        
        String SQL = "UPDATE vendas SET status = 'Cancelada' WHERE idVenda = ?";
        
        PreparedStatement stm = connection.prepareStatement( SQL );
        
        stm.setInt( 1, id );
        
        stm.execute();
    }
    
    public static int contarVendas() throws SQLException {
        openConnection();
        
        String SQL = "SELECT COUNT(*) AS contador FROM vendas";
        
        PreparedStatement smt = connection.prepareStatement( SQL );
        
        ResultSet rs = smt.executeQuery();
        
        rs.first();
        
        return rs.getInt("contador");
    }
}
