package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AlienDictionary {

	List <Word> dictionary = new ArrayList<>();
	
	public String newAlienWord(String input) {
		
		//Controllo che la stringa contenga solo caratteri alfabetici
		String controll = "[a-zA-Z ?]*";
		if(!input.matches(controll)) {
			return "Inserire SOLO caratteri alfabetici!\n";
		}
		//Cerco se la stringa contenga uno spazio
		if(input.contains(" ")) {
			
			//Ho trovato uno spazio, si sta cercando di inserire una nuova parola nel dizionario
			StringTokenizer st = new StringTokenizer(input, " ");
			String alienWord = st.nextToken().trim();
			String traduzione = st.nextToken().trim();
			
			//Controllo che la parola non sia gia' presente
			for(Word w: dictionary) {
				if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
					
					/*
					 * Parola trovata
					 * Controllo se sia presente anche la traduzione in input
					 */
					if(w.cercaParolaTradotta(traduzione)) {
						return "Traduzione gia' presente nel Dizionario!";
					}
					
					/*
					 * Non ho trovato la nuova traduzione, la aggiungo al dizionario
					 */
					w.setEnglishWord(traduzione);
					return traduzione+" aggiunta alle traduzioni possibili di "+alienWord+"\n";
				}
			}
			
			//Non ho trovato la parola, la aggiungo al dizionario
	    	Word word = new Word(alienWord);
	    	word.setEnglishWord(traduzione);
	    	dictionary.add(word);
	    	return alienWord+" e' stata aggiunta al dizionario! (Traduzione: "+traduzione+")\n";
		}
		else {
			
			/**
			 * la stringa non contiene uno spazio, cio vuol dire che l'utente
			 * sta cercando una parola nel dizionario
			 */
			if(input.contains("?")) {
				String output;
				List<Word> wildCard = new ArrayList<>();
				
				wildCard = wildCard(input.substring(0, input.indexOf("?")), input.substring(input.indexOf("?")+1), input.indexOf("?"));
				if(wildCard.size()!=0) {
					if(wildCard.size()==1) {
						return "Possibile match per l'input "+input+":\n"+wildCard.get(0).outputWildCard();
					}
					else {
						
						output = "Possibile match per l'input "+input+":\n";
						for(Word w: wildCard) {
							output += w.outputWildCard();
						}
						return output;
					}
				}
				return "Nessun match trovato!\n";
			}
				
			try {
			
				String result = cercaParola(input).toString();
				return result;
				
			}catch(NullPointerException npe) {
				
				return "Parola non ancora presente sul Dizionario!\n";
			}
		}
		
	}

	public Word cercaParola(String text) {
		
		for(Word w: dictionary) {
			if(w.getAlienWord().toLowerCase().equals(text.toLowerCase())) {
				return w;
			}
		}
		return null;
	}

	public List<Word> wildCard(String first, String second, int position) {
		
		List<Word> wildCard = new ArrayList<>();
		
		for(Word w: dictionary) {
			
			String one = w.getAlienWord().substring(0, position);
			String two = w.getAlienWord().substring(position+1);
			
			if(first.equals(one) && second.equals(two)) {
				wildCard.add(w);
			}
		}
		
		return wildCard;
	}
}
