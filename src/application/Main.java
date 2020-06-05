package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException {
	    final String driver = "com.mysql.cj.jdbc.Driver";
	    final String url = "jdbc:mysql://localhost:3306/shelter?serverTimezone=EST";
	    final String username = "root";
	    final String password = "rootpwd";
	
	    try {
	    	Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	
	    Connection conn = DriverManager.getConnection(url, username, password);
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT * FROM pets");
	
	    System.out.println("Pets in shelter:\n");
	    while (rs.next()) {
		    String name = rs.getString("name");
		    String type = rs.getString("type");
		    int age = rs.getInt("age");
		    String breed = rs.getString("breed");
		
		    System.out.println(" --> " + name + ", which is a " + type + " age " + age + " of breed " + breed);
	    }
	    
	    rs.close();
	    stmt.close();
	    conn.close();
	}
}