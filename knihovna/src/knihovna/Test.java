package knihovna;

import java.util.Scanner;

import knihovna.Roman.zanr;

public class Test {
	
	public static void main(String[] args) {
		enum mode{	pridani, odebrani, editace, vypujceni, vyhledani,
					vypis, vypisAutora, vypisZanru, vypisVypujcenych,
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
			System.out.println("konec \t\t ukonceni aplikace");					//dodelat mazani konzole
			
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
																		//Petr - dodelat ucebnici
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
																		//Petr - dodelat ucebnici
				}
				else {
																		//Petr - dodelat pripad kdy neni zadan ani roman ani ucebnice
				}
				
				break;
			case vypis:
				mojeKnihovna.vypisDatabazeKnih();
				break;
			default:													//Petr - dodelat pripad kdy nebyla zadana validni operace se seznamem
				break;
			}
			
			
			
		}
	}

}
