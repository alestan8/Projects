package business;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem {

	private ArrayList<BaseProduct> bProduct = new ArrayList<BaseProduct>();

	public CompositeProduct(String title, float pret, ArrayList<BaseProduct> bProduct) {
		super.title = title;
		super.pret = pret;
		this.bProduct = bProduct;
	}

	public CompositeProduct() {

	}

	public void addProduct(BaseProduct bP) {
		this.bProduct.add(bP);
	}

	public ArrayList<BaseProduct> getbProduct() {
		return bProduct;
	}

	public void setbProduct(ArrayList<BaseProduct> bProduct) {
		this.bProduct = bProduct;
	}

}
