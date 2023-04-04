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
import javax.swing.JOptionPane;
import model.bean.Datas;
import model.bean.Impressoes;

/**
 *
 * @author Camara
 */
public class ImpressoesDAO {
    public void create(Impressoes im)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO impressoes(qtdadeImpre, dataImpre, idPerfil) VALUES(?,?,?)");
            stmt.setInt(1, im.getQtdadeImpre());
            stmt.setString(2, im.getDataImpre());
            stmt.setInt(3, im.getIdPerfil());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Impressão adicionada com sucesso !");
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
    }
    
    public int buscaQuantidadeImpressoes(Impressoes i)
    {
        com.mysql.jdbc.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int qtdadeImpre = 0;
        
        Datas datas = new Datas();
        String mesAtual = datas.getMesAtual();
        String anoAtual = datas.getAnoAtual();
        
        try{
            stmt = con.prepareStatement("SELECT SUM(qtdadeImpre) AS qtdadeImpre FROM impressoes WHERE idPerfil = ? and dataImpre BETWEEN ? and ? ");
            stmt.setInt(1, i.getId());            
            stmt.setString(2, anoAtual + "-" + mesAtual + "-" + "01");
            stmt.setString(3, anoAtual + "-" + mesAtual + "-" + "31");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                qtdadeImpre = rs.getInt("qtdadeImpre");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return qtdadeImpre;
    }
    
    public int buscaUltimoIdImpressao(Impressoes im)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int idImpre = 0;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM impressoes WHERE idPerfil = ?");
            stmt.setInt(1, im.getIdPerfil());
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                idImpre = rs.getInt("idImpre");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return idImpre;
    }
    
    public void deletaImpre(Impressoes im)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM impressoes WHERE idImpre = ?");
            stmt.setInt(1, im.getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Última Impressão Deletada com sucesso");
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public List<Impressoes> buscaTodosIds(Impressoes im)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Datas datas = new Datas();
        String anoAtual = datas.getAnoAtual();
        
        List<Impressoes> impressoes = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM impressoes WHERE dataImpre BETWEEN ? and ?");
            stmt.setString(1, anoAtual + "-" + im.getDataInicialRelat() + "-" + "01");
            stmt.setString(2, anoAtual + "-" + im.getDataFinalRelat() + "-" + "31");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Impressoes impre = new Impressoes();
                impre.setIdPerfil(rs.getInt("idPerfil"));
                
                impressoes.add(impre);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return impressoes;
    }
    
    public int buscaQuantidadeImpressoesRelatorio(Impressoes i)
    {
        com.mysql.jdbc.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int qtdadeImpre = 0;
        
        Datas datas = new Datas();
        String anoAtual = datas.getAnoAtual();
        
        try{
            stmt = con.prepareStatement("SELECT SUM(qtdadeImpre) AS qtdadeImpre FROM impressoes WHERE idPerfil = ? and dataImpre BETWEEN ? and ? ");
            stmt.setInt(1, i.getId());            
            stmt.setString(2, anoAtual + "-" + i.getDataInicialRelat() + "-" + "01");
            stmt.setString(3, anoAtual + "-" + i.getDataFinalRelat() + "-" + "31");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                qtdadeImpre = rs.getInt("qtdadeImpre");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return qtdadeImpre;
    }
    
    public List<Impressoes> buscaTodosIdsTotal(Impressoes im)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        List<Impressoes> impressoes = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM impressoes");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Impressoes impre = new Impressoes();
                impre.setIdPerfil(rs.getInt("idPerfil"));
                
                impressoes.add(impre);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return impressoes;
    }
    
    public int buscaQuantidadeImpressoesTotalRelatorio(Impressoes i)
    {
        com.mysql.jdbc.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int qtdadeImpre = 0;
        
        try{
            stmt = con.prepareStatement("SELECT SUM(qtdadeImpre) AS qtdadeImpre FROM impressoes WHERE idPerfil = ?");
            stmt.setInt(1, i.getId());            
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                qtdadeImpre = rs.getInt("qtdadeImpre");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return qtdadeImpre;
    }
}
