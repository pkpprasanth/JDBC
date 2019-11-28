package application;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Agent
{
	ConnectionManager con=new ConnectionManager();
	public boolean agentData() throws SQLException,ClassNotFoundException
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the username");
		String  username=s.next();
		System.out.println("Enter the password");
		String  password=s.next();
		
		Statement st=(Statement) con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select username,password from Agentlogin");
		while(rs.next()){
			if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password")))
			{
				System.out.println("Successfully Verified");
				con.getConnection().close();
				
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
	public boolean buySell(int id,int q) throws ClassNotFoundException, SQLException,IOException
    {
        ConnectionManager con=new ConnectionManager();
        Scanner sc=new Scanner(System.in);
        String sql1="select minsellquantity from product where product_id="+id+"";
        Statement st1=con.getConnection().createStatement();
        ResultSet rs=st1.executeQuery(sql1);
        while(rs.next())
        {
            int ch = rs.getInt("minsellquantity");
            if (ch >= q)
            {
                price(id,q);
                int x=sc.nextInt();
                if (x==1) {
                    String sql = "update product set minsellquantity=" + ch + -q + " where product_id=" + id + "";
                    PreparedStatement st = con.getConnection().prepareStatement(sql);
                    st.executeUpdate();
                    System.out.println("Your Booking is Confirmed\nThank you...!!!");
                }
            }
            else
            {
                    System.out.println("The Stock is not available choose less or Different Product");
            }
        }
        con.getConnection().close();
        return true;
    }
    public boolean display(int id)throws ClassNotFoundException, SQLException,NumberFormatException
    {
        ConnectionManager cm=new ConnectionManager();
        String sql="select * from product where product_id="+id+"";
        Statement st=cm.getConnection().createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            System.out.println(rs.getInt("product_id")+" "+rs.getString("product_name")+" "+rs.getInt("minsellquantity")+" "+rs.getFloat("price"));
        }
        cm.getConnection().close();
        return true;
    }
    public boolean price(int id,int q)throws ClassNotFoundException, SQLException
    {
        ConnectionManager cm=new ConnectionManager();
        String sql="select price from product where product_id="+id+"";
        Statement st=cm.getConnection().createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            Float cost=rs.getFloat("price");
            cost=q*cost;
            System.out.println("Cost is:"+cost+"\nEnter 1 to confirm Booking");
        }
        return true;
    }
	
  
	
}
