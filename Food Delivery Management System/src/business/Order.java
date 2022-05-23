package business;

import java.util.ArrayList;
import java.util.Date;

public class Order implements java.io.Serializable{
	private int id;
	private String numeClient;
	private String Adresa;
	private float pret;
	private Date data;
	ArrayList<MenuItem> comanda;
	
	public Order(int id, String numeClient, Date data) {
		this.id = id;
		this.numeClient = numeClient;
		this.data = data;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", numeClient=" + numeClient + ", Adresa=" + Adresa + ", pret=" + pret + ", data="
				+ data + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeClient() {
		return numeClient;
	}

	public void setNumeClient(String numeClient) {
		this.numeClient = numeClient;
	}

	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}

	public float getPret() {
		return pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ArrayList<MenuItem> getComanda() {
		return comanda;
	}

	public void setComanda(ArrayList<MenuItem> comanda) {
		this.comanda = comanda;
	}
}
