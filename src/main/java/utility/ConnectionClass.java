package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionClass {

	public ResultSet gettingConnection(Connection con,Statement stmt) {
		 ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selActivity", "root", "Password634$$");  
			 stmt = con.createStatement();
			  rs=stmt.executeQuery("");
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
}

