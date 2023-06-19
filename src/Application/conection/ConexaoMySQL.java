package Application.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoMySQL {
	static Connection conn;
 
	public static Connection create() {

		try {
			// load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// create the connection
			String user = "root";
			String password = "vertrigo";
			String url = "jdbc:mysql://localhost:3306/controle_nu_invenst?autoReconnect=true&useSSL=false";

			try {
				conn = DriverManager.getConnection(url, user, password);
				// System.out.println("Connected to Database.");
				return conn;
			} catch (SQLException e) {
				throw new RuntimeException("Cannot connect to database", e);
				
			//	JOptionPane.showMessageDialog(null, "Não foi possível conectar ao servidor");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}
}
