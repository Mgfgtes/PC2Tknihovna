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
			System.out.println("vypis \t\t vypis databaze knih");
			System.out.println("konec \t\t ukonceni aplikace");					//dodelat mazani konzole
			
			actionSelector = mode.valueOf(sc.next());
			String nazev = null, autor;
			int rok;
			
			switch (actionSelector) {
			case pridani:
				System.out.println(" 1 \t Roman \n 2 \t Ucebnice");
				int sel = sc.nextInt();
				
				System.out.println("Zadejte nazev knihy:");
				nazev = sc.nextLine();
				nazev = sc.nextLine();
				
				System.out.println("Zadejte jmeno autora knihy:");
				autor = sc.nextLine();
				
				System.out.println("Zadejte rok vydani knihy:");
				rok = sc.nextInt();
				
				
				if (sel==1) {
					System.out.println("Zadejte zanr romanu:");
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
				nazev = sc.nextLine();									//Mates dodelat mazani
				mojeKnihovna.removeKniha(nazev);
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
