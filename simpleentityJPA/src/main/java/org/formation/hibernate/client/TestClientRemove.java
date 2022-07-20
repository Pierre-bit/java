package org.formation.hibernate.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.hibernate.entity.Adresse;
import org.formation.hibernate.entity.Person;

public class TestClientRemove {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			Adresse adresse = new Adresse("arkham","gothamcity",478952L);
			Person person = new Person("Joker",25,adresse);
			em.persist(person);
			Person p3 = em.find(Person.class, 2L);
			System.out.println(p3);
			em.remove(p3);
			Person p4 = em.find(Person.class, 2L);
			System.out.println(p4);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}
