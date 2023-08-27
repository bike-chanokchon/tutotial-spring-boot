package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// executed after Spring beans have loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		// Java lambda expression
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating new student objects...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@hotmail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of saved studemt
		int id = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + id);

		// retrieve student based on the id
		System.out.println("Retrieving student with id: " + id);
		Student myStudent = studentDAO.findById(id);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating new student object...");
		Student student1 = new Student("Paul", "Doe", "abc@gmail.com");
		Student student2 = new Student("Mary", "Public", "def@gmail.com");
		Student student3 = new Student("Bonita", "Appebum", "kdk@gmail.com");

		// save student object
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student objects
		System.out.println("Creating new student object...");
		Student student = new Student("Paul", "Doe", "abc@gmail.com");

		// save student object
		System.out.println("Saving the student");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generate id: " + student.getId());
	}
}
