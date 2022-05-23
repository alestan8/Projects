package model;

public class Comanda {
	private int id;
	private int id_client;
	private float total;

	public Comanda() {
	}

	public Comanda(int id, int id_client, float total) {
		this.id = id;
		this.id_client = id_client;
		this.total = total;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
