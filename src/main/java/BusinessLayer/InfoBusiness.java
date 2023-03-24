package BusinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Beans.Information;
import Utilities.JPAUtilities;

public class InfoBusiness{
	private EntityManager entityManager;

	public InfoBusiness(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/*
	 * add entity to database
	 */
	public void Add(Information p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
	}
	/*
	 * modify entity in database
	 */
	public void Modify(Information p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
	}
	/*
	 * delete entity in database
	 */
	public void Delete(Information p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(p);
		tx.commit();
	}
	/*
	 * add entity to database
	 */
	public Information findByID(int id) {
		Information product = entityManager.find(Information.class, id);
		return product;
	}
	/*
	 * add entity to database
	 */
	public List<Information> findAll() {
		List<Information> products = entityManager.createQuery("SELECT p FROM Information p").getResultList();
		return products;
	}
}
