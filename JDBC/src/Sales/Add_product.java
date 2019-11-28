package Sales;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Add_product {


public void addproduct() throws ClassNotFoundException, SQLException, IOException
{
	ConncetionManager con=new ConncetionManager();
	Scanner s=new Scanner(System.in);
	System.out.println("Add Product:");
	System.out.println("1.add product\n 2.display product\n 3.exit");
	int c=s.nextInt();
	if(c==1)
	{
	//Scanner s=new Scanner(System.in);
	 System.out.println("enter product_id");
	 int id=s.nextInt();
	 System.out.println("enter product_name");
	String name=s.next();
	 System.out.println("enter product_minsell");
	 int minsell=s.nextInt();
	 System.out.println("enter product_price");
	 int price=s.nextInt();
	 PreparedStatement ps=con.getConnection().prepareStatement("insert into add_product(pro_id,pro_name,pro_minsell,pro_price,total_cost)values(?,?,?,?,?)");
	 int total_cost=minsell*price;
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setInt(3,minsell);
		ps.setInt(4, price);
		ps.setInt(5,total_cost);
		ps.executeUpdate();
		con.getConnection().close();
		System.out.println("Data Inserted Successfully");
		Add_product addproduct=new Add_product();
		Bussiness bussiness=new Bussiness();
		bussiness.admin();
		con.getConnection().close();
	}	
	
	
	else if(c==2)
	{
		System.out.println("display product");
		Statement st=con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("Select *from add_product");
		
		while(rs.next())
		{	System.out.println("product_id");
			System.out.println(rs.getString("pro_id"));
			System.out.println("product_name");
			System.out.println(rs.getString("pro_name"));
			System.out.println("product_minsell");
			System.out.println(rs.getString("pro_minsell"));
			System.out.println("product_price");
			System.out.println(rs.getString("pro_price"));
			System.out.println("product_total cost");
			System.out.println(rs.getString("total_cost"));
			
		}
		Bussiness bussiness=new Bussiness();
		bussiness.admin();
		con.getConnection().close();
		
		//con.getConnection().close();
	


	}
	else if(c==3)
	{
		System.out.println("exit");
		System.exit(0);
		Add_product addproduct=new Add_product();
		addproduct.admin();
		con.getConnection().close();
	}
}

private void admin() {
	// TODO Auto-generated method stub
	
}
}