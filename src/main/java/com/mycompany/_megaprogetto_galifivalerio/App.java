package com.mycompany._megaprogetto_galifivalerio;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        // Creazione di un nuovo torneo con un massimo di 100 match
        Torneo t1 = new Torneo("Mega Torneo");
        System.out.println("Orario del torneo: " + t1.getOrarioTorneo() + " (orario attuale)");

        boolean esci = false;
        while (!esci) {
            // Menu principale
            System.out.println("\nMENU:");
            System.out.println("1. Aggiungi un match");
            System.out.println("2. Modifica un match");
            System.out.println("3. Elimina un match");
            System.out.println("4. Mostra i dati del torneo");
            System.out.println("5. Mostra i match presenti");
            System.out.println("6. Esci");

            System.out.print("Scelta: ");
            int scelta = Integer.parseInt(tastiera.nextLine());

            switch (scelta) {
                case 1:
                    aggiungiMatch(t1, tastiera);
                    break;
                case 2:
                    modificaMatch(t1, tastiera);
                    break;
                case 3:
                    System.out.print("Inserisci l'ID del match da eliminare: ");
                    int idMatchDaEliminare = Integer.parseInt(tastiera.nextLine());
                    t1.eliminaMatch(idMatchDaEliminare);
                    break;
                case 4:
                    mostraDatiTorneo(t1);
                    break;
                case 5:
                    mostraMatchPresenti(t1);
                    break;
                case 6:
                    esci = true;
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }
    }

    private static void aggiungiMatch(Torneo torneo, Scanner tastiera) {
    // Verifica se c'è spazio per aggiungere un match
    if (torneo.getNumeroDiMatch() < torneo.getElencoMatch().length) {
        System.out.print("Identificativo del match: ");
        int idMatch = Integer.parseInt(tastiera.nextLine());
        if (idMatch >= 1 && idMatch <= 100) { // Validazione dell'ID del match
            System.out.print("Nome del primo fighter: ");
            String fighter1 = tastiera.nextLine();
            System.out.print("Nome del secondo fighter: ");
            String fighter2 = tastiera.nextLine();
            int numeroRound = richiediNumeroRound(tastiera);

            System.out.print("Classe di peso: ");
            String classeDiPeso = tastiera.nextLine();

            // Aggiunta del vincitore
            System.out.print("Vincitore del match: ");
            String vincitore = tastiera.nextLine();

            // Controllo se il vincitore corrisponde a uno dei fighter
            if (!vincitore.equalsIgnoreCase(fighter1) && !vincitore.equalsIgnoreCase(fighter2)) {
                System.out.println("Il vincitore deve essere uno dei fighter. Riprova.");
                return;
            }

            // Aggiunta del premio
            System.out.print("Premio per il vincitore (in euro): ");
            double premio = Double.parseDouble(tastiera.nextLine());

            Match match = new Match(idMatch, numeroRound, classeDiPeso, fighter1, fighter2);
            match.setVincitore(vincitore); // Imposta il vincitore del match
            match.setPremioAtleta(premio); // Imposta il premio per il vincitore
            torneo.aggiungiMatch(idMatch, match);
            System.out.println("Match aggiunto con successo.");
        } else {
            System.out.println("L'ID del match deve essere compreso tra 1 e 100.");
        }
    } else {
        System.out.println("Impossibile aggiungere un nuovo match. Limite massimo raggiunto.");
    }
}

    private static void modificaMatch(Torneo torneo, Scanner tastiera) {
        System.out.print("Inserisci l'identificativo del match da modificare: ");
        int idMatchDaModificare = Integer.parseInt(tastiera.nextLine());

        Match matchDaModificare = null;
        for (Match match : torneo.getElencoMatch()) {
            if (match != null && match.getNumeroMatch() == idMatchDaModificare) {
                matchDaModificare = match;
                break;
            }
        }

        if (matchDaModificare != null) {
            System.out.println("Match attuale: " + matchDaModificare.toString());

            System.out.print("Nuovo numero di round (3 o 5): ");
            int nuovoNumeroRound = Integer.parseInt(tastiera.nextLine());

            System.out.print("Nuova classe di peso: ");
            String nuovaClasseDiPeso = tastiera.nextLine();

            matchDaModificare.setNumeroRound(nuovoNumeroRound);
            matchDaModificare.setClasseDiPeso(nuovaClasseDiPeso);
            System.out.println("Match modificato con successo.");
        } else {
            System.out.println("Nessun match trovato con l'identificativo specificato.");
        }
    }

    private static void mostraDatiTorneo(Torneo torneo) {
        System.out.println("Dati del Torneo:");
        System.out.println("Nome del Torneo: " + torneo.getNomeTorneo());
        System.out.println("Orario del Torneo: " + torneo.getOrarioTorneo() + "\n");

        System.out.println("Match del Torneo:");
        for (Match match : torneo.getElencoMatch()) {
            if (match != null) {
                System.out.println(match.toString() + "\n");
            }
        }
    }

    private static void mostraMatchPresenti(Torneo torneo) {
        System.out.println("Match presenti nel Torneo:");
        for (Match match : torneo.getElencoMatch()) {
            if (match != null) {
                System.out.println(match.toString());
            }
        }
    }

    private static int richiediNumeroRound(Scanner tastiera) {
        int numeroRound = 0;
        boolean inputCorretto = false;

        while (!inputCorretto) {
            try {
                System.out.print("Numero di round (3 o 5): ");
                numeroRound = Integer.parseInt(tastiera.nextLine());
                if (numeroRound != 3 && numeroRound != 5) {
                    throw new RoundException("Il numero di round deve essere 3 o 5.");
                }
                inputCorretto = true;
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
            } catch (RoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return numeroRound;
    }
}
