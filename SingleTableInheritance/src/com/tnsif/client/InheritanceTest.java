package com.tnsif.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tnsif.entities.Employee;
import com.tnsif.entities.Manager;

public class InheritanceTest {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Employee emp = new Employee();
		emp.setName("Ärun");
		emp.setSalary(20000);
		entityManager.persist(emp);
		
		Manager manager = new Manager();
		manager.setName("Varun");
		manager.setSalary(30000);
		manager.setDepartmentName("HR");
		entityManager.persist(manager);
		
		entityManager.getTransaction().commit();
		
		System.out.println("Added one employee and manager to database.");
		
	}

}
