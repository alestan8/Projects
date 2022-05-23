package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GenerareRaport {
	public static void raport1(int i1, int i2) {

		FileWrite fw = new FileWrite("Raport interval");
		main.Controller.getComenzi().stream().filter(y -> y.getData().getHours() >= i1 && y.getData().getHours() <= i2)
				.forEach(c -> {
					fw.scriere(c.toString()+"\n");
				});
		fw.inchidere();
	}
	
	public static void raport2(int i1, int i2) {

		FileWrite fw = new FileWrite("Raport 2");
		main.Controller.getComenzi().stream().filter(y -> y.getData().getHours() >= i1 && y.getData().getHours() <= i2)
				.forEach(c -> {
					fw.scriere(c.toString());
				});
		fw.inchidere();
	}
	
	public static void raport3(int i1) {

		ArrayList<String> numeClienti = new ArrayList<String>();
		FileWrite fw = new FileWrite("Raport clienti");
		try {
			int nr_comenzi = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Restaurant?serverTimezone=UTC&user=root&password=parolaIBD21");
			
			Statement stmt = con.createStatement();
			String sql = "Select * from Clienti where nr_comenzi >'" + i1 + "'";
			ResultSet rs1 = stmt.executeQuery(sql);
			if (rs1.next()) {
				numeClienti.add(rs1.getString("nume"));
			}
			con.close();
		} catch (Exception e) {
			//System.out.print(e);
		}
		numeClienti.forEach(cl->{
			main.Controller.getComenzi().stream().filter(y -> y.getNumeClient().equals(cl) )
			.forEach(c -> {
				fw.scriere(c.toString());
			});
		});
		
		fw.inchidere();
	}

	public static void raport4(int zi) {

		FileWrite fw = new FileWrite("Raport zi");
		main.Controller.getProduse().stream().filter(y -> y.getNr_comenzi()>zi)
				.forEach(c -> {
					fw.scriere(c.getTitle() + c.getNr_comenzi());
					System.out.println(c.getTitle()+ " ");
				});
		fw.inchidere();
	}
}
