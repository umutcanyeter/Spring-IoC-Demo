package springIntroDemo;

import java.sql.SQLException;

public class ProductManager implements IProductServices {

	private IProductDal productDal;
	
	public ProductManager(IProductDal productDal) {
		this.productDal = productDal;
	}

	private String productName;
	private int productPrice;
	private String productCategory;
	private String productId;
	
	@Override
	public void add() {
		try {
			productDal.add(productName, productPrice, productCategory, productId);
		} catch (SQLException e) {
			System.out.println("Product cannot added.");
			System.out.println("Error code: " + e.getErrorCode());
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public void verifyProductToAdd(String productName, int productPrice, String productCategory) {
		char categoryFirstChar = productCategory.charAt(0);
		String price = Integer.toString(productPrice);
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productId = categoryFirstChar+price;
		System.out.println("Product succesfly verified, adding product to database.");
	}

}
