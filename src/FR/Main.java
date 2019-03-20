/**
 * @ Francois Auxietre
 */

package FR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    private static String nom1 = "all_absolute+.txt";
    private static String nom2 = "all_absolute-.txt";

    public static void main(String[] args){
        BaseDonneeCarte baseDonneeCarte =  new BaseDonneeCarte();
        ExtractionDeck extractionDeck = new ExtractionDeck(baseDonneeCarte, nom1);
        ArrayList<HashMap<Integer, Deck>>  listeDesDecks = extractionDeck.extracteDeck(baseDonneeCarte);
        System.out.println("extraction des decks reussie");
        ArrayList<Donnee> donnees = new ArrayList<>();

    /*
        for (HashMap<Integer, Deck> deck: listeDesDecks){
            donnees.add(deck.convertiEnDonnee());
        }
        */
        //TODO prevoir un curseur pour modifier le 8  80% et le 4 40%
        Generation.executeSpmf(8, "FPClose");
        Utilitaire.ecrit(donnees);
        System.out.println("Generation de FPclose ok");

        ExtractionDonnee extractionDonnee = new ExtractionDonnee(baseDonneeCarte, nom1);
        ArrayList<SequenceDeDonnee> sequenceDeDonnees = extractionDonnee.extractionDeDonnee();
        System.out.println("les sequence sont chargees depuis le fichier :" + nom1);
        Utilitaire.ecritSequence(sequenceDeDonnees);


        Generation.executeSpmf(4, "CloSpan");
        String resultat = null;
        try {
            resultat = Utilitaire.lireFichierSortie();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(resultat);
        //System.out.println(baseDonneeCarte.transforme(resultat, 2));
    }
}
