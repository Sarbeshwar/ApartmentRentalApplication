package java_files;

import java.sql.Connection;
import java.sql.DriverManager;

public class testDatabase 
{
	public static void main(String[] args)
	{
		String user = "root";
		String pass = "@mik@ool";

		String jdbcUrl = "jdbc:mysql://localhost:3306/appartmentrental?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.cj.jdbc.Driver";

		// get connection to database
		try
		{

			System.out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("SUCCESS!!!");

			myConn.close();

		}catch(
		Exception exc)
		{
			exc.printStackTrace();
		}
	}
}

