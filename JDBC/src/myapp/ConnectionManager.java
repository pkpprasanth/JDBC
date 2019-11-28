package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
	public Connection getConnection() throws SQLException,ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/application","root","");
		if(con!=null)
		{
			return con;
		}
		else
		{
			return null;
		}
	}

}
