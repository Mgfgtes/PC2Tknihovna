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
	
	public Kniha vyhledaniKnihy(String jmeno) {
		Kniha res=null;
		for (Iterator iterator = seznamKnih.iterator(); iterator.hasNext();) {
			Kniha kniha = (Kniha) iterator.next();
			if(kniha.getNazev().equals(jmeno)) {
				res=kniha;
			}
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
		for (Iterator iterator = seznamKnih.iterator(); iterator.hasNext();) {
			Kniha kniha = (Kniha) iterator.next();
			System.out.println(kniha);
		}
	}
	
	public void vypisAutora(String autor) {
		for (Iterator iterator = seznamKnih.iterator(); iterator.hasNext();) {
			Kniha kniha = (Kniha) iterator.next();
			if(kniha.getAutor().equals(autor)) {
				System.out.println(kniha);
			}
		}
	}
	
	public void vypisZanru(zanr z) {
		for (Iterator iterator = seznamKnih.iterator(); iterator.hasNext();) {
			Kniha kniha = (Kniha) iterator.next();
			if (kniha.instanceOf(kniha)=="Roman") {
				Roman roman = (Roman) kniha;
				if (roman.getZanr().equals(z)) {
					System.out.println(roman);
				}
			}
		}
	}
	
	public void vypisVypujcenych() {
		for (Iterator iterator = seznamKnih.iterator(); iterator.hasNext();) {
			Kniha kniha = (Kniha) iterator.next();
			if(kniha.getDostupnost()=="Zapujceno") {
				System.out.println(kniha);
			}
		}
	}
}
