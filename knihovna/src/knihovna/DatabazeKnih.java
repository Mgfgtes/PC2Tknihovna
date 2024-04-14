package knihovna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public Kniha vyhledaniKnihy(String nazev) {
		Kniha res=null;
		for (Kniha kniha : seznamKnih) {
			if(kniha.getNazev().equals(nazev)) res=kniha;
		}
		if(res==null) System.out.println("Kniha nenalezena");
		return res;
	}
	
	public boolean ulozeniKnihy(String nazev) {
		try {
			if(vyhledaniKnihy(nazev)==null) return false;
			FileWriter fw = new FileWriter(nazev+".txt");
			BufferedWriter out = new BufferedWriter(fw);
			 
			Kniha ukladanaKniha = vyhledaniKnihy(nazev);
			
			out.write(ukladanaKniha.getNazev() + ";" + ukladanaKniha.getAutor() + ";" + ukladanaKniha.getRok() + ";" + ukladanaKniha.getDostupnost());
			if(ukladanaKniha.instanceOfRoman()) {
				Roman r = (Roman) ukladanaKniha;
				out.write(";" + "Roman" + ";" + r.getZanr());
			}
			if (ukladanaKniha.instanceOfUcebnice()) {
				Ucebnice ucebnice = (Ucebnice) ukladanaKniha;
				out.write(";" + "Ucebice" + ";" + ucebnice.getRocnik());
			}
			
			out.close();
			fw.close();
		}
		catch (IOException e) {
			System.out.println("Soubor nelze vytvorit");
			return false;
		}
		return true;
	}
	
	public boolean nacteniKnihy(String jmenoSouboru) {
		FileReader fr=null;
		BufferedReader in=null;
		try {
			fr = new FileReader(jmenoSouboru + ".txt");
			in = new BufferedReader(fr);
			String radek=in.readLine();
			String[] castiTextu = radek.split(";");
			if (castiTextu.length!=6)
				return false;
			if (castiTextu[4].equals("Roman")) {
				addRoman(castiTextu[0], castiTextu[1], Integer.valueOf(castiTextu[2]), Roman.setZanrByString(castiTextu[5]), Boolean.valueOf(castiTextu[3]));
			}
			if (castiTextu[4]=="Ucebnice") {
				addUcebnice(castiTextu[0], castiTextu[1], Integer.valueOf(castiTextu[2]), Integer.valueOf(castiTextu[5]), Boolean.valueOf(castiTextu[3]));
			}
		}
		catch (IOException e) {
			System.out.println("Soubor  nelze otevrit");
			return false;
		} 
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Chyba integrity dat v souboru");
			return false;
		}
		finally
		{
			try
			{	if (in!=null)
				{
					in.close();
					fr.close();
				}
			}
			catch (IOException e) {
				System.out.println("Soubor  nelze zavrit");
				return false;
			} 
		}
		
		return true;
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
			if (kniha.instanceOfRoman()) {
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
