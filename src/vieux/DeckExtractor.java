import java.io.IOException;
import java.util.ArrayList;

public class DeckExtractor {
/*
	private String datafile; // name of the data file
	
	private CardDatabase cardDb;
	
	public DeckExtractor(String file, CardDatabase cardDb) {
		this.cardDb = cardDb;
		this.datafile = file;
	}
	
	/**
	 * Get all the decks
	 * @return ArrayList<Deck1> The list of decks
	 * @throws IOException

	public ArrayList<Deck> getDecks() throws IOException{
		ArrayList<Deck> temp = new ArrayList<Deck>();
		
		String[] fileContent = FileUtils.asStringArray(datafile);
		
		int currentGameNum = 0;
		
		Deck currentDeckO = new Deck(cardDb);
		Deck currentDeckM = new Deck(cardDb);
		
		for(String s: fileContent) {
			
			String[] tmp = s.split(" ");
			
			int gameNum = Integer.parseInt(tmp[0]);
			if(gameNum != currentGameNum) {
				temp.add(currentDeckO.copy());
				temp.add(currentDeckM.copy());
				currentDeckO = new Deck(cardDb);
				currentDeckM = new Deck(cardDb);
				currentGameNum = gameNum;
			}
			
			if(tmp[1].compareTo("Begin") != 0) {	
				char player = tmp[1].charAt(0);
				String cardName = tmp[1].substring(1);
				if(cardName.compareTo("TheCoin") != 0) {
					if(player == 'O'){
						currentDeckO.addCard(cardName);
					} else {
						currentDeckM.addCard(cardName);
					}
				}
			}
		}
		
		return temp;




    int numeroActuel =0;
    Deck monDeck = new Deck(baseDonneeCarte);
    Deck autreDeck = new Deck(baseDonneeCarte);

        for(String s: fichierSplitter){
        int numeroDeLaPartie = Integer.parseInt(fichierSplitter[0]);
        int compteurCarte =0;

        if (numeroDeLaPartie != numeroActuel){ // on a change de partie
            listeDesDecks.add(monDeck);
            listeDesDecks.add(autreDeck);
            monDeck = new Deck(baseDonneeCarte);
            autreDeck = new Deck(baseDonneeCarte);
            numeroActuel = numeroDeLaPartie;
        }
        if (fichierSplitter[1].compareTo("Begin") !=0){
            //on recup le numero du joueur
            String joueur =  "" + fichierSplitter[1].charAt(0);
            System.out.println("joueur " + joueur);
            String nomDeLaCarte =  fichierSplitter[1].substring(1);
            compteurCarte++;
            System.out.println("carte n° "+ compteurCarte + " "  + nomDeLaCarte);
            if(nomDeLaCarte.compareTo("TheCoin") != 0) {
                if(joueur.equals("O")) {
                    monDeck.ajouterCarte(nomDeLaCarte);
                }
                else
                {
                    autreDeck.ajouterCarte(nomDeLaCarte);
                }
            }
        }
    }
	*/
}
