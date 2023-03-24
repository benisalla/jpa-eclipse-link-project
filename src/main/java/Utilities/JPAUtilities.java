package Utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilities {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager(String PersistUnit) {
		if(entityManager == null) {
			factory = Persistence.createEntityManagerFactory(PersistUnit);
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

}
