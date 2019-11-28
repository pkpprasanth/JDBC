package myapp;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Insert 
{
ConnectionManager con=new ConnectionManager();
public void insertData() throws SQLException,ClassNotFoundException
{
	Scanner sc=new Scanner(System.in);
	int id=sc.nextInt();
	//sc.next();
	String user=sc.next();
	String pass=sc.next();
	PreparedStatement ps=(PreparedStatement) con.getConnection().prepareStatement("insert into login(id,Username,Password)values(?,?,?)");
	ps.setInt(1, id);
	ps.setString(2,user);
	ps.setString(3, pass);
	ps.executeUpdate();
	con.getConnection().close();
	System.out.println("Data saved");
	Firstapp first=new Firstapp();
	first.choice();

}

}
