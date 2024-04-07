package knihovna;

public class Roman extends Kniha {

	enum zanr{Zanr1, Zanr2, Zanr3, Zanr4, Zanr5}
	private zanr Zanr;
	
	public Roman(String nazevKnihy, String autorKnihy, int rokVydani, zanr zanrKnihy) {
		super(nazevKnihy, autorKnihy, rokVydani);
		this.setZanr(zanrKnihy);
	}

	public zanr getZanr() {
		return Zanr;
	}
	public String getZanrString() {
		switch (Zanr) {
		case Zanr1:
			return "Zanr1";
		case Zanr2:
			return "Zanr2";
		case Zanr3:
			return "Zanr3";
		case Zanr4:
			return "Zanr4";
		case Zanr5:
			return "Zanr5";
		default:
			return null;
		}
	}

	public void setZanr(zanr zanr) {
		Zanr = zanr;
	}
	
	@Override public String toString(){
		return this.getNazev()+"\t Roman, "+getAutor()+", "+getZanr()+", "+getRok()+", "+getDostupnostString();	
	}
	
}
