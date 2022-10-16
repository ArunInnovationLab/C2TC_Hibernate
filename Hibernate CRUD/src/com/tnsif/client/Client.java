package com.tnsif.client;
			
import com.tnsif.entities.Student;
import com.tnsif.service.StudentService;
import com.tnsif.service.StudentServiceImpl;
			
public class Client {
	public static void main(String [] args) {
		
		StudentService service = new StudentServiceImpl();
		
		Student student = new Student();
		
//		//Create operation
//		student.setStudentId(2);
//		student.setName("Rahul");
//		service.addStudent(student);
//		
//		//Delete operation
//		student = service.findStudentById(1);
//		service.removeStudent(student);
//		System.out.println("Student deleted .");
//		
//		//Update operation
//		student = service.findStudentById(2);
//		student.setName("Rahul Kumar");
//		service.updateStudent(student);
//		System.out.println("Student updated");
		
		//Retrieve operation
		student = service.findStudentById(2);
		System.out.println("ID: "+student.getStudentId());
		System.out.println("Name: "+student.getName());
	}
}
