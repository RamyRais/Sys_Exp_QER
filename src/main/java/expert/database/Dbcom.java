package expert.database;

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

		/*
		 * Method that execute an SQL query
		 * @param stmt 
		 * 			is the object statement for sending SQL query to the database
		 * @param  requetSql
		 * 			is the query that will be executed
		 * 
		 * @return the result of the query in an ResultSet object
		 */
		public static ResultSet resultatRequet(Statement stmt, String requetSql) {
			
			ResultSet rSet = null;
			try {

				rSet = stmt.executeQuery(requetSql);
				/*
				while (rSet.next()) {
					String res = " "+ rSet.getString(2)+" "+rSet.getString(3)+" "
							+ rSet.getInt(4) +" "+rSet.getInt(5) +" "+rSet.getInt(6) +" "
							+rSet.getInt(7) +" "+ rSet.getString(8)+" "+rSet.getString(9)+" "+rSet.getString(10);
					System.out.println(res);
				}
					*/
			} catch (SQLException eGetConn) {
				eGetConn.printStackTrace();
			} finally {
				return rSet ;
			}

		}

		/*
		 * Method that return a connection instance if it exist or create one if not
		 * 
		 * @return Connection object
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

					System.out.println("connected to the database");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return connect;
		}

	

}
