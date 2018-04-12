package br.ads.concessionaria.dao;

import br.ads.concessionaria.domain.Proprietario;
import br.ads.concessionaria.domain.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO da tabela de Usuários.
 * @author Luciano Carvalho
 */
public class UsuarioDAO extends BaseDAO {

    /**
     * Método para incluir um novo usuário.
     * @param u
     * @return
     * @throws SQLException 
     */
    public static boolean incluirUsuario( Usuario u ) throws SQLException {
        openConnection();
        
        boolean result;
        
        String SQL = "INSERT INTO usuarios" +
                     "( nome, login, senha, cpf, endereco, telefone, email, tipo )" +
                     " VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
        
        PreparedStatement stm = connection.prepareStatement( SQL );
        
        stm.setString( 1, u.getNome() );
        stm.setString( 2, u.getLogin() );
        stm.setString( 3, u.getSenha() );
        stm.setString( 4, u.getCpf() );
        stm.setString( 5, u.getEndereco());
        stm.setString( 6, u.getTelefone());
        stm.setString( 7, u.getEmail());
        stm.setString( 8, u.getTipo() );
        
        result = stm.execute();
               
        return result;
    }

    /**
     * Método para listar todos os usuários.
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Usuario> listarUsuario() throws SQLException {
        openConnection();

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        String SQL = "SELECT * FROM usuarios";
        PreparedStatement smt = connection.prepareStatement( SQL );
        
        ResultSet rs = smt.executeQuery();
        
        while( rs.next() ) {
            Usuario u = new Usuario();
            
            u.setIdUsuario( rs.getInt("idUsuario") );
            u.setNome( rs.getString("nome") );
            u.setLogin( rs.getString("login") );
            u.setSenha( rs.getString("senha") );
            u.setCpf( rs.getString("cpf") );
            u.setEndereco( rs.getString("endereco") );
            u.setTelefone( rs.getString("telefone") );
            u.setEmail( rs.getString("email") );
            u.setTipo( rs.getString("tipo") );
            
            listaUsuarios.add( u );
        }
                
        return listaUsuarios;
    }

    /**
     * Método para retornar um usuário pelo ID.
     * @param id
     * @return
     * @throws SQLException 
     */
    public static Usuario retornarUsuarioPorId( int id ) throws SQLException {
        openConnection();
        String SQL = "SELECT * FROM usuarios WHERE idUsuario = ?";
        PreparedStatement smt = connection.prepareStatement( SQL );
        smt.setInt( 1, id );
        
        ResultSet rs = smt.executeQuery();
        Usuario u = new Usuario();
        
        if( rs.first() ) {
            u.setIdUsuario(id);
            u.setNome( rs.getString("nome") );
            u.setLogin( rs.getString("login") );
            u.setSenha( rs.getString("senha") );
            u.setCpf( rs.getString("cpf") );
            u.setEndereco( rs.getString("endereco") );
            u.setTelefone( rs.getString("telefone") );
            u.setEmail( rs.getString("email") );
            u.setTipo( rs.getString("tipo") );
        }
        
        return u;
    }
    
    /**
     * Método para remover um usuário.
     * @param u
     * @throws SQLException 
     */
    public static void removerUsuario( Usuario u ) throws SQLException {
        openConnection();
        
        String SQL = "DELETE FROM usuarios WHERE idUsuario = ?";
        PreparedStatement stm = connection.prepareStatement( SQL );
        stm.setInt( 1, u.getIdUsuario() );
                
        stm.execute();
    }
    
    /**
     * Método para alterar um usuário.
     * @param u
     * @throws SQLException 
     */
    public static void alterarUsuario( Usuario u ) throws SQLException {
        openConnection();
        
        String SQL = "UPDATE usuarios"
                     + " SET nome = ?, login = ?, senha = ?, cpf = ?, endereco = ?, telefone = ?, email = ?, tipo = ?"
                     + " WHERE idUsuario = ?";
        
        PreparedStatement stm = connection.prepareStatement( SQL );
        
        stm.setString( 1, u.getNome() );
        stm.setString( 2, u.getLogin() );
        stm.setString( 3, u.getSenha() );
        stm.setString( 4, u.getCpf());
        stm.setString( 5, u.getEndereco() );
        stm.setString( 6, u.getTelefone() );
        stm.setString( 7, u.getEmail() );
        stm.setString( 8, u.getTipo() );
        stm.setInt( 9, u.getIdUsuario() );
        
        stm.execute();
    }
}
