package dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import connection.*;
import gui.GuiClient;
import model.*;
import net.proteanit.sql.DbUtils;

public class OpDAO<T> {

	private static ConnectionFactory conf = new ConnectionFactory();

	public OpDAO() {

	}

	public static ResultSet getLista(Object object) throws SQLException {
		// ArrayList<Object> lista = new ArrayList<Object>();
		Connection c = conf.createConnection();
		PreparedStatement s = null;
		int ok = 0; // 0 client 1 produs 2 comanda 3 produse_comandate
		if (object instanceof Client)
			s = c.prepareStatement("SELECT * FROM Clienti");
		else if (object instanceof Produs) {
			s = c.prepareStatement("SELECT id, denumire, pret_de_lista AS 'pret', cantitate_disponibila AS 'cantitate' FROM Produs");
			ok = 1;
		} else if (object instanceof Comanda) {
			s = c.prepareStatement("SELECT * FROM Comanda");
			ok = 2;
		} else if (object instanceof Produse_comandate) {
			s = c.prepareStatement("SELECT * FROM Produse_comandate");
			ok = 3;
		}
		ResultSet rs = s.executeQuery();
		return rs;
	}

	public static int opClient(int id, String nume, String adresa, int operatie) throws SQLException {
		Connection c = conf.createConnection();
		PreparedStatement s = null;
		if (operatie == 0) // adaugare
			s = c.prepareStatement("Insert into Clienti (nume, adresa) values ('" + nume + "', '" + adresa + "');");
		else if (operatie == 1) // editare
			s = c.prepareStatement(
					"UPDATE Clienti SET nume = '" + nume + "', adresa = '" + adresa + "' WHERE id = " + id + " ;");
		else if (operatie == 2) // stergere
			s = c.prepareStatement("DELETE FROM Clienti WHERE id = " + id + ";");
		int rs = s.executeUpdate();
		return rs;
	}

	public static int opProdus(int id, String denumire, float pret_de_lista, int cantitate_disponibila, int operatie)
			throws SQLException {
		Connection c = conf.createConnection();
		PreparedStatement s = null;
		if (operatie == 0) // adaugare
			s = c.prepareStatement("Insert into Produs(denumire, pret_de_lista, cantitate_disponibila) values ('"
					+ denumire + "', " + pret_de_lista + ", " + cantitate_disponibila + ");");
		else if (operatie == 1) // editare
			s = c.prepareStatement("UPDATE Produs SET denumire = '" + denumire + "', pret_de_lista = " + pret_de_lista
					+ ", cantitate_disponibila = " + cantitate_disponibila + " WHERE id = " + id + " ;");
		else if (operatie == 2) // stergere
			s = c.prepareStatement("DELETE FROM Produs WHERE id = " + id + ";");
		int rs = s.executeUpdate();
		return rs;
	}

	public void viewClienti(Object object) throws SQLException {
		Client client = new Client();
		Produs produs = new Produs();
		Comanda comanda = new Comanda();
		getLista(client);
	}

}
