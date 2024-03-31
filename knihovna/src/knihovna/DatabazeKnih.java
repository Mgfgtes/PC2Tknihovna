package knihovna;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import knihovna.Roman.zanr;

public class DatabazeKnih {
	
	private Set<Kniha> seznamKnih;
	
	public DatabazeKnih() {
		seznamKnih = new TreeSet<>();
	}
	
	public boolean addRoman(String nazev, String autor, int rok, zanr Zanr)
	{
		if (seznamKnih.add(new Roman(nazev, autor, rok, Zanr)))
			return true;
		else
			return false;
	}
	
	public boolean addUcebnice(String nazev, String autor, int rok, int vhodnyRocnik) 
	{
		
		if (seznamKnih.add(new Ucebnice(nazev, autor, rok, vhodnyRocnik)))
			return true;
		else
			return false;
		
	}
	
	public void removeKniha(String jmeno) {
		for (Iterator iterator = seznamKnih.iterator(); iterator.hasNext();) {
			Kniha kniha = (Kniha) iterator.next();
			if(kniha.getNazev().equals(jmeno)) {
				seznamKnih.remove(kniha);
			} 
			
		}
		
	}
	
	public void editKniha() {
		
	}
	
	
	public void vypisDatabazeKnih() {
		for (Iterator iterator = seznamKnih.iterator(); iterator.hasNext();) {
			Kniha kniha = (Kniha) iterator.next();
			System.out.println(kniha);
			
		}
	}
		
}
