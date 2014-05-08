package expert_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Dbcom {

		// URL de connection
		private static String url = "jdbc:mysql://localhost/system_expert";
		// Nom du user
		private static String user = "root";
		// Mot de passe du user
		private static String passwd = null;
		// Objet Connection
		private static Connection connect;
		public static java.sql.Statement stmt;

		public static ResultSet resultatRequet(Statement stmt, String requetSql) {
			
			ResultSet rSet = null;
			try {
//				
//				Connection conn = getInstance();
//				Statement stmt = conn.createStatement();

				

				rSet = stmt.executeQuery(requetSql);
				/*
				while (rSet.next()) {
					String res = " "+ rSet.getString(2)+" "+rSet.getString(3)+" "
							+ rSet.getInt(4) +" "+rSet.getInt(5) +" "+rSet.getInt(6) +" "
							+rSet.getInt(7) +" "+ rSet.getString(8)+" "+rSet.getString(9)+" "+rSet.getString(10);
					System.out.println(res);
				}
					*/

				//conn.close();
				//stmt.close();
			} catch (SQLException eGetConn) {
				eGetConn.printStackTrace();
			} finally {
				return rSet ;
			}

		}

		/*
		 * Méthode qui va nous retourner notre instance et la créer si elle n'existe
		 * pas...
		 * 
		 * @return
		 */
		public static Connection getInstance() {
			if (connect == null) {
				try {
					Class.forName("com.mysql.jdbc.Driver");

				} catch (Exception e) {
					e.printStackTrace();
					System.exit(99);
				}
				try {

					connect = DriverManager.getConnection(url, user, passwd);
					stmt = connect.createStatement();

					System.out.println("connection oumourha mrigula");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return connect;
		}

	

}
