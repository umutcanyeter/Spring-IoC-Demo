package springIntroDemo;

public interface IProductServices {
	//This interface manages product apply processes
	void add();
	void verifyProductToAdd(String productName, int productPrice, String productCategory);
}
