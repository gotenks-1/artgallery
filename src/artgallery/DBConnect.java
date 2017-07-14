package artgallery;

import java.sql.*;

//import com.mysql.jdbc.Connection;

public class DBConnect {
	
	public static Connection conn;
    public static	Statement smt;
	public static ResultSet rs;
	public static PreparedStatement addartist,removeartist,addartwork,updateartwork,addadmin,addimage,remove_artist,update_artworks;
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
			 addartist=conn.prepareStatement("insert into artist(name,description,contact,rating,max_rating,image) values(?,?,?,?,?,?)");
			 addadmin=conn.prepareStatement("insert into adminlogin values(?,?,?,?)");
			 removeartist=conn.prepareStatement("select * from artist where art_id=?");
			 remove_artist=conn.prepareStatement("delete from artist where art_id=?");
			 //rs=smt.executeQuery("delete from artist where art_id=?");
			  rs= smt.executeQuery("select art_id from artist");
			  addartwork=conn.prepareStatement("insert into artworks(details,name,price,artist_id,category,image) values(?,?,?,?,?,?)");
			  updateartwork=conn.prepareStatement("update artworks set details=?,name=?,price=?,category=?,artist_id=?,image=? where a_id=?");
			  update_artworks=conn.prepareStatement("select details,name,price,category from artworks where a_id=?");

			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


