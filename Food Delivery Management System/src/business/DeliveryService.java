package business;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import presentation.AdaugareComanda;
import presentation.AdaugareProduseCompuse;
import java.util.Date;

public class DeliveryService implements DeliveryServiceProcessing {
	static ArrayList<BaseProduct> produse = new ArrayList<BaseProduct>();
	// private static ArrayList<Order> comenzi = new ArrayList<Order>();
	private static Collection<MenuItem> comanda = new ArrayList<MenuItem>();
	private static Order ord = new Order();

	public ArrayList<BaseProduct> importProducts() {
		try {
			File file = new File("products.csv");
			InputStreamReader in = new InputStreamReader(new FileInputStream(file));
			CSVParser csvP = CSVFormat.DEFAULT.parse(in);
			for (CSVRecord tmp : csvP) {
				try {
					BaseProduct bP = new BaseProduct(tmp.get(0), Float.parseFloat(tmp.get(1)),
							Integer.parseInt(tmp.get(2)), Integer.parseInt(tmp.get(3)), Integer.parseInt(tmp.get(4)),
							Integer.parseInt(tmp.get(5)), Float.parseFloat(tmp.get(6)));
					produse.add(bP);
				} catch (Exception e3) {

				}
			}
			in.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return produse;
	}

	@Override
	public void addProducts(String title, float rating, int calories, int protein, int fat, int sodium, float pret) {
		BaseProduct bP = new BaseProduct(title, rating, calories, protein, fat, sodium, pret);
		produse.add(bP);
		main.Controller.updateProducts();
	}

	@Override
	public void deleteProducts(String title, float rating, int calories, int protein, int fat, int sodium, float pret) {
		ArrayList<BaseProduct> aux = new ArrayList<BaseProduct>();
		for (BaseProduct i : aux) {
			if (i.getTitle().equals(title) && Float.toString(i.getRating()).equals(Float.toString(rating))
					&& Integer.toString(i.getProtein()).equals(Integer.toString(protein))
					&& Float.toString(i.getPret()).equals(Float.toString(pret))) {
				System.out.println("gasit");
			}
			else
			{
				aux.add(i);
			}
		}
		main.Controller.setProduse(aux);
	}

	@Override
	public ArrayList<BaseProduct> editProducts(String title, float rating, int calories, int protein, int fat,
			int sodium, float pret, ArrayList<BaseProduct> prod) {
		ArrayList<BaseProduct> auxp = prod;
		for (BaseProduct tmp : auxp) {
			if (tmp.getTitle().equals(title)) {
				tmp.setCalories(calories);
				tmp.setFat(fat);
				tmp.setProtein(protein);
				tmp.setRating(rating);
				tmp.setSodium(sodium);
				tmp.setPret(pret);
				tmp.setRating(rating);
			}
		}
		return auxp;
	}

	@Override
	public void generareRaport() {
		// TODO Auto-generated method stub

	}

	@Override
	public void adaugareComanda(String nume, String adresa) {

		int Row = AdaugareComanda.getTable_1().getModel().getRowCount();
		float pret = 0;
		AdaugareComanda.getTable_1().getModel().getRowCount();

		for (int i = 0; i < Row; i++) {
			MenuItem item = new MenuItem();
			item.setTitle(AdaugareComanda.getTable_1().getModel().getValueAt(i, 0).toString());
			item.setPret(Float.parseFloat((String) AdaugareComanda.getTable_1().getModel().getValueAt(i, 1)));
			pret += Float.parseFloat((String) AdaugareComanda.getTable_1().getModel().getValueAt(i, 1));
			comanda.add(item);
		}
		comanda.forEach(i -> {
			System.out.print(i.getTitle() + " ");
		});
		int i = main.Controller.getComenzi().size();
		ord.setId(i + 1);
		ord.setNumeClient(nume);
		ord.setAdresa(adresa);
		ord.setPret(pret);
		Date date = java.util.Calendar.getInstance().getTime();
		ord.setData(date);
		System.out.println(ord);
		/*
		 * ord.getComanda().forEach(mn->{ main.Controller.getProduse().forEach(b->{
		 * if(b.getTitle().equals(mn.getTitle())) { b.idComanda(); } });
		 * main.Controller.getCompuse().forEach(b->{
		 * if(b.getTitle().equals(mn.getTitle())) { b.idComanda(); } }); });
		 */
		main.Controller.adaugareComanda(ord);
	}

}
