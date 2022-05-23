package business;

public class MenuItem {
	protected String title;
	protected float pret;
	private int nr_comenzi = 0;
	
	public MenuItem() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPret() {
		return pret;
	}
	public void setPret(float pret) {
		this.pret = pret;
	}
	
	@Override
	public String toString() {
		return "MenuItem [title=" + title + ", pret=" + pret + "]";
	}

	public int getNr_comenzi() {
		return nr_comenzi;
	}

	public void setNr_comenzi(int nr_comenzi) {
		this.nr_comenzi = nr_comenzi;
	}
	
	public void idComanda() {
		nr_comenzi= nr_comenzi+1;
	}
}
