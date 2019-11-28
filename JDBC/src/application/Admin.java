package application;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin 
{
	ConnectionManager con=new ConnectionManager();
public boolean adminData() throws SQLException,ClassNotFoundException
{
	Scanner s=new Scanner(System.in);
	
	System.out.println("Enter the username");
	String  username=s.next();
	System.out.println("Enter the password");
	String  password=s.next();
	
	Statement st=(Statement) con.getConnection().createStatement();
	ResultSet rs=st.executeQuery("select username,password from login");
	while(rs.next()){
		if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password")))
		{
			System.out.println("Successfully Verified");
			con.getConnection().close();
			Admin admin=new Admin();
			admin.productData();
			return true;
		}
		else
		{
			System.out.println("Incorrect username or password");
			con.getConnection().close();
			return false;
		}
	}
	con.getConnection().close();
	return false;
	
	
}
public void productData() throws SQLException,ClassNotFoundException
{
	Scanner sc=new Scanner(System.in);
	System.out.println("1.Add product \n2.Display \n3.Exit");
	System.out.println("Enter the choice:");
	int n=sc.nextInt();
	
	switch(n)
	{
	case 1:
	System.out.println("Enter the product Id:");
	int productid=sc.nextInt();
	System.out.println("Enter the product Name:");
	String productname=sc.next();
	System.out.println("Enter the minsellquantity:");
	int minsellquantity=sc.nextInt();
	System.out.println("Enter the price:");
	int price=sc.nextInt();
	PreparedStatement ps=(PreparedStatement) con.getConnection().prepareStatement("insert into addproduct(productid,productname,minsellquantity,price,totalcost)values(?,?,?,?,?)");
	int totalcost=minsellquantity*price;
	ps.setInt(1, productid);
	ps.setString(2,productname);
	ps.setInt(3, minsellquantity);
	ps.setInt(4, price);
	ps.setInt(5, totalcost);
	ps.executeUpdate();
	con.getConnection().close();
	System.out.println("Product added successfully");
	Admin admin=new Admin();
	admin.productData();
	
    break;
	case 2:
		Statement  st=con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from addproduct");
		while(rs.next())
		{
			System.out.println(rs.getString("productid"));
			System.out.println(rs.getString("productname"));
			System.out.println(rs.getString("minsellquantity"));
			System.out.println(rs.getString("price"));
			System.out.println(rs.getString("totalcost"));
			Admin admin1=new Admin();
			admin1.productData();
			break;
		}
	case 3:
		System.out.println("Process will be completed");
		Main main=new Main();
		main.choice();
		break;
}
}
}










