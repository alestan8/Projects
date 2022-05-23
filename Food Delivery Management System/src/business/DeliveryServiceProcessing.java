package business;

import java.util.ArrayList;

public interface DeliveryServiceProcessing {
	public ArrayList<BaseProduct> importProducts();
	public void addProducts(String title, float rating, int calories, int protein, int fat, int sodium, float pret);
	public void deleteProducts(String title, float rating, int calories, int protein, int fat, int sodium, float pret);
	public ArrayList<BaseProduct> editProducts(String title, float rating, int calories, int protein, int fat, int sodium, float pret,  ArrayList<BaseProduct> prod);

	public void generareRaport();
	public void adaugareComanda(String nume, String adresa);
}
