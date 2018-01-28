package com.ram.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection con = null;
	static Properties p;
	static {
		p = new Properties();
		try {
			p.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("com/ram/properties/db.properties"));
			Class.forName(p.getProperty("driver"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		try {
			con = DriverManager.getConnection(p.getProperty("uri"), p.getProperty("user"), p.getProperty("pwd"));
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void connectionClose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
