package springIntroDemo;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDbHelper {
	//This interface manages database connections.
	Connection connection() throws SQLException;
}
