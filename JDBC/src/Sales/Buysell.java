package Sales;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Buysell {


public boolean buySell() throws ClassNotFoundException, SQLException,IOException
	 {
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
	     
	    

	private boolean price(int id, int minsell) throws ClassNotFoundException, SQLException 
	{
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
	  }



	public boolean display(int id)throws ClassNotFoundException, SQLException,NumberFormatException
   {
	  ConncetionManager cm=new ConncetionManager();
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
}
