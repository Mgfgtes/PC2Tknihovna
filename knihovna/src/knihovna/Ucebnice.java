package knihovna;

public class Ucebnice extends Kniha {

	int rocnik;
	
	public Ucebnice(String nazevKnihy, String autorKnihy, int rokVydani, int vhodnyRocnik) {
		super(nazevKnihy, autorKnihy, rokVydani);
		this.rocnik=vhodnyRocnik;
	}

}
