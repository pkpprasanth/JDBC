package Sales;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Bussiness
{
	Scanner s=new Scanner(System.in);
	ConncetionManager con=new ConncetionManager();
	public static void main(String agrs[]) throws ClassNotFoundException, SQLException, IOException
	{	
		Bussiness bussiness=new Bussiness();
		bussiness.admin();
	}
	

	


	public boolean admin() throws ClassNotFoundException, SQLException, IOException
	{
		Scanner s=new Scanner(System.in);
		
		ConncetionManager con=new ConncetionManager();
		System.out.println("1.Admin");
		System.out.println("2.Agent");
		System.out.println("3.Exit");
		int x=s.nextInt();
		Bussiness bussiness=new Bussiness();
		switch(x)
		{
		case 1:
				System.out.println("enter username");
				String username=s.next();
				System.out.println("enter password");
				String password=s.next();
				Statement st=con.getConnection().createStatement();
				String sql;
			    sql = "SELECT USERNAME,PASSWORD FROM ADMIN";
			    ResultSet rs=st.executeQuery(sql);
			    while(rs.next())
				{
					if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password")))
					{
						System.out.println("validate");
						Add_product addproduct=new Add_product();
						addproduct.addproduct();
						con.getConnection().close();
						return true;
						
					}
					else
					{
						System.out.println("not validate");
						con.getConnection().close();
						return false;
					}
				}
			    
				bussiness.admin();
				con.getConnection().close();
				return false;
		case 2:
		
				System.out.println("enter agent username");
				String user=s.next();
				System.out.println("enter agent password");
				String pass=s.next();
				ConncetionManager conn=new ConncetionManager();
				Statement st1=conn.getConnection().createStatement();
				String sql1;
			    sql1 = "SELECT USERNAME,PASSWORD FROM AGENT";
			    ResultSet rs1=st1.executeQuery(sql1);
			      
			    
				while(rs1.next())
				{
					if(user.equals(rs1.getString("username"))&& pass.equals(rs1.getString("password")))
					{
						System.out.println("validate");
						System.out.println("1.buysell \n 2.display \n 3.exit");
						Scanner o=new Scanner(System.in);
						int y=o.nextInt();
						if(y==1)
						{
							System.out.println("buy/sell");
									bussiness.buySell();
						}
									
						else if(y==2)
						{
							System.out.println("display product");
							bussiness.display();
							
						}
						
						conn.getConnection().close();
						
						return true;
						
					}
					else
					{
						System.out.println("not validate");
						conn.getConnection().close();
						return false;
					}
				
				}
	
		case 3:
		System.out.println("exit");
	}
		return false;
}





	private boolean display() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

				ConncetionManager cm=new ConncetionManager();
		        String id = null;
				String sql="select price from product where product_id="+id+"";
		        Statement st=cm.getConnection().createStatement();
		        ResultSet rs=st.executeQuery(sql);
		        while(rs.next())
		        {
		            Float cost=rs.getFloat("price");
		            Float minsell = null;
					cost=minsell*cost;
		            System.out.println("Cost is:"+cost+"\nEnter 1 to confirm Booking");
		        }
		        return true;
		
	}





	private boolean buySell() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stubpublic boolean buySell() throws ClassNotFoundException, SQLException,IOException
		 
				System.out.println("1.buysell ");
				Scanner s=new Scanner(System.in);
		        ConncetionManager cm=new ConncetionManager();
		        String sql1="select minsell,price from add_product where product_id=?";
		        Statement st1=cm.getConnection().createStatement();
		        ResultSet rs=st1.executeQuery(sql1);
		        while(rs.next())
		        {
		            int ch = rs.getInt("minsell");
		           {
		            
					int minsell = 0;
					if (ch >=minsell )
		            {
		            	
						int id = 0;
						price(id,minsell);
		                int x=s.nextInt();
		                if (x==1)
		                {
		                    String sql = "update product set minsell=" + ch + -minsell + " where product_id=" + id + "";
		                    PreparedStatement st = cm.getConnection().prepareStatement(sql);
		                    st.executeUpdate();
		                    System.out.println("Your Booking is Confirmed\nThank you...!!!");
		                }
		            }
		            else
		            {
		                    System.out.println("The Stock is not available choose less or Different Product");
		            }
		        
		           
		        cm.getConnection().close();
		        
		           }
		        }
				return false;
		 
		     
		
	}





	private boolean price(int id, int minsell) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

				ConncetionManager cm=new ConncetionManager();
		        String sql="select price from product where product_id="+id+"";
		        Statement st=cm.getConnection().createStatement();
		        ResultSet rs=st.executeQuery(sql);
		        while(rs.next())
		        {
		            Float cost=rs.getFloat("price");
		            cost=minsell*cost;
		            System.out.println("Cost is:"+cost+"\nEnter 1 to confirm Booking");
		        }
		        return true;
		// TODO Auto-generated method stub
		
	}
}


	
						
		

		 
		