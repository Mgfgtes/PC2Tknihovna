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
		this.rocnik = rocnik;
	}

	@Override public String toString(){
		return this.getNazev()+"\t"+getAutor()+", "+getRocnik()+", "+getRok()+", "+getDostupnost();	
	}

}
