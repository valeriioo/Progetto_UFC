package com.mycompany._megaprogetto_galifivalerio;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Scanner;
/**
 * 
 * @author vale
 */
public class Torneo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nomeTorneo;
    private Match[] elencoMatch;
    private final int numMaxAtleti = 20;
    private final int NUM_MAX_MATCH = 100; //costante per la dimensione massima degli array di match
    private int numeroDiMatch;
    private LocalDateTime orarioTorneo;
/**
 * 
 * @param nomeTorneo 
 */
    public Torneo(String nomeTorneo) {
        this.nomeTorneo = nomeTorneo;
        this.numeroDiMatch = 0; // Imposta il numero di match iniziale a 0
        this.elencoMatch = new Match[NUM_MAX_MATCH]; // Creazione dell'array con dimensione massima 100
        this.orarioTorneo = LocalDateTime.now();
    }
/**
 * 
 * @return 
 */
    public LocalDateTime getOrarioTorneo() {
        return orarioTorneo;
    }
    
    public String getNomeTorneo() {
        return nomeTorneo;
    }

    public Match[] getElencoMatch() {
        return elencoMatch;
    }

    public int getNumeroDiMatch() {
        return numeroDiMatch;
    }
/**
 * metodo aggiungi match che consiste di aggiungere un match all'elenco
 * @param idMatch
 * @param match 
 */
    public void aggiungiMatch(int idMatch, Match match) {
        if (idMatch >= 1 && idMatch <= NUM_MAX_MATCH) {
            if (numeroDiMatch < NUM_MAX_MATCH) {
                // Verifica se l'ID inserito è già in uso
                boolean idInUso = false;
                for (int i = 0; i < numeroDiMatch; i++) {
                    if (elencoMatch[i] != null && elencoMatch[i].getNumeroMatch() == idMatch) {
                        idInUso = true;
                        break;
                    }
                }
                if (!idInUso) {
                    match.setNumeroMatch(idMatch);
                    elencoMatch[numeroDiMatch] = match;
                    numeroDiMatch++;
                } else {
                    System.out.println("L'ID inserito è già in uso. Si prega di scegliere un altro ID.");
                }
            } else {
                System.out.println("Impossibile aggiungere un nuovo match. Limite massimo raggiunto.");
            }
        } else {
            System.out.println("L'ID del match deve essere compreso tra 1 e " + NUM_MAX_MATCH + ".");
        }
    }
/**
 * metodo eliminamatch che consente di eliminare un match dalla lista di match presenti
 * @param idMatch 
 */
    public void eliminaMatch(int idMatch) {
        boolean matchTrovato = false;
        for (int i = 0; i < numeroDiMatch; i++) {
            if (elencoMatch[i] != null && elencoMatch[i].getNumeroMatch() == idMatch) {
                // Rimuovi il match e sposta gli elementi rimanenti a sinistra
                for (int j = i + 1; j < numeroDiMatch; j++) {
                    elencoMatch[j - 1] = elencoMatch[j];
                }
                elencoMatch[numeroDiMatch - 1] = null;
                numeroDiMatch--; // Decrementa il numero di match dopo l'eliminazione
                System.out.println("Il match con ID " + idMatch + " è stato eliminato con successo.");
                matchTrovato = true;
                break;
            }
        }
        if (!matchTrovato) {
            System.out.println("Nessun match trovato con l'ID specificato.");
        }
    }
/**
 * metodo tostring che consente la visualizzazione dei dati del torneo
 * @return 
 */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Torneo {\n");
        result.append("Nome del Torneo: ").append(nomeTorneo).append("\n");
        result.append("Orario del Torneo: ").append(orarioTorneo).append("\n\n");
        result.append("Match del Torneo:\n");
        for (Match match : elencoMatch) {
            if (match != null) {
                result.append(match.toString()).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
