package knihovna;

import knihovna.Roman.zanr;

public class Test {

	public static void main(String[] args) {
		DatabazeKnih mojeKnihovna = new DatabazeKnih();
		 
		mojeKnihovna.addRoman("Na zapadni fronte klid", "Remarque", 1928, zanr.Zanr1);
		mojeKnihovna.addRoman("Petr a Lucie", "Polland", 1920, zanr.Zanr2);
		mojeKnihovna.addRoman("Starec a more", "Hemingway", 1952, zanr.Zanr1);
		
		mojeKnihovna.vypisDatabazeKnih();
	}

}
