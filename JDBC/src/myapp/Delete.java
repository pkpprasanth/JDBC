package myapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete 
{
	ConnectionManager con=new ConnectionManager();
	public void deleteData() throws SQLException,ClassNotFoundException
	{
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		//String user=sc.next();
		//String pass=sc.next();
		PreparedStatement ps=(PreparedStatement) con.getConnection().prepareStatement("delete from login where id=?");
		ps.setInt(1, id);
	
		ps.executeUpdate();
		con.getConnection().close();
		System.out.println("Data deleted");
		Firstapp first=new Firstapp();
		first.choice();

	}
}
