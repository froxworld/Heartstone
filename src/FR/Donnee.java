/**
 * @ Francois Auxietre
 */

package FR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Donnee {

    private String nomDuFichierEntree = "sortie.txt";
    private String nomDuFichierSortie = "pattern.txt";


    public String transforme(String chaine, int valeur, BaseDonneeCarte baseDonneeCarte) {


        StringBuffer tampon = new StringBuffer();
        String[] lignes = chaine.split("\n");

        for (String ligne : lignes) {
            String[] debutLigne = ligne.split("#SUP:");

            //int taille = debutLigne.length;
            String nombreElement = debutLigne[debutLigne.length-1];

            String[] listeDesCartes = debutLigne[0].split(" ");
            if (listeDesCartes.length>1){
               tampon.append("les cartes : ");
                for(int i=0; i<listeDesCartes.length; i++){
                    int nombre = Integer.parseInt(listeDesCartes[i]);
                    //MainTest.af(nombre);
                    String nomDeLaCarte = baseDonneeCarte.rendNomCarte(nombre);
                    //MainTest.af(nomDeLaCarte);
                    tampon.append(nomDeLaCarte + " (N° "+ nombre + "), ");
                    }
                    tampon.append("sont en nombre de"+ nombreElement + " exemplaires");
            }
            else{
                int nombre = Integer.parseInt(debutLigne[1].substring(1));
                if (listeDesCartes.length - 1 >= valeur) {
                    for (String sousLigne : listeDesCartes) {
                        int identifiantTemporaire = Integer.parseInt(sousLigne);
                        if (identifiantTemporaire != -1) {
                            String nomDeLaCarte = baseDonneeCarte.rendNomCarte(identifiantTemporaire);
                            tampon.append("la carte " +nomDeLaCarte + " (N° "+ identifiantTemporaire + ") est en ");
                        } else {
                            tampon.append(" | ");
                        }
                        tampon.append(  nombre + " exemplaires");
                    }
                }
            }

        }
        return tampon.toString();
    }



    public void extracteDonnee(BaseDonneeCarte baseDonneeCarte) throws IOException {

        HashMap<String, ArrayList<Integer>> carte = new HashMap<>();
        URL url = getClass().getResource("/"+this.nomDuFichierEntree);
        //MainTest.af(url.toString());
        File file1 = new File(url.getPath());
        Scanner scanner;
        MainTest.af("----------------------extraction -------------------------");
        try {
            scanner = new Scanner(file1);
            while (scanner.hasNext()) {
                String ligne = scanner.nextLine();
                MainTest.af(transforme(ligne, 0, baseDonneeCarte));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
