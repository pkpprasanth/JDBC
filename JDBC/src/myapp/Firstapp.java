package myapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Firstapp 
{
public static void main(String args[])  throws SQLException,ClassNotFoundException
{
	
	Firstapp first=new Firstapp();
	first.choice();
}

public void choice() throws SQLException,ClassNotFoundException
{
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("1.Insert \n2.View \n3.Update \n4.Delete \n5.Exit");
	System.out.println("Enter the choice:");
	int n=sc.nextInt();
	switch(n)
	{
	case 1:
		Insert insert=new Insert();
		insert.insertData();
		break;
	case 2:
		View view=new View();
		view.veiwData();
		break;
	case 3:
		Update update=new Update();
		update.updateData();
		break;
	case 4:
		Delete delete=new Delete();
		delete.deleteData();
	case 5:
		System.exit(0);
	}
}
}
