package myapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update 
{
	ConnectionManager con=new ConnectionManager();
	public void updateData() throws SQLException,ClassNotFoundException
	{
	
	
	Scanner sc=new Scanner(System.in);
	int id=sc.nextInt();
	int newvalue=sc.nextInt();
	String newuser=sc.next();
	String newpass=sc.next();
	PreparedStatement ps=(PreparedStatement) con.getConnection().prepareStatement("update  login set id=?,Username=?,Password=? where id=?");
	ps.setInt(1,newvalue);
    ps.setString(2,newuser);
	ps.setString(3,newpass);
	ps.setInt(4,id);
	ps.executeUpdate();
	con.getConnection().close();
	System.out.println("Data Updated");
	
	Firstapp first=new Firstapp();
	first.choice();
	}
}


