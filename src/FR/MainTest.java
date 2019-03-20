/**
 * @ Francois Auxietre
 */

package FR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MainTest {

    private static String nom1 = "all_absolute+.txt";
    private static String nom2 = "all_absolute-.txt";
    private static String test = "0 Begin 0\n" +
            "0 MTwilightWhelp 1\n" +
            "0 OTheCoin 1\n" +
            "0 ONerubianEgg 1\n" +
            "0 MLesserHeal 2\n" +
            "0 MLesserHeal 2\n" +
            "0 OAbusiveSergeant 2\n" +
            "0 OMortalCoil 2";

    public static void main(String[] args) throws IOException {

        /*
        baseDonneeCarte.ajouterCarte("carte1");
        baseDonneeCarte.ajouterCarte("carte2");
        baseDonneeCarte.ajouterCarte("carte1");
        baseDonneeCarte.ajouterCarte("carte1");
        af("-----");
        af(baseDonneeCarte.rendNomCarte(0));
        af(baseDonneeCarte.rendNomCarte(1));
        af(baseDonneeCarte.rendNomCarte(2));
        af(baseDonneeCarte.rendNomCarte(3));
        af("-----");
        af(""+baseDonneeCarte.estUnHero("carte1"));
        af(""+baseDonneeCarte.estUnHero("Shapeshift"));
        af(""+baseDonneeCarte.rendIdentifiantsCarte("carte1"));

        af(baseDonneeCarte.affiche());
        af(""+baseDonneeCarte.rendCompteur());


       // baseDonneeCarte.transforme(test, 2);

        af("-----construction des deck");
        Deck deck1 = new Deck(new BaseDonneeCarte());
        deck1.ajouterCarte("carte3");
        deck1.ajouterCarte("carte1");
        deck1.ajouterCarte("carte1");
        deck1.ajouterCarte("carte1");
        BaseDonneeCarte test = deck1.rendBaseDonneeCarte();
        af(""+deck1.rendIdentifiant());
        af(deck1.toString());
        Deck deck2 = deck1.duplique();construction du deck n°
        af(deck2.toString());
*/
        BaseDonneeCarte baseDonneeCarte = new BaseDonneeCarte();
        ExtractionDeck extractionDeck = new ExtractionDeck(baseDonneeCarte, nom1);
        ArrayList<HashMap<Integer, Deck>> listeDesDecks = extractionDeck.extracteDeck(baseDonneeCarte);
        //MainTest.af(""+listeDesDecks.size());
        File file = new File ("entree.txt");
        PrintWriter printWriter = new PrintWriter ("entree.txt");

        File filePatternMining =  new File("pattern.txt");
        PrintWriter printWriter1 = new PrintWriter("pattern.txt");


        String fin= "";

        for(HashMap<Integer, Deck> deckBase: listeDesDecks){
            for(Integer numeroDePartie : deckBase.keySet()){
                Deck deck = deckBase.get(numeroDePartie);
                ArrayList<Integer> liste = deck.rendListeDesNumerosDesCartes();

                liste.sort(Comparator.naturalOrder());

                //ici on avait les cas d'une entree avec juste un begin et pas de cartes
                if (liste.size()>0){
                    for(Integer n: liste){
                        printWriter.print(n);
                        printWriter.print(" ");
                    }
                    printWriter.println();
                }
            }
        }
        //MainTest.af(baseDonneeCarte.affiche());
        printWriter.close ();

        //partie pattern mining
        System.out.println("extraction des decks reussie");
        ArrayList<Donnee> donnees = new ArrayList<>();

        //TODO prevoir un curseur pour modifier le 8  80% et le 4 40%
        Generation.executeSpmf(8, "FPClose");
        Utilitaire.ecrit(donnees);
        System.out.println("Generation de FPclose ok");

        Donnee donnee = new Donnee();
        donnee.extracteDonnee(baseDonneeCarte);



    }
    public static void af(String chaine){
        System.out.println(chaine);

    }

    public static void af(int chaine){
        System.out.println(""+chaine);
    }
}
