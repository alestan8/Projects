package main;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import business.*;
import presentation.*;

public class Controller implements Serializable {

	private static ArrayList<BaseProduct> produse = new ArrayList<BaseProduct>();
	private static ArrayList<CompositeProduct> compuse = new ArrayList<CompositeProduct>();
	private static Collection<MenuItem> meniu = new ArrayList<MenuItem>();
	private static ArrayList<Order> comenzi = new ArrayList<Order>();

	public static ArrayList<Order> getComenzi() {
		return comenzi;
	}

	public static void setComenzi(ArrayList<Order> comenzi) {
		Controller.comenzi = comenzi;
	}

	public static void importProducts() {
		DeliveryService dS = new DeliveryService();
		produse = dS.importProducts();
		try {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Title");
			model.addColumn("Rating");
			model.addColumn("Calories");
			model.addColumn("Protein");
			model.addColumn("Fat");
			model.addColumn("Sodium");
			model.addColumn("Price");
			for (BaseProduct tmp : produse) {
				Vector<String> row = new Vector<String>();
				row.add(tmp.getTitle());
				row.add(Float.toString(tmp.getRating()));
				row.add(Integer.toString(tmp.getCalories()));
				row.add(Integer.toString(tmp.getProtein()));
				row.add(Integer.toString(tmp.getFat()));
				row.add(Integer.toString(tmp.getSodium()));
				row.add(Float.toString(tmp.getPret()));
				model.addRow(row);
			}
			GuiAdministrator.getTable().setModel(model);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
	}

	public static void editProducts(String title, float rating, int calories, int protein, int fat, int sodium,
			float pret) {
		DeliveryService dS = new DeliveryService();
		produse = dS.editProducts(title, rating, calories, protein, fat, sodium, pret, produse);
		updateProducts();
	}

	public static void updateProducts() {
		try {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Title");
			model.addColumn("Rating");
			model.addColumn("Calories");
			model.addColumn("Protein");
			model.addColumn("Fat");
			model.addColumn("Sodium");
			model.addColumn("Price");
			for (BaseProduct tmp : produse) {
				Vector<String> row = new Vector<String>();
				row.add(tmp.getTitle());
				row.add(Float.toString(tmp.getRating()));
				row.add(Integer.toString(tmp.getCalories()));
				row.add(Integer.toString(tmp.getProtein()));
				row.add(Integer.toString(tmp.getFat()));
				row.add(Integer.toString(tmp.getSodium()));
				row.add(Float.toString(tmp.getPret()));
				model.addRow(row);
			}
			GuiAdministrator.getTable().setModel(model);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
	}

	public static void addCompProducts() {
		int Row = AdaugareProduseCompuse.getTable_1().getModel().getRowCount();
		CompositeProduct cP = new CompositeProduct();
		float pret = 0;
		AdaugareProduseCompuse.getTable_1().getModel();

		for (int i = 0; i < Row; i++) {
			BaseProduct bP = new BaseProduct(AdaugareProduseCompuse.getTable_1().getModel().getValueAt(i, 0).toString(),
					Float.parseFloat((String) AdaugareProduseCompuse.getTable_1().getModel().getValueAt(i, 1)),
					Integer.parseInt((String) AdaugareProduseCompuse.getTable_1().getModel().getValueAt(i, 2)),
					Integer.parseInt((String) AdaugareProduseCompuse.getTable_1().getModel().getValueAt(i, 3)),
					Integer.parseInt((String) AdaugareProduseCompuse.getTable_1().getModel().getValueAt(i, 4)),
					Integer.parseInt((String) AdaugareProduseCompuse.getTable_1().getModel().getValueAt(i, 5)),
					Float.parseFloat((String) AdaugareProduseCompuse.getTable_1().getModel().getValueAt(i, 6)));
			pret += Float.parseFloat((String) AdaugareProduseCompuse.getTable_1().getModel().getValueAt(i, 6));
			cP.addProduct(bP);
		}
		cP.getbProduct().forEach(c -> {
			System.out.println(c.getTitle() + "");
		});
		cP.setTitle(AdaugareProduseCompuse.getTitleField().getText());
		cP.setPret(pret);
		compuse.add(cP);
		System.out.println(cP.getTitle() + " " + cP.getPret());
	}

	public static void generareProduse(){
		meniu.addAll(produse);
		meniu.addAll(compuse);
		//return meniu;
		afisareMeniu(meniu);
	}
	
	public static void afisareMeniu(Collection<MenuItem> meniu2) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Title");
		model.addColumn("Price");

		for (MenuItem tmp : meniu2) {
			Vector<String> row = new Vector<String>();
			row.add(tmp.getTitle());
			row.add(Float.toString(tmp.getPret()));
			model.addRow(row);
		}
		AdaugareComanda.getTable().setModel(model);
	}
	
	public static ArrayList<CompositeProduct> getCompuse() {
		return compuse;
	}

	public static void setCompuse(ArrayList<CompositeProduct> compuse) {
		Controller.compuse = compuse;
	}

	public static Collection<MenuItem> getMeniu() {
		return meniu;
	}

	public static void setMeniu(Collection<MenuItem> meniu) {
		Controller.meniu = meniu;
	}

	public static void setProduse(ArrayList<BaseProduct> produse) {
		Controller.produse = produse;
	}

	public static void adaugareComanda(Order ord) {
		comenzi.add(ord);
		business.DeSerialization.serialization();
		incrementareNrComenzi(ord.getNumeClient());
	}
	
	public static void incrementareNrComenzi(String nume) {
		try {
			int nr_comenzi = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Restaurant?serverTimezone=UTC&user=root&password=parolaIBD21");
			
			Statement stmt = con.createStatement();
			String sql = "Select nr_comenzi from Clienti where nume ='" + nume + "'";
			ResultSet rs1 = stmt.executeQuery(sql);
			if (rs1.next()) {
				nr_comenzi = Integer.parseInt(rs1.getString("nr_comenzi"));
				nr_comenzi++;
			}
			Statement stmt2 = con.createStatement();
			String sql2 = "Update Clienti set nr_comezi = "+ nr_comenzi +" where nume ='" + nume + "'";
			int rs = stmt2.executeUpdate(sql2);
			con.close();
		} catch (Exception e) {
			//System.out.print(e);
		}
	}
	
	public static ArrayList<BaseProduct> getProduse() {
		return produse;
	}

}
