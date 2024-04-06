package knihovna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	
	public Kniha vyhledaniKnihy(String jmeno) {
		Kniha res=null;
		for (Kniha kniha : seznamKnih) {
			if(kniha.getNazev().equals(jmeno)) res=kniha;
		}
		return res;
	}
	
	public void removeKniha(String jmeno) {
		seznamKnih.remove(vyhledaniKnihy(jmeno));
	}
	
	public void zapujceniKnihy(String jmeno) {
		vyhledaniKnihy(jmeno).Vypujceni();
	}
	
	public void vraceniKnihy(String jmeno) {
		vyhledaniKnihy(jmeno).Vraceni();
	}
	
	public void infoKniha(String jmeno) {
		System.out.println(vyhledaniKnihy(jmeno));
	}
	
	public void vypisDatabazeKnih() {
		for (Kniha kniha : seznamKnih) System.out.println(kniha);
	}
	
	public void vypisAutora(String autor) {
		List<Kniha> rokSorted = new ArrayList<Kniha>();
		
		for (Kniha kniha : seznamKnih) {
			if(kniha.getAutor().equals(autor)) {
				rokSorted.add(kniha);
			}
		}
		Collections.sort(rokSorted, new KnihaComparator());
		
		for (Kniha kniha : rokSorted) {
			System.out.println(kniha);
		}
	}
	
	public void vypisZanru(zanr z) {
		for (Kniha kniha : seznamKnih) {
			if (kniha.instanceOfRoman(kniha)) {
				Roman roman = (Roman) kniha;
				if (roman.getZanr().equals(z)) {
					System.out.println(roman);
				}
			}
		}
	}
	
	public void vypisVypujcenych() {
		for (Kniha kniha : seznamKnih) {
			if(kniha.getDostupnost()=="Zapujceno") {
				System.out.println(kniha);
			}
		}
	}
}
