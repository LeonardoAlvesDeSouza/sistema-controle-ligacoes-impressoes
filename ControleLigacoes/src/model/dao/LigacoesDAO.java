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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Datas;
import model.bean.Ligacoes;

/**
 *
 * @author Camara
 */
public class LigacoesDAO {
    public void create(Ligacoes l)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO ligacoes(dataLiga, idPerfil, numeroLigado) Values (?,?,?)");
            stmt.setString(1, l.getDataLiga());
            stmt.setInt(2, l.getIdPerfil());
            stmt.setString(3, l.getNumeroLigado());
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Ligação Adicionada com sucesso !");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar :" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public int buscaQuantidadeLigacoes(Ligacoes l)
    {
        com.mysql.jdbc.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int totalID = 0;
        
        Datas datas = new Datas();
        String mesAtual = datas.getMesAtual();
        String anoAtual = datas.getAnoAtual();
        

        
        try{
            stmt = con.prepareStatement("SELECT * FROM ligacoes WHERE idPerfil = ? and dataLiga BETWEEN ? and ? ");
            stmt.setInt(1, l.getId());
            stmt.setString(2, anoAtual + "-" + mesAtual + "-" + "01");
            stmt.setString(3, anoAtual + "-" + mesAtual + "-" + "31");
            rs = stmt.executeQuery();
            
           while(rs.next())
           {
               totalID = rs.getRow();
           }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar : "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return totalID;

    }
    
    public int buscaUltimoIdLigacao(Ligacoes l)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int idLiga = 0;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM ligacoes WHERE idPerfil = ?");
            stmt.setInt(1, l.getIdPerfil());
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                idLiga = rs.getInt("idLiga");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return idLiga;
    }
    
    public void deletaLiga(Ligacoes l)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM ligacoes WHERE idLiga = ?");
            stmt.setInt(1, l.getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Última Ligação Deletada com sucesso");
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public List<Ligacoes> buscaTodosIds(Ligacoes li)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Datas datas = new Datas();
        String anoAtual = datas.getAnoAtual();
        
        List<Ligacoes> ligacoes = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM ligacoes WHERE dataLiga BETWEEN ? and ?");
            stmt.setString(1, anoAtual + "-" + li.getDataInicialRelat() + "-" + "01");
            stmt.setString(2, anoAtual + "-" + li.getDataFinalRelat() + "-" + "31");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Ligacoes liga = new Ligacoes();
                liga.setIdPerfil(rs.getInt("idPerfil"));
                
                ligacoes.add(liga);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ligacoes;
    }
    
    public int buscaQuantidadeLigacoesRelatorio(Ligacoes l)
    {
        com.mysql.jdbc.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int qtdadeLiga = 0;
        
        Datas datas = new Datas();
        String anoAtual = datas.getAnoAtual();
        
        try{
            stmt = con.prepareStatement("SELECT COUNT(idLiga) AS idLiga FROM ligacoes WHERE idPerfil = ? and dataLiga BETWEEN ? and ? ");
            stmt.setInt(1, l.getId());            
            stmt.setString(2, anoAtual + "-" + l.getDataInicialRelat() + "-" + "01");
            stmt.setString(3, anoAtual + "-" + l.getDataFinalRelat() + "-" + "31");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                qtdadeLiga = rs.getInt("idLiga");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return qtdadeLiga;
    }
    
    public List<Ligacoes> buscaTodosIdsTotal(Ligacoes li)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Ligacoes> ligacoes = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM ligacoes");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Ligacoes liga = new Ligacoes();
                liga.setIdPerfil(rs.getInt("idPerfil"));
                
                ligacoes.add(liga);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ligacoes;
    }
    
    public int buscaQuantidadeLigacoesTotalRelatorio(Ligacoes l)
    {
        com.mysql.jdbc.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int qtdadeLiga = 0;
        
        Datas datas = new Datas();
        String anoAtual = datas.getAnoAtual();
        
        try{
            stmt = con.prepareStatement("SELECT COUNT(idLiga) AS idLiga FROM ligacoes WHERE idPerfil = ?");
            stmt.setInt(1, l.getId());            
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                qtdadeLiga = rs.getInt("idLiga");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return qtdadeLiga;
    }
}
