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
public class Ligacoes {
    private int id;
    private String numeroLigado;
    private String dataLiga;
    private int idPerfil;
    private String dataInicialRelat;
    private String dataFinalRelat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroLigado() {
        return numeroLigado;
    }

    public void setNumeroLigado(String numeroLigado) {
        this.numeroLigado = numeroLigado;
    }

    public String getDataLiga() {
        return dataLiga;
    }

    public void setDataLiga(String dataLiga) {
        this.dataLiga = dataLiga;
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
