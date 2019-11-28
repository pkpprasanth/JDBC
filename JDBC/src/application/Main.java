package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])  throws SQLException,ClassNotFoundException
	{
		Main main=new Main();
		main.choice();
	}

public void choice() throws SQLException,ClassNotFoundException
{
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("1.Admin Login \n2.Agent Login \n3.Exit");
	System.out.println("Enter the choice:");
	int n=sc.nextInt();
	switch(n)
	{
	case 1:
		Admin admin=new Admin();
		admin.adminData();
		break;
	case 2:
		Agent agent=new Agent();
		agent.agentData();
		break;
	case 3:
		System.out.println("Process will be complete");
		System.exit(0);
		
		
	}
}
}