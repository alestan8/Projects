package business;

public class BaseProduct extends MenuItem {
	private float rating;
	private int calories;
	private int protein;
	private int fat;
	private int sodium;

	public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, float pret) {
		super.title = title;
		this.rating = rating;
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.sodium = sodium;
		super.pret = pret;
	}

	@Override
	public String toString() {
		return "BaseProduct [title=" + title + ", rating=" + rating + ", calories=" + calories + ", protein=" + protein
				+ ", fat=" + fat + ", sodium=" + sodium + ", pret=" + pret + "]";
	}

	public BaseProduct() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public float getPret() {
		return pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}
}
