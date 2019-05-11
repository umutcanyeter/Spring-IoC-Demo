package springIntroDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDbHelper implements IDbHelper {

	private String user ="root";
	private String password = "12345";
	private String dbUrl = "jdbc:mysql://localhost:3306/springdemo";
	
	@Override
	public Connection connection() throws SQLException {
		return DriverManager.getConnection(dbUrl,user,password);
	}

}
