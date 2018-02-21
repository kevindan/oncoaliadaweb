package database;


import java.sql.DriverManager;

import java.sql.Connection;

public class DataAccess {

	public static Connection getConnection() throws Exception{
		
		/*
		 * Conexión para amazon web service:
		 * 
		 * server: mysqlaws.ch0wyy4vupbb.us-east-2.rds.amazonaws.com
		 * port: 3306
		 * user: mysqlaws
		 * pass: kevin123456
		 * */
		
		String server = "localhost";
		String port = "3306";
		String database = "oncodatdb";
		String user = "root";
		String pass = "root";
		String url = "jdbc:mysql://" + server + ":" + port + "/" + database+"?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		Connection cn;
		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(url, user, pass);
			return cn;
		} catch (Exception e) {
			throw e;
		}

	}

}
