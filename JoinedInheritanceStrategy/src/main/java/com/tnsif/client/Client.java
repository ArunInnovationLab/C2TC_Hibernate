package com.tnsif.client;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;

import com.tnsif.entities.Employee;
import com.tnsif.entities.Person;
import com.tnsif.entities.Student;
import com.tnsif.util.HibernateUtil;

public class Client {
							
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Person person = new Person();
		person.setName("Sudha Verma");
		person.setGender("Female");
		
		Employee employee = new Employee();
		employee.setBonus(new BigDecimal("277.389"));
		employee.setDeptName("IT");
		employee.setDoj(getDoj("18/12/2015"));
		employee.setEmail("dipesh.cs@gmail.com");
		employee.setName("Dipesh");
		employee.setSalary(80000.2872);
		employee.setGender("Male");
		
		Student student = new Student();
		student.setName("Shuruti");
		student.setGender("Female");
		student.setFee(20000.00f);
		student.setSchoolName("DPS");
		student.setSectionName("12th Std");
		
		session.beginTransaction();
		session.save(person);
		session.save(student);
		session.save(employee);
		
		session.getTransaction().commit();
	}

	private static LocalDate getDoj(String string) {
		LocalDate date = LocalDate.parse(string, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return date;
	}


}
