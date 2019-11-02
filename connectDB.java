package logicalService;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connectDB {
	public Statement getConnection() throws SQLException{
		try {
			Class.forName("org.git.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String DBusr="root";
		String DBpwd="root";
		Connection cnn=DriverManager.getConnection(url, DBusr, DBpwd);
		Statement stmt=cnn.createStatement();
		return stmt;		
	}

}
