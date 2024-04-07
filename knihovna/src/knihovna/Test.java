package knihovna;

import java.util.Scanner;

import knihovna.Roman.zanr;

public class Test {
	
	public static void main(String[] args) {
		enum mode{	pridani, odebrani, editace, vypujceni, vraceni,
					vypis, vypisKnihy, vypisAutora, vypisZanru, vypisVypujcenych,
					ulozeniDoSouboru, nacteniZeSouboru, konec}
		mode actionSelector = null; 
		
		DatabazeKnih mojeKnihovna = new DatabazeKnih();
		Scanner sc = new Scanner(System.in);
		String nazev, autor;
		
		while (actionSelector != mode.konec) {
			
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("pridani \t prida novou knihu do databaze");
			System.out.println("odebrani \t odebere knihu z databaze");
			System.out.println("editace \t upravi vlastnosti knihy");
			System.out.println("vypujceni \t vypujceni knihy");
			System.out.println("vraceni \t vraceni knihy");
			System.out.println("vypis \t\t vypis databaze knih");
			System.out.println("vypisKnihy \t vypis informaci o knize");
			System.out.println("vypisAutora \t vypis knih daneho autora");
			System.out.println("vypisZanru \t vypis knih daneho zanru");
			System.out.println("vypisVypujcenych \t vypis vypujcenych knih");
			System.out.println("ulozeniDoSouboru \t ulozeni knihy do souboru");
			System.out.println("nacteniZeSouboru \t nacteni knihy ze souboru do databaze");
			System.out.println("konec \t\t ukonceni aplikace");
			
			do {
				try {
					actionSelector = mode.valueOf(sc.next());
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Zkuste prosim zadat operaci znovu");
					actionSelector=null;
				}
			} while (actionSelector==null);
			
			switch (actionSelector) {
			case pridani:
				mojeKnihovna.pridaniKnihy();
				break;
			case odebrani:
				System.out.println("Zadejte nazev knihy:");
				nazev = sc.nextLine();
				nazev = sc.nextLine();
				mojeKnihovna.removeKniha(nazev);
				break;
			case editace:
				System.out.println("Zadejte nazev knihy kterou chcete upravit:");
				nazev = sc.nextLine();
				nazev = sc.nextLine();
				mojeKnihovna.removeKniha(nazev);
				mojeKnihovna.pridaniKnihy();
				break;
			case vypujceni:
				System.out.println("\nZadejte nazev vypujcovane knihy");
				nazev = sc.nextLine();
				nazev = sc.nextLine();
				mojeKnihovna.zapujceniKnihy(nazev);
				System.out.println("Kniha byla vypujcena");
				break;
			case vraceni:
				System.out.println("\nZadejte nazev vracene knihy");
				nazev = sc.nextLine();
				nazev = sc.nextLine();
				mojeKnihovna.vraceniKnihy(nazev);
				System.out.println("Kniha byla vracena");
				break;
			case vypisKnihy:
				System.out.println("\nZadejte nazev hledane knihy");
				nazev = sc.nextLine();
				nazev = sc.nextLine();
				mojeKnihovna.infoKniha(nazev);
				break;
			case vypis:
				mojeKnihovna.vypisDatabazeKnih();
				break;
			case vypisAutora:
				System.out.println("\nZadejte jmeno autora jehoz knihy chcete vyhledat");
				autor = sc.nextLine();
				autor = sc.nextLine();
				mojeKnihovna.vypisAutora(autor);
				break;
			case vypisZanru:
				System.out.println("\nZadejte zanr knih ktere chcete vyhledat");
				zanr z = zanr.valueOf(sc.next());
				mojeKnihovna.vypisZanru(z);
				break;
			case vypisVypujcenych:
				mojeKnihovna.vypisVypujcenych();
				break;
			case ulozeniDoSouboru:
				
				break;
			case nacteniZeSouboru:
				
				break;
			case konec:
				mojeKnihovna.ulozeniDatabaze();
				break;
			default:
				
				break;
			}
		}
	sc.close();
	}
}
