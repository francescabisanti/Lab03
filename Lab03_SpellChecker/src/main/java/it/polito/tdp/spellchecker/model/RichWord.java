package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;
import java.util.List;

public class RichWord {
	String parola;
	boolean corretto;
	List <RichWord> parole= new LinkedList <RichWord>();
	public RichWord(String parola, boolean corretto) {
		
		this.parola = parola;
		this.corretto = corretto;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isCorretto() {
		return corretto;
	}
	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}
	
}
