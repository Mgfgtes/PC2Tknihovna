package knihovna;

import java.util.Scanner;

import knihovna.Roman.zanr;

public class Test {
	
	public static void main(String[] args) {
		enum mode{	pridani, odebrani, editace, vypujceni, vraceni, vyhledani,
					vypis, vypisKnihy, vypisAutora, vypisZanru, vypisVypujcenych,
					ulozeniDoSouboru, nacteniZeSouboru, konec}
		mode actionSelector = null; 
		
		DatabazeKnih mojeKnihovna = new DatabazeKnih();
		Scanner sc = new Scanner(System.in);
		
		while (actionSelector != mode.konec) {
			
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("pridani \t prida novou knihu do databaze");
			System.out.println("odebrani \t odebere knihu z databaze");
			System.out.println("editace \t upravi vlastnosti knihy");
			System.out.println("vypis \t\t vypis databaze knih");
			System.out.println("vypisKnihy \t vypis informaci o knize");
			System.out.println("vypisAutora \t vypis knih daneho autora");
			System.out.println("vypisZanru \t vypis knih daneho zanru");
			System.out.println("vypisVypujcenych \t vypis vypujcenych knih");
			System.out.println("ulozeniDoSouboru \t ulozeni knihy do souboru");
			System.out.println("nacteniZeSouboru \t nacteni knihy ze souboru do databaze");
			System.out.println("konec \t\t ukonceni aplikace");
			
			actionSelector = mode.valueOf(sc.next());
			String nazev = null, autor;
			int rok, sel;
			
			switch (actionSelector) {
			case pridani:
				System.out.println(" 1 \t Roman \n 2 \t Ucebnice");
				sel = sc.nextInt();
				
				System.out.println("Zadejte nazev knihy:");
				nazev = sc.nextLine();
				nazev = sc.nextLine();
				
				System.out.println("\nZadejte jmeno autora knihy:");
				autor = sc.nextLine();
				
				System.out.println("\nZadejte rok vydani knihy:");
				rok = sc.nextInt();
				
				
				if (sel==1) {
					System.out.println("\nZadejte zanr romanu:");
					zanr z = zanr.valueOf(sc.next());
					mojeKnihovna.addRoman(nazev, autor, rok, z);
				}else if (sel==2) {
					System.out.println("\nZadejte rocnik pro ktery je ucebnice vhodna:");
					int roc = sc.nextInt();
					mojeKnihovna.addUcebnice(nazev, autor, rok, roc);
				}
				else {
																		//Petr - dodelat pripad kdy neni zadan ani roman ani ucebnice
				}
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
				
				
				System.out.println("Zadejte novy typ\n 1 \t Roman \n 2 \t Ucebnice");
				sel = sc.nextInt();
				
				System.out.println("Zadejte novy nazev knihy:");
				nazev = sc.nextLine();
				nazev = sc.nextLine();
				
				System.out.println("\nZadejte nove jmeno autora knihy:");
				autor = sc.nextLine();
				
				System.out.println("\nZadejte novy rok vydani knihy:");
				rok = sc.nextInt();
				
				
				if (sel==1) {
					System.out.println("\nZadejte novy zanr romanu:");
					zanr z = zanr.valueOf(sc.next());
					mojeKnihovna.addRoman(nazev, autor, rok, z);
				}else if (sel==2) {
					System.out.println("\nZadejte rocnik pro ktery je ucebnice vhodna:");
					int roc = sc.nextInt();
					mojeKnihovna.addUcebnice(nazev, autor, rok, roc);
				}
				else {
																		//Petr - dodelat pripad kdy neni zadan ani roman ani ucebnice
				}
				
				break;
			case vypujceni:
				System.out.println("\nZadejte nazev vracene knihy");
				nazev = sc.nextLine();
				mojeKnihovna.zapujceniKnihy(nazev);
				break;
			case vraceni:
				System.out.println("\nZadejte nazev vypujcovane knihy");
				nazev = sc.nextLine();
				mojeKnihovna.vraceniKnihy(nazev);
				break;
			case vyhledani:
				
				break;
			case vypis:
				mojeKnihovna.vypisDatabazeKnih();
				break;
			case vypisAutora:
				
				break;
			case vypisZanru:
				
				break;
			case vypisVypujcenych:
				
				break;
			case ulozeniDoSouboru:
				
				break;
			case nacteniZeSouboru:
				
				break;
			case konec:
				
				break;
			default:													//Petr - dodelat pripad kdy nebyla zadana validni operace se seznamem
				
				break;
			}
			
			
			
		}
	}

}
