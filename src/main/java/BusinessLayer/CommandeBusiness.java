package BusinessLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Beans.Commande;
import Utilities.JPAUtilities;

public class CommandeBusiness {
	
	private EntityManager entityManager;

	public CommandeBusiness(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/*
	 * add entity to database
	 */
	public void Add(Commande p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
	}
	/*
	 * modify entity in database
	 */
	public void Modify(Commande p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
	}
	/*
	 * delete entity in database
	 */
	public void Delete(Commande p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(p);
		tx.commit();
	}
	/*
	 * add entity to database
	 */
	public Commande findByID(int id) {
		Commande product = entityManager.find(Commande.class, id);
		return product;
	}
	/*
	 * add entity to database
	 */
	public List<Commande> findAll() {
		List<Commande> products = entityManager.createQuery("SELECT p FROM Commande p").getResultList();
		return products;
	}
}
