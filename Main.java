package springIntroDemo;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		IProductServices productService = context.getBean("service",IProductServices.class);
		IProductDal productDal = context.getBean("database",IProductDal.class);
		productService.verifyProductToAdd("productName", 1000, "productCategory");
		productService.add();
		try {
			productDal.list();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
