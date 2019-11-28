package myapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class View {
	
	
	ConnectionManager con=new ConnectionManager();
	public void veiwData() throws SQLException,ClassNotFoundException
	{
		Statement  st=con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from login");
		while(rs.next())
		{
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("Username"));
			System.out.println(rs.getString("Password"));
		}
		Firstapp first=new Firstapp();
		first.choice();
}
}
