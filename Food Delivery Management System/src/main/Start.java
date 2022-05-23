package main;
import business.*;
import presentation.*;

public class Start {
	public static void main(String[] args){
		
		presentation.Main i = new Main();
		business.DeSerialization.deserialization();
		i.setVisible(true);
		//DeliveryService d = new DeliveryService();
		//d.importProducts();
	}
}