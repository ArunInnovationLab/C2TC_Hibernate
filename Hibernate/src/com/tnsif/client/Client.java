package com.tnsif.client;

import com.tnsif.entities.Student;
import com.tnsif.service.StudentService;
import com.tnsif.service.StudentServiceImpl;

public class Client {
	public static void main(String [] args) {
		
		StudentService service = new StudentServiceImpl();
		
		//Create operation
		Student student = new Student();
		student.setStudentId(1);
		student.setName("Sachin");
		service.addStudent(student);
		
		System.out.println("Student added. ");
	}
}
