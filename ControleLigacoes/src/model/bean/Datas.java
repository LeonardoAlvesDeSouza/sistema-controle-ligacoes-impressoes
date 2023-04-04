/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Camara
 */
public class Datas {
    public String getDataAtual()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
        String dataAtual = dateFormat.format(date);
        
        return dataAtual;
    }
    
    public String getDiaAtual()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd");
	java.util.Date date = new java.util.Date();
        String dataAtual = dateFormat.format(date);
        
        return dataAtual;
    }
    
    public String getMesAtual()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM");
	java.util.Date date = new java.util.Date();
        String dataAtual = dateFormat.format(date);
        
        return dataAtual;
    }
    
    public String getAnoAtual()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
	java.util.Date date = new java.util.Date();
        String dataAtual = dateFormat.format(date);
        
        return dataAtual;
    }
    
    public String getDataAtualHueBr()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date = new java.util.Date();
        String dataAtual = dateFormat.format(date);
        
        return dataAtual;
    }
    
    public String getDataHora()
    {
        SimpleDateFormat d =  new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss.SSS");  
        return d.format(new Date());
    }
    
    public String transformaMesNome(int nMes)
    {
        String mes = null;
        
        if(nMes == 1)
        {
            mes = "Janeiro";
        }
        if(nMes == 2)
        {
            mes = "Fevereiro";
        }
        if(nMes == 3)
        {
            mes = "Março";
        }
        if(nMes == 4)
        {
            mes = "Abril";
        }
        if(nMes == 5)
        {
            mes = "Maio";
        }
        if(nMes == 6)
        {
            mes = "Junho";
        }
        if(nMes == 7)
        {
            mes = "Julho";
        }
        if(nMes == 8)
        {
            mes = "Agosto";
        }
        if(nMes == 9)
        {
            mes = "Setembro";
        }
        if(nMes == 10)
        {
            mes = "Outubro";
        }
        if(nMes == 11)
        {
            mes = "Novembro";
        }
        if(nMes == 12)
        {
            mes = "Dezembro";
        }
        
        
        return mes;
    }
}
