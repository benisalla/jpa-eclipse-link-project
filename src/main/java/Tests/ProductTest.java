package Tests;

import java.util.List;

import javax.persistence.EntityManager;

import Beans.Product;
import BusinessLayer.ProductBusiness;
import Utilities.JPAUtilities;



public class ProductTest {
	public static void main(String[] args) {
		Product p = new Product(0, 10f, 100f, "test");
		EntityManager entityManager = JPAUtilities.getEntityManager("JPA_eclipselink_app");
		ProductBusiness productBusiness = new ProductBusiness(entityManager);
		productBusiness.Add(p);
		
		List<Product> products = productBusiness.SearchByHint("product");
		
		for (Product product : products) {
			System.out.println(product.toString());
		}
	}
}
