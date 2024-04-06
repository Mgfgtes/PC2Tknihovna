package knihovna;

public class KnihaComparator implements java.util.Comparator<Kniha> {

	@Override
	public int compare(Kniha o1, Kniha o2) {
		return o1.getRok()-o2.getRok();
	}

}
