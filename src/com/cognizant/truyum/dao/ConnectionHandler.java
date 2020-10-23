package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Properties;
public class ConnectionHandler  {
	private static Connection con=null;
private static Connection getConnection()
{
	try
	{
		FileInputStream fis=new FileInputStream("connection.properties");
		Properties pros=new Properties();
		pros.load(fis);
		Class.forName(pros.getProperty("driver"));
		con=DriverManager.getConnection(pros.getProperty("connection-url"),pros.getProperty("user"),pros.getProperty("password"));
	}
	catch(Exception e)
	{
		System.out.println("Connection was not Established");
	}
}
}
