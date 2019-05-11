package springIntroDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDal implements IProductDal {

	@Override
	public void add(String productName, int productPrice, String productCategory, String productId) throws SQLException {
		Connection connection = null;
		MysqlDbHelper dbHelper = new MysqlDbHelper();
		PreparedStatement statement = null;
		try {
			connection = dbHelper.connection();
			statement = connection.prepareStatement("insert into products (nameproducts,productidproducts,priceproduct,categoryproduct) values(?,?,?,?)");
			statement.setString(1,productName);
			statement.setString(2,productId);
			statement.setInt(3, productPrice);
			statement.setString(4, productCategory);
			statement.executeUpdate();
			System.out.println("Product succesfly added.");
		} catch (SQLException e) {
			System.out.println("Error code: " + e.getErrorCode());
			System.out.println("Error: " + e.getMessage());
		} finally {
			statement.close();
			connection.close();
		}
	}

	@Override
	public void list() throws SQLException {
		Connection connection = null;
		MysqlDbHelper dbHelper = new MysqlDbHelper();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = dbHelper.connection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *from springdemo.products");
			while (resultSet.next()) {
				System.out.println("------#" + resultSet.getInt("idproducts") + "#------");
				System.out.println("Product Name: " + resultSet.getString("nameproducts"));
				System.out.println("Product ID: " + resultSet.getString("productidproducts"));
				System.out.println("Product Price: " + resultSet.getInt("priceproduct"));
				System.out.println("Product Category: " + resultSet.getString("categoryproduct"));
			}
			System.out.println("------#End of products list#------");
		} catch (SQLException e) {
			System.out.println("Error code: " + e.getErrorCode());
			System.out.println("Error: " + e.getMessage());
		} finally {
			statement.close();
			connection.close();
		}
	}

}
