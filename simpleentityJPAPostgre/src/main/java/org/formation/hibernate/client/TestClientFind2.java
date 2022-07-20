package org.formation.hibernate.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.hibernate.entity.Adresse;
import org.formation.hibernate.entity.Person;

public class TestClientFind2 {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		Person p4 = em.find(Person.class, 1L);
		System.out.println(p4);
		p4.getAdresse().setCity("chicago");
		Person p5 = em.find(Person.class, 1L);
		System.out.println(p5);
		TypedQuery<Person> createQuery = em.createQuery("From Person", Person.class);
		createQuery.getFirstResult();
		List<Person> resultList = createQuery.getResultList();
		System.out.println();

		// reference de méthode
		resultList.forEach(System.out::println);

		resultList.forEach(p -> System.out.println(p));

		if (em != null) {
			em.close();
		}
		if (emf != null) {
			emf.close();
		}
	}
}
