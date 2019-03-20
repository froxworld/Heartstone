/**
 * @ Francois Auxietre
 */

package FR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Deck {

    private int nombreTotalDeDeck = 0;
    private BaseDonneeCarte baseDonneeCarte;
    private ArrayList<String> listeDesCartes;
    private HashMap<Integer, HashMap<String, ArrayList<Integer>>> listeDesNumerosDesCartes;
    private int numeroDeLaPartie;




    /**
     * constructeur par defaut
     *
     * @param baseDonneeCarte base de donnee des cartes courantes du joueur
     */
    public Deck(BaseDonneeCarte baseDonneeCarte, int numeroDeLaPartie) {
        this.baseDonneeCarte = baseDonneeCarte;
        this.numeroDeLaPartie = numeroDeLaPartie;
        nombreTotalDeDeck++;
        this.listeDesCartes = new ArrayList<>();
        this.listeDesNumerosDesCartes = new HashMap<>();
    }


    /**
     * constructeur de deck avec un numero de la partie
     *
     * @param baseDonneeCarte   base de donnee des crates courantes du joueur
     * @param numeroDeLaPartie : int numero de la partie
     */
    public Deck(BaseDonneeCarte baseDonneeCarte, int numeroDeLaPartie, ArrayList<String> listeDesCartes) {
        this.baseDonneeCarte = baseDonneeCarte;
        this.numeroDeLaPartie = numeroDeLaPartie;
        this.listeDesCartes = listeDesCartes;
    }

    public ArrayList<String> rendListeDesCartes(){
        return this.listeDesCartes;
    }

    public int nombreOccurence(String carte, ArrayList<String> liste){
        int compteur =0;
        for(String c:liste){

            if (c.equals(carte)){
                compteur++;
               // MainTest.af("com"+ carte+ " "+ compteur);
            }
        }
        return compteur-1;
    }


    public ArrayList<Integer> rendListeDesNumerosDesCartes(){
        BaseDonneeCarte base = this.baseDonneeCarte;
        ArrayList<String> pouvoirsDesHeros = baseDonneeCarte.rendPouvoirDesHeros();
        StringBuffer buffer = new StringBuffer();
        ArrayList<String> nouvelleListe = new ArrayList<>();
        ArrayList<Integer> listeFinale = new ArrayList<>();

        for(int i=0; i<this.listeDesCartes.size(); i++){
            String carte = listeDesCartes.get(i);
            //MainTest.af(""+listeDesCartes.size());

            int compteur =0;

            if(!pouvoirsDesHeros.contains(carte)){
                nouvelleListe.add(carte);
                compteur=nombreOccurence(carte,nouvelleListe);
                    //MainTest.af("o"+compteur);
                ArrayList<Integer> liste = baseDonneeCarte.rendBase().get(carte);

                int numero = liste.get(compteur);
                //MainTest.af(carte + " "+ numero+  " " +liste.size());
                buffer.append(""+numero+ " ");
                listeFinale.add(numero);
                //liste.remove(0);
                //HashMap<String, ArrayList<Integer>> nouvelleBase = base.rendBase();
                //nouvelleBase.replace(carte, liste);
                //nouvelleListe.add(carte);
            }
        }
       return listeFinale;
    }

    public BaseDonneeCarte rendBaseDonneeCarte(){
        return this.baseDonneeCarte;
    }


    /**
     * ajouter une carte au deck avec la verification qu'elle ne sera pas plus de deux fois
     * @param carte : String la carte a ajouter
     */
    public void ajouterCarte(String carte, int numeroCarte) {

        //MainTest.af(" carte  "+ numeroCarte);
        this.listeDesCartes.add(carte);
    }


    /**
     * retourne lidentifiant du joueur
     *
     * @return int : identifiant du joueur
     */
    public int rendNumeroDeLaPartie() {
        return this.numeroDeLaPartie;
    }


    /**
     * toString concatenene la liste des cartes
     *
     * @return string : correspondant a la liste des carte
     */
    public String toString() {

        StringBuffer chaine = new StringBuffer();/*
        for (String carte : listeDesCartes.keySet()) {
            chaine.append(carte);
            chaine.append("\n");
        }
        */
        return chaine.toString();
    }


    public Deck duplique() {
        Deck deck = new Deck(this.baseDonneeCarte, this.numeroDeLaPartie, this.listeDesCartes);
        MainTest.af("nouveau deck de la partie n°"+ this.numeroDeLaPartie+ " construit");
        return deck;
    }


    public Donnee convertiEnDonnee() {

        int[] listeDonnee = new int[listeDesCartes.size()];
        int identifiant = 0;
        /*
        for (String carte : listeDesCartes.keySet()) {
            ArrayList<Integer> listeDesIdentifiant;

            //int tmp = baseDonneeCarte.rendIdentifiantCarte(carte);
            //listeDonnee[identifiant] = tmp;
            identifiant++;
        }
        Arrays.sort(listeDonnee);
        */
        return new Donnee();

    }
}