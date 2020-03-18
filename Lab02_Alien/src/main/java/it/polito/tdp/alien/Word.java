package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class Word {

	private String alienWord;
	private List<String> traduzioni = new ArrayList<>();
	
	/**
	 * Creo una corrispondenza tra parola aliena e parola terrestre
	 * @param alienWord
	 * @param englishWord
	 */
	public Word(String alienWord) {
		super();
		this.alienWord = alienWord;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public void setEnglishWord(String englishWord) {
		this.traduzioni.add(englishWord);
	}
	
	public boolean cercaParolaTradotta(String parola) {
		if(this.traduzioni.contains(parola)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if(traduzioni.size()==1) {
			return "Traduzione per "+this.alienWord+": "+this.traduzioni.get(0)+"\n";
		}
		else {
			String output = "Traduzioni per "+this.alienWord+":\n";
			for(String t: traduzioni) {
				output += t+";\n";
			}
			return output;
		}
		
	}
	
	public String outputWildCard() {
		
		if(traduzioni.size()==1) {
			return this.traduzioni.get(0)+"\n";
		}
		else {
			String output = "Traduzioni per "+this.alienWord+":\n";
			for(String t: traduzioni) {
				output += t+";\n";
			}
			return output;
		}
	}
	
	
}
