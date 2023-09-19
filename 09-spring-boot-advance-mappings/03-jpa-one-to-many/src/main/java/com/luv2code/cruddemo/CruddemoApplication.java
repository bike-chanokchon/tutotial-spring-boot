package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// CommandLineRunner from Spring boot runner
	// Executed after the spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		// Java lambda expression
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			removeInstructorDetail(appDAO);
		};
	}

	public void removeInstructorDetail(AppDAO appDAO) {
		int id = 4;
		System.out.println("Deleting instructor detail id: " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("done!");
	}

	public void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int id = 3;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		// print the instructor detail
		System.out.println("instructorDetail:" + instructorDetail);

		// print associated instructor
		System.out.println("associated instructor:" + instructorDetail.getInstructor());

		System.out.println("done!");
	}

	public void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor id:" + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Done");
	}

	public void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor: " + instructor);
		System.out.println("the asscoiate instructor detail only: " + instructor.getInstructorDetail());
	}

	public void createInstructor(AppDAO appDAO) {
		// create instructor
		Instructor instructor = new Instructor("Chanokchon", "Wongjampa", "bike@gmail.com");
		
		// create instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("colorful.cc", "Luv 2 code!!!");
	
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		/*
		 * 
		 * NOTE: this will also save the details object
		 * because of CascadeType.ALL
		 * 
		 */
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done");
	}
}
 