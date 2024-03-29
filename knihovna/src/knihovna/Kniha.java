package knihovna;

public abstract class Kniha implements Comparable<Kniha> {
	private String nazev, autor;
	private int rok;
	private boolean dostupnost;
	
	public Kniha(String nazevKnihy, String autorKnihy, int rokVydani) {
		this.nazev = nazevKnihy;
		this.autor = autorKnihy;
		this.rok =rokVydani;
		this.dostupnost = true;
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		if (nazev.equals(this.nazev)) {
			System.out.println("Zadali jste stejny nazev");
		}
		this.nazev = nazev;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor.equals(this.autor)) {
			System.out.println("Zadali jste stejne jmeno autora");
		}
		this.autor = autor;
	}

	public int getRok() {
		return rok;
	}
	
	public void setRok(int rok) {
		if (rok<750||rok>2024) {											//Vyresit aktualni rok
			System.out.println("Zadany rok je neplatny");
		}
		else {
			this.rok = rok;
		}
	}

	public boolean getDostupnost() {
		return dostupnost;
	}

	public void Vypujceni() {
		this.dostupnost = false;
	}
	
	public void Vraceni() {
		this.dostupnost = true;
	}
	
	@Override public int compareTo(Kniha a)
    {
		return this.nazev.compareTo(a.nazev);
    }
	
}
