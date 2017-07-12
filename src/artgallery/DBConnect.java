package artgallery;

import java.sql.*;

//import com.mysql.jdbc.Connection;

public class DBConnect {
	public static Connection conn;
  public static	Statement smt;
	public static ResultSet rs;
	public static PreparedStatement addartist,removeartist,addartwork,updateartwork,addadmin,addimage;
	//protected static Object addartist;

	public Statement getSmt() {
		return smt;
	}

	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery","root","");
			 smt=conn.createStatement();
			 addartist=conn.prepareStatement("insert into artist(name,description,contact) values(?,?,?)");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


