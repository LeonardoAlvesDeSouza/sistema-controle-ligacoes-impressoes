/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import model.bean.Pessoa;
import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Camara
 */
public class PessoaDAO {
    
    public void create(Pessoa p)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO pessoas(nomeCompleto, cpf, cidade, estado, telefone) VALUES(?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getCidade());
            stmt.setString(4, p.getEstado());
            stmt.setString(5, p.getTelefone());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucessso !");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar: " + ex);
        }finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void update(Pessoa p)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            stmt = con.prepareStatement("UPDATE pessoas SET nomeCompleto = ?, cpf = ?, cidade = ?, estado = ?, telefone = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getCidade());
            stmt.setString(4, p.getEstado());
            stmt.setString(5, p.getTelefone());
            stmt.setInt(6, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Edição realizada com sucesso !");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar : " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void delete(Pessoa p)
    {
        //codigo aqui
    }
    
    public boolean select(Pessoa p)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM pessoas WHERE nomeCompleto LIKE ?");
            stmt.setString(1, p.getNome() + '%');
            rs = stmt.executeQuery();
            
            if(rs.next())
            {
                result = true;
            }
            
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: "+ ex);
            result = false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return result;
    }
    
    public List<Pessoa> read(Pessoa p)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM pessoas WHERE nomeCompleto LIKE ? ORDER BY nomeCompleto");
            stmt.setString(1, '%' + p.getNome() + '%');
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nomeCompleto"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(rs.getString("estado"));
                pessoa.setTelefone(rs.getString("telefone"));
                
                pessoas.add(pessoa);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pessoas;
    }
    
    public boolean verificaPessoa(Pessoa p)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM pessoas WHERE nomeCompleto = ?");
            stmt.setString(1, p.getNome());
            rs = stmt.executeQuery();
            
            if(rs.next())
            {
                result = true;
            }
            
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: "+ ex);
            result = false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return result;
    }
    
    public List<Pessoa> buscaId(Pessoa p)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM pessoas WHERE id = ?");
            stmt.setInt(1, p.getId());
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nomeCompleto"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(rs.getString("estado"));
                pessoa.setTelefone(rs.getString("telefone"));
                
                pessoas.add(pessoa);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pessoas;
    }
    
}
