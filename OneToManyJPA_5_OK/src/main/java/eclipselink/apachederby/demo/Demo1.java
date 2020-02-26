package eclipselink.apachederby.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eclipselink.apachederby.entity.Photos;
import eclipselink.apachederby.entity.Players;

public class Demo1 {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OneToManyJPA_5");
		EntityManager entitymanager = emfactory.createEntityManager();
		// Players Photos

		Players players1 = new Players();
		players1.setAge(11);
		players1.setBirth(new Date());
		players1.setName("Veniamin");
		players1.setSurname("Jessos");
		
		
		Set<Photos> photoSet1 = new HashSet<Photos>() {
			private static final long serialVersionUID = 1L;

			{
				  add(new Photos(  "Photos A1", players1));
				  add(new Photos(  "Photos A2", players1));
				  add(new Photos(  "Photos A2", players1));

			}
		};
		
		players1.setPhotos(photoSet1);
		
		Players players2 = new Players();
		players2.setAge(12);
		players2.setBirth(new Date());
		players2.setName("Nikola");
		players2.setSurname("Nekolin");
		
		
		Set<Photos> photoSet2 = new HashSet<Photos>() {
			private static final long serialVersionUID = 1L;
			
			{
				add(new Photos("Pic 21", players2));
				add(new Photos("Pic 22", players2));
				add(new Photos("Pic 23", players2));
			}
		};

		players2.setPhotos(photoSet2);
		

		try {
			entitymanager.getTransaction().begin();

			entitymanager.persist(players1);
			entitymanager.persist(players2);
			

			entitymanager.getTransaction().commit();
			System.out.println("-----commited OK------");
		} catch (Exception e) {
			e.printStackTrace();
			entitymanager.getTransaction().rollback();
		} finally {
			if (entitymanager != null) {
				entitymanager.close();
			}
			if (emfactory != null) {
				emfactory.close();
			}
		} //---

	}

}
