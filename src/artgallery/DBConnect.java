package artgallery;

import java.sql.*;

//import com.mysql.jdbc.Connection;

public class DBConnect {
	Connection conn;
	Statement smt;

	public Statement getSmt() {
		return smt;
	}

	public DBConnect() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_a","root","");
			 smt=conn.createStatement();
			ResultSet r=smt.executeQuery("select * from info");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
	}

}
