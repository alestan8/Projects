package connection;

import java.sql.*;
import java.util.logging.Logger;

public class ConnectionFactory {
	private static final Logger LOGGER =Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/depozit?serverTimezone=UTC&user=root&password=parolaIBD21";
	private static final String USER = "root";
	private static final String PASS = "parolaIBD21";
	
	private static ConnectionFactory singleInstance = new ConnectionFactory();
	
	public ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection createConnection() throws SQLException {
		Connection conexiune = null;
		try {
			Class.forName(DRIVER);
			conexiune = DriverManager.getConnection(DBURL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conexiune;
	}
	
	public Connection getConnection() {
		Connection conexiune = null;
		
			try {
				Class.forName(DRIVER);
				conexiune = DriverManager.getConnection(DBURL);
			} catch (ClassNotFoundException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
		
		//return ConnectionFactory.getConnection();
	}
	
	public static void close(Connection connection) {
		
	}
	
	public static void close(ResultSet resultSet) {
		
	}
	
	public static void main(String[] args)
	{
		ConnectionFactory c= new ConnectionFactory();
		
	}
}
