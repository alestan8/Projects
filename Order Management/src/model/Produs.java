package model;

public class Produs {
	private int id;
	private String denumire;
	private float pret_de_lista;
	private int cantitate_disponibila;

	public Produs() {
		
	}

	public Produs(int id, String denumire, float pret_de_lista, int cantitate_disponibila) {
		this.id = id;
		this.denumire = denumire;
		this.pret_de_lista = cantitate_disponibila;
		this.cantitate_disponibila = cantitate_disponibila;
	}

	public boolean verificareStoc(int cant) {
		if(this.cantitate_disponibila < cant)
			return false;
		else
			return true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public float getPret_de_lista() {
		return pret_de_lista;
	}

	public void setPret_de_lista(float pret_de_lista) {
		this.pret_de_lista = pret_de_lista;
	}

	public int getCantitate_disponibila() {
		return cantitate_disponibila;
	}

	public void setCantitate_disponibila(int cantitate_disponibila) {
		this.cantitate_disponibila = cantitate_disponibila;
	}
}
