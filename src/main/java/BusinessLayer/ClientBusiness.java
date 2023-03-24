package BusinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Beans.Client;
import Utilities.JPAUtilities;

public class ClientBusiness {
	
	private EntityManager entityManager;

	public ClientBusiness(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/*
	 * add entity to database
	 */
	public void Add(Client p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
	}
	/*
	 * modify entity in database
	 */
	public void Modify(Client p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
	}
	/*
	 * delete entity in database
	 */
	public void Delete(Client p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(p);
		tx.commit();
	}
	/*
	 * add entity to database
	 */
	public Client findByID(int id) {
		Client product = entityManager.find(Client.class, id);
		return product;
	}
	/*
	 * add entity to database
	 */
	public List<Client> findAll() {
		List<Client> products = entityManager.createQuery("SELECT p FROM Client p").getResultList();
		return products;
	}
}
