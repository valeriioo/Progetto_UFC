/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany._megaprogetto_galifivalerio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TorneoTest {

    @Test
    public void testAggiungiMatch() {
        // Creazione di un nuovo torneo
        Torneo torneo = new Torneo("Mio Torneo");

        // Creazione di due match da aggiungere
        Match match1 = new Match(1, 3, "Pesi massimi", "Fighter1", "Fighter2");
        Match match2 = new Match(2, 3, "Pesi medi", "Fighter3", "Fighter4");

        // Aggiunta dei match al torneo
        torneo.aggiungiMatch(1, match1);
        torneo.aggiungiMatch(2, match2);

        // Verifica se i match sono stati correttamente aggiunti
        Match[] elencoMatch = torneo.getElencoMatch();
        assertEquals(match1, elencoMatch[0]); // Verifica che il primo match sia stato aggiunto correttamente
        assertEquals(match2, elencoMatch[1]); // Verifica che il secondo match sia stato aggiunto correttamente
        assertEquals(2, torneo.getNumeroDiMatch()); // Verifica che il numero di match sia corretto
    }
}
