package com.mycompany._megaprogetto_galifivalerio;
/**
 * 
 * @author vale
 */
public class Match {
    private int numeroMatch;
    private int numeroRound;
    private String classeDiPeso;
    private String fighter1;
    private String fighter2;
    private double premioAtleta;
    private String vincitore;
/**
 * 
 * @param numeroMatch
 * @param numeroRound
 * @param classeDiPeso
 * @param fighter1
 * @param fighter2 
 */
    public Match(int numeroMatch, int numeroRound, String classeDiPeso, String fighter1, String fighter2) {
        this.numeroMatch = numeroMatch;
        impostaNumeroRound(numeroRound);
        impostaClasseDiPeso(classeDiPeso);
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.premioAtleta = 0;
    }
/**
 * 
 * @return 
 */
    public int getNumeroMatch() {
        return numeroMatch;
    }

    public int getNumeroRound() {
        return numeroRound;
    }

    public String getClasseDiPeso() {
        return classeDiPeso;
    }

    public String getFighter1() {
        return fighter1;
    }

    public String getFighter2() {
        return fighter2;
    }

    public double getPremioAtleta() {
        return premioAtleta;
    }
/**
 * assegna un premio al vincitore
 * @param premioAtleta 
 */
    public void setPremioAtleta(double premioAtleta) {
        this.premioAtleta = premioAtleta;
    }
/**
 * consente di ottenere come input il vincitore
 * @return 
 */
    public String getVincitore() {
        String vincitore = null;
        return vincitore;
    }
/**
 * assegna il vincitore
 * @param vincitore 
 */
    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }
/**
 * setter per impostare numero round
 * @param numeroRound 
 */
    public void impostaNumeroRound(int numeroRound) {
        this.numeroRound = numeroRound;
    }
/**
 * setter per impostare la classe di peso
 * @param classeDiPeso 
 */
    public void impostaClasseDiPeso(String classeDiPeso) {
        this.classeDiPeso = classeDiPeso;
    }
/**
 * setter per modificare il numero di round già assegnato
 * @param nuovoNumeroRound 
 */
    public void setNumeroRound(int nuovoNumeroRound) {
        this.numeroRound = nuovoNumeroRound;
    }
/**
 * setter per modificare la classe di peso già assegnata 
 * @param nuovaClasseDiPeso 
 */
    public void setClasseDiPeso(String nuovaClasseDiPeso) {
        this.classeDiPeso = nuovaClasseDiPeso;
    }
/**
 * setter per assegnare identificativo al match
 * @param idMatch 
 */
    public void setNumeroMatch(int idMatch) {
        this.numeroMatch = idMatch;
    }
/**
 * metodo tostring per visualizzare i dati dei singoli match
 * @return 
 */
    @Override
    public String toString() {
        return "Match {\n" +
                "  Numero del Match: " + numeroMatch + "\n" +
                "  Numero di Round: " + numeroRound + "\n" +
                "  Classe di Peso: " + classeDiPeso + "\n" +
                "  Fighter 1: " + fighter1 + "\n" +
                "  Fighter 2: " + fighter2 + "\n" +
                "  Premio Atleta: " + premioAtleta + "\n" +
                "}";
    }
}
