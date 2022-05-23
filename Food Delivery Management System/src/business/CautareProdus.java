package business;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import main.*;
import presentation.*;

public class CautareProdus {
	private static ArrayList<BaseProduct> produse = Controller.getProduse();

	public static ArrayList<BaseProduct> cautareCuvantCheie(String cuvantCheie, ArrayList<BaseProduct> bP) {

		ArrayList<BaseProduct> auxP = new ArrayList<BaseProduct>();
		bP.stream()
				.filter(i -> (i.getTitle().equals(cuvantCheie) || Float.toString(i.getRating()).equals(cuvantCheie)
						|| Integer.toString(i.getCalories()).equals(cuvantCheie)
						|| Integer.toString(i.getProtein()).equals(cuvantCheie)
						|| Integer.toString(i.getFat()).equals(cuvantCheie)
						|| Integer.toString(i.getSodium()).equals(cuvantCheie)
						|| Float.toString(i.getPret()).equals(cuvantCheie)))
				.forEach(j -> {
					BaseProduct auxBP = new BaseProduct(j.getTitle(), j.getRating(), j.getCalories(), j.getProtein(),
							j.getFat(), j.getSodium(), j.getPret());
					auxP.add(auxBP);
				});
		return auxP;

	}

	public static ArrayList<BaseProduct> cautareRating(int intA, int intB) {
		ArrayList<BaseProduct> bP = new ArrayList<BaseProduct>();

		for (BaseProduct tmp : produse) {
			if (tmp.getRating() >= intA && tmp.getRating() <= intB) {
				BaseProduct auxBP = new BaseProduct(tmp.getTitle(), tmp.getRating(), tmp.getCalories(),
						tmp.getProtein(), tmp.getFat(), tmp.getSodium(), tmp.getPret());
				bP.add(auxBP);
			}
		}
		return bP;
	}

	public static ArrayList<BaseProduct> cautareCalories(int intA, int intB) {
		ArrayList<BaseProduct> bP = new ArrayList<BaseProduct>();

		for (BaseProduct tmp : produse) {
			if (tmp.getCalories() >= intA && tmp.getCalories() <= intB) {
				BaseProduct auxBP = new BaseProduct(tmp.getTitle(), tmp.getRating(), tmp.getCalories(),
						tmp.getProtein(), tmp.getFat(), tmp.getSodium(), tmp.getPret());
				bP.add(auxBP);
			}
		}
		return bP;
	}

	public static ArrayList<BaseProduct> cautareProtein(int intA, int intB) {
		ArrayList<BaseProduct> bP = new ArrayList<BaseProduct>();

		for (BaseProduct tmp : produse) {
			if (tmp.getProtein() >= intA && tmp.getProtein() <= intB) {
				BaseProduct auxBP = new BaseProduct(tmp.getTitle(), tmp.getRating(), tmp.getCalories(),
						tmp.getProtein(), tmp.getFat(), tmp.getSodium(), tmp.getPret());
				bP.add(auxBP);
			}
		}
		return bP;
	}

	public static ArrayList<BaseProduct> cautareFat(int intA, int intB) {
		ArrayList<BaseProduct> bP = new ArrayList<BaseProduct>();

		for (BaseProduct tmp : produse) {
			if (tmp.getFat() >= intA && tmp.getFat() <= intB) {
				BaseProduct auxBP = new BaseProduct(tmp.getTitle(), tmp.getRating(), tmp.getCalories(),
						tmp.getProtein(), tmp.getFat(), tmp.getSodium(), tmp.getPret());
				bP.add(auxBP);
			}
		}
		return bP;
	}

	public static ArrayList<BaseProduct> cautareSodiu(int intA, int intB) {
		ArrayList<BaseProduct> bP = new ArrayList<BaseProduct>();

		for (BaseProduct tmp : produse) {
			if (tmp.getSodium() >= intA && tmp.getSodium() <= intB) {
				BaseProduct auxBP = new BaseProduct(tmp.getTitle(), tmp.getRating(), tmp.getCalories(),
						tmp.getProtein(), tmp.getFat(), tmp.getSodium(), tmp.getPret());
				bP.add(auxBP);
			}
		}
		return bP;
	}

	public static ArrayList<BaseProduct> cautarePrice(int intA, int intB) {
		ArrayList<BaseProduct> bP = new ArrayList<BaseProduct>();

		for (BaseProduct tmp : produse) {
			if (tmp.getPret() >= intA && tmp.getPret() <= intB) {
				BaseProduct auxBP = new BaseProduct(tmp.getTitle(), tmp.getRating(), tmp.getCalories(),
						tmp.getProtein(), tmp.getFat(), tmp.getSodium(), tmp.getPret());
				bP.add(auxBP);
			}
		}
		return bP;
	}

	public static ArrayList<BaseProduct> cautareDouaCriterii(int categorie, String cuvantCheie, int intA, int intB) {
		ArrayList<BaseProduct> bP1 = new ArrayList<BaseProduct>();
		ArrayList<BaseProduct> bP2 = new ArrayList<BaseProduct>();
		if (categorie == 1) {
			bP1 = business.CautareProdus.cautareRating(intA, intB);
			bP2 = cautareCuvantCheie(cuvantCheie, bP1);
		} else if (categorie == 2) {
			bP1 = business.CautareProdus.cautareCalories(intA, intB);
			bP2 = cautareCuvantCheie(cuvantCheie, bP1);
		} else if (categorie == 3) {
			bP1 = business.CautareProdus.cautareProtein(intA, intB);
			bP2 = cautareCuvantCheie(cuvantCheie, bP1);
		} else if (categorie == 4) {
			bP1 = business.CautareProdus.cautareFat(intA, intB);
			bP2 = cautareCuvantCheie(cuvantCheie, bP1);
		} else if (categorie == 5) {
			bP1 = business.CautareProdus.cautareSodiu(intA, intB);
			bP2 = cautareCuvantCheie(cuvantCheie, bP1);
		} else if (categorie == 6) {
			bP1 = business.CautareProdus.cautarePrice(intA, intB);
			bP2 = cautareCuvantCheie(cuvantCheie, bP1);
		}
		return bP2;
	}

	public static void afisareLista(ArrayList<BaseProduct> bP) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Title");
		model.addColumn("Rating");
		model.addColumn("Calories");
		model.addColumn("Protein");
		model.addColumn("Fat");
		model.addColumn("Sodium");
		model.addColumn("Price");

		for (BaseProduct tmp : bP) {
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
		GuiClient.getTable().setModel(model);
	}
}
