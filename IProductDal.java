package springIntroDemo;

import java.sql.SQLException;

public interface IProductDal {
	//This interface manages CRUD database processes
	void add(String productName, int productPrice, String productCategory, String productId) throws SQLException;
	void list() throws SQLException;
}
