/**
 * @ Francois Auxietre
 */

package FR;

import java.util.ArrayList;
import java.util.HashMap;


public class BaseDonneeCarte {

    private int compteur;
    private HashMap<String, ArrayList<Integer>> baseDonnee;
    public static ArrayList<String> pouvoirsDesHeros;

    public  int rendCompteur(){
        return this.compteur;
    }


    /**
     * constructeur par defaut
     */
    public BaseDonneeCarte() {
        compteur = 0;
        this.baseDonnee = new HashMap<>();
        initialise();
    }

    public ArrayList<String> rendPouvoirDesHeros(){

        return this.pouvoirsDesHeros;
    }

    public HashMap<String, ArrayList<Integer>> rendBase(){

        return this.baseDonnee;
    }

    /**
     * initialisation des pouvoirs des heros
     */
    private void initialise() {
        pouvoirsDesHeros = new ArrayList<String>();
        String[] pouvoir = {"Shapeshift", "SteadyShot", "Fireblast", "Reinforce", "LesserHeal", "DaggerMastery", "TotemicCall", "LifeTap", "ArmorUp!"};
        for (String s : pouvoir) {
            pouvoirsDesHeros.add(s);
        }
    }


    public boolean estUnHero(String carte) {
        //TODO verifier si le string passe en argument est un hero
        boolean retour = false;
        if (pouvoirsDesHeros.contains(carte)) {
            MainTest.af("la carte " + carte + " est un hero");
            retour = true;
        }
        return retour;
    }


    /**
     * permet de savoir avant de rajouter une carte si on est pas deja au maximum
     * le parametre <=1 pourra etre mis en final pour tout parametrer
     * si le jeu passait par exmple à trois ou à une seule carte par deck
     * @param carte
     * @return  vrai: boolean  si on peut encore ajouter la carte
     *          faux sinon
     */
    public boolean ajoutableCarte(String carte){
        boolean retour= false;
        if (baseDonnee.containsKey(carte)){
            ArrayList<Integer> liste = baseDonnee.get(carte);
            if (liste.size()<=1){
                retour = true;
            }
        }else
        {
            retour = true;
        }
        return retour;
    }


    /**
     * on ajoute deux cartes identiques car le joueur peut avoir dans son deck deux fois le meme carte
     * ajoute une carte a la base de donnee
     *
     * @param carte : un string nom de la carte en string
     */
    public int ajouterCarte(String carte) {
        //MainTest.af("compteur " +compteur);
    if(!pouvoirsDesHeros.contains(carte)) {
        if (baseDonnee.containsKey(carte)) {

                //MainTest.af("une premiere carte existe deja du nom de " + carte);
                ArrayList<Integer> listeTemp = baseDonnee.get(carte);
                compteur++;
                listeTemp.add(compteur);
                baseDonnee.replace(carte, listeTemp);
                //MainTest.af("ajout " +carte + " "+ compteur + " "+ listeTemp.size());

        }

        if (!baseDonnee.containsKey(carte)) {
            ArrayList<Integer> liste = new ArrayList<>();
            compteur++;
            liste.add(compteur);
            baseDonnee.put(carte, liste);
            //MainTest.af("ajout" +carte + " "+ compteur);

        }
    }

        return compteur;
    }


    /**
     * retourne le nom de la carte en fonction de son identifiant (2 par carte)
     *
     * @param valeur : l identifiant de la carte
     * @return String :le nom de la carte en string
     */
    public String rendNomCarte(int valeur) {
        String retour = "";
        if (valeur < compteur) {
            for (String cle : baseDonnee.keySet()) {
                ArrayList<Integer> listeTemp = baseDonnee.get(cle);
                if (listeTemp.contains(valeur)) {
                    //System.out.println("la carte " + cle +" (N° " + valeur + " ): en  " + listeTemp.size() + " exemplaires");
                    retour = cle;
                }
            }
        }
        else {

            //System.out.println("pas de carte avec l' Identifiant "+ valeur);
            retour = "";

        }
        return retour;
    }


    /**
     * retourne la liste des  identifiants de la carte dans la base de donnee
     *
     * @param carte le nom de la carte
     * @return ArrayList<Integer> : une liste des valeurs possible de la carte 0<carte<=2
     */
    public ArrayList<Integer> rendIdentifiantsCarte(String carte) {
        ArrayList<Integer> retour = new ArrayList<>();
        if (baseDonnee.containsKey(carte)) {
            ArrayList<Integer> listeTemp = baseDonnee.get(carte);
            ArrayList<Integer> liste = new ArrayList<>();
            for(Integer iteration :listeTemp){
                liste.add(iteration);
            }
            retour = liste;

        } else {
            System.out.println("la carte n 'existe pas dans la base");
        }
        return retour;
    }



    /**
     * affiche toutes les cartes qui sont dans la base de donnee
     *
     * @return String :la liste des cartes de la base
     */
    public String affiche() {
        StringBuffer buffer = new StringBuffer();
        for(String cle :baseDonnee.keySet()){

            MainTest.af(cle + baseDonnee.get(cle));

        }


        ArrayList<String> listeDesCles = new ArrayList<>(baseDonnee.keySet());


        //listeDesCles.sort(String.CASE_INSENSITIVE_ORDER);

        for(String cle:listeDesCles){
            ArrayList<Integer> liste = baseDonnee.get(cle);
            /*
            if (baseDonnee.get(cle).size()==1){
                //correction de l'indice a affichage on pourra commencer a 1
                buffer.append("Nom : " + cle + " | " + liste.get(0)+ "\n");
            }
            else{
            */
                buffer.append("Nom : " + cle);
                for (int i=0; i< baseDonnee.get(cle).size();i++){
                    buffer.append(" |  " + liste.get(i));
                }
               buffer.append("\n");

        }
        return buffer.toString();
    }


    public String transforme(String chaine, int valeur) {
        StringBuffer tampon = new StringBuffer();
        String[] lignes = chaine.split("\n");
        for (String ligne : lignes) {
            String[] debutLigne = ligne.split("#SUP:");
            String[] listeDesCartes = debutLigne[0].split(" ");
            int nombre = Integer.parseInt(debutLigne[1].substring(1));
            if (listeDesCartes.length - 1 >= valeur) {
                for (String sousLigne : listeDesCartes) {
                    int identifiantTemporaire = Integer.parseInt(sousLigne);
                    if (identifiantTemporaire != -1) {
                        String nomDeLaCarte = this.rendNomCarte(identifiantTemporaire);
                        tampon.append(nomDeLaCarte + " ");
                    } else {
                        tampon.append(" | ");
                    }
                    tampon.append(" || Support :" + nombre + "\n");
                }
            }
        }
        return tampon.toString();
    }
}