package my.poc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConn {
 
	public static Connection getConnection() throws SQLException {
		String Url = "jdbc:sqlserver://GGKU2Ser6;databaseName=run;user=ranjith.reddi;password=UIKMNHJ123$";
		return DriverManager.getConnection(Url);
	}
	public static Connection getConnection(String hostName, String database, String userName, String password) throws SQLException {
		String Url = "jdbc:sqlserver://"+hostName+";databaseName="+database+";user="+userName+";password="+password;
		return DriverManager.getConnection(Url);
	}
}
