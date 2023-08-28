package com.luv2code.cruddemo;

import java.util.List;

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
			createMultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all student");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retriev student based on the id
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		// change first name to "scooby"
		System.out.println("Updating student...");
		student.setFirstName("Scooby");
		studentDAO.update(student);

		// update the student
		studentDAO.update(student);

		// display updated student
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of student
		List<Student> students = studentDAO.findByLastName("Doe");

		// display list of students
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
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
