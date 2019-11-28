package Sales;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ConncetionManager {




public Connection getConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=(Connection)DriverManager.getConnection("jdbc:mysql://127.0.01:3306/Shopping","root","");
		if(con!=null)
		{
			return con;
		}
		else
		{
			return null;
		}
		
		
	}

public Statement createStatement() {
	// TODO Auto-generated method stub
	return null;
}

}
