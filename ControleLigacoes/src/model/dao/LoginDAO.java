/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Login;

/**
 *
 * @author Camara
 */
public class LoginDAO {
    
    public void create(Login l)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO login(login,senha) VALUES(?,?)");
            stmt.setString(1, l.getLogin());
            stmt.setString(2, l.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar :" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void delete(Login l)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM login WHERE id = ?");
            stmt.setInt(1, l.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Deletado com sucesso !");
            
        } catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Erro ao tentar deletar :" + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public List<Login> read(Login l)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Login> logins = new ArrayList<>();
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM login WHERE login = ? and senha = ?");
            stmt.setString(1, l.getLogin());
            stmt.setString(2, l.getSenha());
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Login login = new Login();
                
                login.setId(rs.getInt("id"));
                login.setLogin(rs.getString("login"));
                login.setSenha(rs.getString("senha"));
                
                logins.add(login);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar :" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return logins;
    }
    
    public List<Login> busca(Login l)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Login> logins = new ArrayList<>();
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM login WHERE id = ?");
            stmt.setInt(1, l.getId());
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Login login = new Login();
                
                login.setId(rs.getInt("id"));
                login.setLogin(rs.getString("login"));
                login.setSenha(rs.getString("senha"));
                
                logins.add(login);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar :" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return logins;
    }
    
    public boolean select(Login l)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM login WHERE login = ?");
            stmt.setString(1, l.getLogin());
            rs = stmt.executeQuery();
            
            if(rs.next())
            {
                result = true;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: "+ ex);
            result = false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return result;
    }
    
}
