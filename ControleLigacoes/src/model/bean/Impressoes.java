/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Camara
 */
public class Impressoes {
    private int id;
    private int qtdadeImpre;
    private String dataImpre;
    private int idPerfil;
    private String dataInicialRelat;
    private String dataFinalRelat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdadeImpre() {
        return qtdadeImpre;
    }

    public void setQtdadeImpre(int qtdadeImpre) {
        this.qtdadeImpre = qtdadeImpre;
    }

    public String getDataImpre() {
        return dataImpre;
    }

    public void setDataImpre(String dataImpre) {
        this.dataImpre = dataImpre;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDataInicialRelat() {
        return dataInicialRelat;
    }

    public void setDataInicialRelat(String dataInicialRelat) {
        this.dataInicialRelat = dataInicialRelat;
    }

    public String getDataFinalRelat() {
        return dataFinalRelat;
    }

    public void setDataFinalRelat(String dataFinalRelat) {
        this.dataFinalRelat = dataFinalRelat;
    }
    
    
}
