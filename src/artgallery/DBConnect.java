package artgallery;

import java.sql.*;

//import com.mysql.jdbc.Connection;

public class DBConnect {
	Connection conn;
	Statement smt;

	public Statement getSmt() {
		return smt;
	}

	public DBConnect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery","root","");
			 smt=conn.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
