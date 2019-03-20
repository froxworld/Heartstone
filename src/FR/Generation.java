/**
 * @ Francois Auxietre
 */

package FR;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Generation {

// lancement avec FPClose et avec CloSpan


    public static void executeSpmf(int pourcentage, String nomDataMining) {


        Path sortieChemin = FileSystems.getDefault().getPath("sortie.txt");
        Path entreeChemin = FileSystems.getDefault().getPath("entree.txt");
        System.out.println("generation" + sortieChemin);
        String spmf = "java -jar Ressources" + File.separator + "spmf.jar run " + nomDataMining + " "+ entreeChemin.toString() + " " + sortieChemin.toString() + " " + pourcentage + "%";
        System.out.println("commande:"+ spmf);
        if (Files.exists(sortieChemin)) {
            System.out.println("voulez vous suprimer l'ancien fichier de sortie ?  O/N");
            Scanner scanner = new Scanner(System.in);

            if (scanner.nextLine().equals("O") || scanner.nextLine().equals("o")) {
                try {
                    Files.delete(sortieChemin);
                    Runtime runtime = Runtime.getRuntime();
                    Process process = runtime.exec(spmf);
                    try {
                        process.waitFor();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                System.out.println("faire une copie de l'ancien ");
                //TODO faire une duplication de l ancien fichier avant de l effacer
            }
        }else
        {
            System.out.println("fichier n existe pas");
        }
    }
}

