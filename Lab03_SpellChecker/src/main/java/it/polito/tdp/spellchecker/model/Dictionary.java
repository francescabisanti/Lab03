package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	List <String> paroleIta= new LinkedList <String>();
	List <String> paroleEng= new LinkedList <String>();
	String lingua;
	public void loadDictionary(String language) {
		if(language.equals("Italiano")) {
			this.lingua="Italian";
		try {
			FileReader fr= new FileReader("src/main/resources/Italian.txt");
			BufferedReader br= new BufferedReader(fr);
			String word;
			while((word=br.readLine())!=null) {
				paroleIta.add(word);
			}
			br.close();
		}catch(IOException o) {
			System.out.println("Errore nella lettura del file");
		}
		}
		else if( language.equals("English")) {
			this.lingua="English";
			try {
				FileReader fr= new FileReader("src/main/resources/English.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					paroleEng.add(word);
				}
				br.close();
			}catch(IOException o) {
				System.out.println("Errore nella lettura del file");
			}
		}
	}
	public List <RichWord> spellCheckTextLinear (List <String> inputTextList){
		List <RichWord> lista= new LinkedList <RichWord>();
		if(lingua.equals("Italian")) {
			for(String s: inputTextList) {
				if(paroleIta.contains(s)) {
					RichWord parolaOkay= new RichWord(s, true);
					lista.add(parolaOkay);
					
				}
				else {
					RichWord parolaNo= new RichWord(s, false);
					lista.add(parolaNo);
				}
		}
		}
		else if(lingua.equals("English")) {
			for(String s: inputTextList) {
				if(paroleEng.contains(s)) {
					RichWord parolaOkay= new RichWord(s, true);
					lista.add(parolaOkay);
					
				}
				else {
					RichWord parolaNo= new RichWord(s, false);
					lista.add(parolaNo);
				}
		}
		}
		return lista;
	
	}
	public List <String> paroleSbagliate(List <RichWord> controlla){
		List <String> ritorno= new LinkedList <String>();
		for(RichWord r: controlla) {
			if(r.isCorretto()==false)
				ritorno.add(r.getParola());
		}
		return ritorno;
	}
	public List <RichWord> spellCheckTextDicotomic (List <String> inputTextList){
		List <RichWord> lista= new LinkedList <RichWord>();
		int minimo=0;
		int massimo=0;
		if(lingua.equals("Italian")) {
			
			minimo=0;
			massimo=paroleIta.size();
			
			for(String s: inputTextList) {
				boolean trovato=false;
				while(trovato==false) {
					
					int meta=(int)(massimo-minimo/2);
					minimo=0;
					massimo=paroleIta.size();
					String parolaMeta=paroleIta.get(meta);
					if(parolaMeta.equals(s)) {
					RichWord parolaOkay= new RichWord(s, true);
					lista.add(parolaOkay);
					trovato=true;
					
				}
				else if(s.compareTo(parolaMeta)>0) {
					
					minimo=meta;
					massimo=paroleIta.size();
					
				}
				else {
					massimo=meta;
									}
		}}
		}
		else if(lingua.equals("English")) {
			minimo=0;
			massimo=paroleEng.size();
			
			for(String s: inputTextList) {
				boolean trovato=false;
				while(trovato==false) {
					
					int meta=(int)(massimo-minimo/2);
					minimo=0;
					massimo=paroleIta.size();
					String parolaMeta=paroleEng.get(meta);
					if(parolaMeta.equals(s)) {
					RichWord parolaOkay= new RichWord(s, true);
					lista.add(parolaOkay);
					trovato=true;
					
				}
				else if(s.compareTo(parolaMeta)>0) {
					
					minimo=meta;
					massimo=paroleEng.size();
					
				}
				else {
					massimo=meta;
									}
		}}
		}
		return lista;
	
	}
}
