package BusinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Beans.Product;
import Utilities.JPAUtilities;

public class ProductBusiness {
	
	private EntityManager entityManager;

	public ProductBusiness(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/*
	 * add entity to database
	 */
	public Product Add(Product p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
		return p;
	}
	/*
	 * modify entity in database
	 */
	public Product Modify(Product p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
		return p;
	}
	/*
	 * delete entity in database
	 */
	public void Delete(int id) {
		Product p = findByID(id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(p);
		tx.commit();
	}
	/*
	 * add entity to database
	 */
	public Product findByID(int id) {
		Product product = entityManager.find(Product.class, id);
		return product;
	}
	/*
	 * add entity to database
	 */
	public List<Product> findAll() {
		List<Product> products = entityManager.createQuery("SELECT p FROM Product p").getResultList();
		return products;
	}
	
	/*
	 * add entity to database
	 */
	public List<Product> SearchByHint(String hint) {
		List<Product> products = entityManager.createQuery("SELECT p FROM Product p where p.type like '%"+hint+"%'").getResultList();
		return products;
	}
	
	
}