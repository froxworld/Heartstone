/**
 * @ Francois Auxietre
 */

package FR;

import java.util.ArrayList;

public class ExtractionDonnee {

    private String nomDuFichier; // nomDuFichier
    private BaseDonneeCarte baseDonneeCarte;


    /**
     * constructeur par defaut
     * @param baseDonneeCarte : ensemble de toutes les cartes
     * @param nomDuFichier : nom du fichier à parser
     */
    public ExtractionDonnee(BaseDonneeCarte baseDonneeCarte, String nomDuFichier){
        this.baseDonneeCarte = baseDonneeCarte;
        this.nomDuFichier = nomDuFichier;
    }


    public ArrayList<SequenceDeDonnee> extractionDeDonnee() {
        return new ArrayList<SequenceDeDonnee>();
    }
}
