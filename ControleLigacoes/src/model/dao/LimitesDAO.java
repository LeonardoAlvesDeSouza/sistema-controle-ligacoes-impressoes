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
import javax.swing.JOptionPane;
import model.bean.Limites;

/**
 *
 * @author Camara
 */
public class LimitesDAO {
    public void updateLimites(Limites li)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("UPDATE limites SET qtdadeLimiteLiga = ?, qtdadeLimiteImpre = ? WHERE idLimites = 1");
            stmt.setInt(1, li.getQtdadeLimiteLiga());
            stmt.setInt(2, li.getQtdadeLimiteImpre());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Limite atualizado com sucesso !");
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public int buscaLimiteLiga(Limites li)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int limiteLiga = 0;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM limites WHERE idLimites = 1");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                limiteLiga = rs.getInt("qtdadeLimiteLiga");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return limiteLiga;
    }
    
    public int buscaLimiteImpre(Limites li)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int limiteImpre = 0;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM limites WHERE idLimites = 1");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                limiteImpre = rs.getInt("qtdadeLimiteImpre");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return limiteImpre;
    }
}
