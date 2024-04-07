package knihovna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import knihovna.Roman.zanr;

public class DatabazeKnih {
	
	private Set<Kniha> seznamKnih;
	
	public DatabazeKnih() {
		seznamKnih = new TreeSet<>();
	}
	
	public void pridaniKnihy() {
		String nazev = null, autor;
		int rok, sel;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println(" 1 \t Roman \n 2 \t Ucebnice");
			sel = sc.nextInt();
			if(sel>2 || sel<1) System.out.println("Neznamy druh knihy");
		} while (sel>2 || sel<1);
		
		
		System.out.println("Zadejte nazev knihy:");
		nazev = sc.nextLine();
		nazev = sc.nextLine();
		
		System.out.println("\nZadejte jmeno autora knihy:");
		autor = sc.nextLine();
		
		System.out.println("\nZadejte rok vydani knihy:");
		rok = sc.nextInt();
		
		
		if (sel==1) {
			Boolean isCreated=false;
			do {
				System.out.println("\nZadejte zanr romanu:");
				try {
					zanr z = zanr.valueOf(sc.next());
					addRoman(nazev, autor, rok, z);
					isCreated = true;
				} catch (Exception e) {
					System.out.println(e);
				}
			} while (!isCreated);
			
		}else if (sel==2) {
			Boolean isCreated=false;
			do {
				System.out.println("\nZadejte rocnik pro ktery je ucebnice vhodna:");
				try {
					int roc = sc.nextInt();
					addUcebnice(nazev, autor, rok, roc);
					isCreated=true;
				} catch (Exception e) {
					System.out.println(e);
				}
			} while (!isCreated);
		}
	sc.close();	
	}
	
	public boolean addRoman(String nazev, String autor, int rok, zanr Zanr)
	{
		if (seznamKnih.add(new Roman(nazev, autor, rok, Zanr)))
			return true;
		else
			return false;
	}
	
	public void addRoman(String nazev, String autor, int rok, zanr Zanr, boolean dostupnost) {
		seznamKnih.add(new Roman(nazev, autor, rok, Zanr, dostupnost));
	}
	
	public boolean addUcebnice(String nazev, String autor, int rok, int vhodnyRocnik) 
	{
		
		if (seznamKnih.add(new Ucebnice(nazev, autor, rok, vhodnyRocnik)))
			return true;
		else
			return false;
		
	}
	
	public void addUcebnice(String nazev, String autor, int rok, int vhodnyRocnik, boolean dostupnost) 
	{
		seznamKnih.add(new Ucebnice(nazev, autor, rok, vhodnyRocnik, dostupnost));
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
		try {
			vyhledaniKnihy(jmeno).Vypujceni();
		} catch (Exception e) {
			System.out.println("Kniha nenalezena");
		}
	}
	
	public void vraceniKnihy(String jmeno) {
		try {
			vyhledaniKnihy(jmeno).Vraceni();
		} catch (Exception e) {
			System.out.println("Kniha nenalezena");
		}
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
			if(kniha.getDostupnostString()=="Zapujceno") {
				System.out.println(kniha);
			}
		}
	}
	
	public void ulozeniDatabaze() {
		Connect con = new Connect();
		System.out.println("Pripojeni k databazi " + con.connect());
		con.delete();
		if (con.createTable()) System.out.println("Relace vytvorena");
		
		for (Kniha kniha : seznamKnih) {
			con.insertRecord(kniha);
		}
		con.disconnect();
	}
}
