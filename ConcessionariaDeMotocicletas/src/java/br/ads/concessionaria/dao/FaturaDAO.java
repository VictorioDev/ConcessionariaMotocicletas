package br.ads.concessionaria.dao;
import br.ads.concessionaria.domain.Fatura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO da tabela de faturas.
 * @author Luciano Carvalho
 */
public class FaturaDAO extends BaseDAO {

    /**
     * Método para contar a quantidade de faturas.
     * @return
     * @throws SQLException 
     */
    public static int contarFaturas() throws SQLException {
        openConnection();
        String SQL = "SELECT COUNT(*) AS contador FROM faturas";
        
        PreparedStatement smt = connection.prepareStatement( SQL );
        
        ResultSet rs = smt.executeQuery();
        
        rs.first();
        
        return rs.getInt("contador");
    }
    
    /**
     * Método para listar todas as faturas.
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Fatura> listarFatura() throws SQLException {
        openConnection();

        ArrayList<Fatura> listaFaturas = new ArrayList<>();
        String SQL = "SELECT * FROM faturas";
        PreparedStatement smt = connection.prepareStatement( SQL );
        
        ResultSet rs = smt.executeQuery();
        
        while( rs.next() ) {
            
            Fatura f = new Fatura();
            
            f.setIdFatura( rs.getInt("idFatura") );
            f.setNumeroParcela( rs.getInt("numeroParcela") );
            f.setDataEmissao( rs.getDate("dataEmissao") );
            f.setDataVencimento( rs.getDate("dataVencimento") );
            f.setValorParcela( rs.getDouble("valorParcela") );
            f.setStatus( rs.getString("status") );
            f.setTipoPagamento( rs.getString("tipoPagamento") );
            f.setVenda( VendaDAO.retornarVendaPorId( rs.getInt("idVenda") ) );
            
            listaFaturas.add( f );
        }
                
        return listaFaturas;
    }
    
    /**
     * Método para incluir uma fatura no banco de dados.
     * @param f
     * @return
     * @throws SQLException 
     */
    public static boolean incluirFatura( Fatura f ) throws SQLException {
        openConnection();
        
        boolean result;
        
        String SQL = "INSERT INTO faturas" +
                     "( numeroParcela, dataEmissao, dataVencimento, valorParcela, status, tipoPagamento, idVenda )" +
                     " VALUES ( ?, ?, ?, ?, ?, ?, ? )";
        
        PreparedStatement stm = connection.prepareStatement( SQL );
        
        stm.setInt( 1, f.getNumeroParcela() );
        stm.setDate( 2, f.getDataEmissao() );
        stm.setDate( 3, f.getDataVencimento() );
        stm.setDouble( 4, f.getValorParcela() );
        stm.setString( 5, f.getStatus() );
        stm.setString( 6, f.getTipoPagamento() );
        stm.setInt( 7, f.getVenda().getIdVenda() );
        
        result = stm.execute();
               
        return result;
    }
    
    /**
     * Método para retornar uma fatura pelo ID.
     * @param id
     * @return
     * @throws SQLException 
     */
    public static Fatura retornarFaturaPorId( int id ) throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM faturas WHERE idFatura = ?";
        PreparedStatement smt = connection.prepareStatement( SQL );
        smt.setInt( 1, id );
        
        ResultSet rs = smt.executeQuery();
        Fatura f = new Fatura();
        
        if( rs.first() ) {
            f.setIdFatura( rs.getInt("idFatura") );
            f.setNumeroParcela( rs.getInt("numeroParcela") );
            f.setDataEmissao( rs.getDate("dataEmissao") );
            f.setDataVencimento( rs.getDate("dataVencimento") );
            f.setValorParcela( rs.getDouble("valorParcela") );
            f.setStatus( rs.getString("status") );
            f.setTipoPagamento( rs.getString("tipoPagamento") );
            f.setVenda( VendaDAO.retornarVendaPorId( rs.getInt("idVenda") ) );
        }
        
        return f;
    }
    
    /**
     * Método para baixar uma fatura.
     * @param id
     * @return 
     */
    public static boolean baixarFatura( int id ) throws SQLException {
        openConnection();
        
        boolean result;
        
        String SQL = "UPDATE faturas SET status = 'Paga' WHERE idFatura = ?";
        
        PreparedStatement smt = connection.prepareStatement( SQL );
        
        smt.setInt( 1, id );
       
        result = smt.execute();
        
        return result;
    }
    
    /**
     * Método para excluir todas as faturas de uma venda.
     * @param id
     * @return 
     */
    public static boolean excluirFaturasVenda( int id ) throws SQLException {
        openConnection();

        boolean result;

        String SQL = "DELETE FROM faturas WHERE idVenda = ?";

        PreparedStatement smt = connection.prepareStatement( SQL );

        smt.setInt( 1, id );

        result = smt.execute();

        return result;
    }
}
