package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConfig {
	
	private static Connection con;
	
	public static Connection openConnection() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courstwic?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "network");
            System.out.println("Connexion à la base réussie !");  
        }catch(Exception e) {
            e.printStackTrace();
        }
		return con;
	}
	
	public static Connection closeConnection() throws SQLException {
		con.close();
		return con;
	}

}