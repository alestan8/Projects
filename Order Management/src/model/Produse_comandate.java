package model;

public class Produse_comandate {
	private int id_comanda;
	private int id_produs;
	private int cantitate;
	private int pret;
	
	public Produse_comandate() {
	}

	public Produse_comandate(int id_comanda, int id_produs, int cantitate, int pret) {
		this.id_comanda = id_comanda;
		this.id_produs = id_produs;
		this.cantitate = cantitate;
		this.pret = pret;
	}
	
	public int getId_comanda() {
		return id_comanda;
	}

	public void setId_comanda(int id_comanda) {
		this.id_comanda = id_comanda;
	}

	public int getId_produs() {
		return id_produs;
	}

	public void setId_produs(int id_produs) {
		this.id_produs = id_produs;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}
	
}
