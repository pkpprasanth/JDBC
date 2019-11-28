import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Jdbc {

	private static Connection NULL;

	public static void main(String[] args)  throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","");
		if(con!=NULL)
		{
			System.out.printf("WELCOME");
			
		}
		else
		{
			System.out.printf("NOT WELCOME");
		}
	}
}
