package knihovna;

public class Ucebnice extends Kniha {

	int rocnik;
	
	public Ucebnice(String nazevKnihy, String autorKnihy, int rokVydani, int vhodnyRocnik) {
		super(nazevKnihy, autorKnihy, rokVydani);
		this.rocnik=vhodnyRocnik;
	}
	
	public int getRocnik() {
		return rocnik;
	}

	public void setRocnik(int rocnik) {
		do {
			this.rocnik = rocnik;
			if(rocnik>9) System.out.println("Zadany rocnik je nespravny");
		} while (rocnik>9);
		
	}

	@Override public String toString(){
		return this.getNazev()+"\t Ucebnice, "+getAutor()+", "+getRocnik()+", "+getRok()+", "+getDostupnostString();	
	}

}
