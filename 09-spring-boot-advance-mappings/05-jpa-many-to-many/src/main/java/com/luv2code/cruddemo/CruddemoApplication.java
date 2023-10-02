package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import com.luv2code.cruddemo.entity.Student;

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
			// createCourseAndStudents(appDAO);
			// findCourseAndStudents(appDAO);
			// findSudentAndCourses(appDAO);
			addMoreCoursesForStudent(appDAO);
		};
	}

	public void addMoreCoursesForStudent(AppDAO appDAO) {
		int studentId = 2;
		Student student = appDAO.findStudentAndCoursesByStudentId(studentId);
	
		// create more courses
		Course course1 = new Course("Java basic");
		Course course2 = new Course("Java intermedia");
		Course course3 = new Course("Java high level");

		// add course to student
		student.addCourse(course1);
		student.addCourse(course2);
		student.addCourse(course3);

		System.out.println("Updating student: " + student);

		appDAO.update(student);

		System.out.println("Done");
	}

	public void findSudentAndCourses(AppDAO appDAO) {
		int studentId = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(studentId);

		System.out.println("Loaded student: " + student);
		System.out.println("Courses: " + student.getCourses());

		System.out.println("Done!");
	}

	public void findCourseAndStudents(AppDAO appDAO) {
		int courseId = 10;
		Course course = appDAO.findCourseByid(courseId);

		System.out.println("Loaded course: " + course);
		System.out.println("Student: " + course.getStudents());

		System.out.println("Done!");
	}

	public void createCourseAndStudents(AppDAO appDAO) {
		// create a course
		Course course = new Course("Pacman - How to score one million point");

		// create the students
		Student student1 = new Student("A", "A", "C");
		Student student2 = new Student("B", "B", "C");
		Student student3 = new Student("C", "C", "C");

		// add students to course
		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		// save the course and associated students
		System.out.println("Saving the course: " + course);
		System.out.println("associated students: " + course.getStudents());
	
		appDAO.save(course);
	}

	public void deleteCOurseAndReviews(AppDAO appDAO) {
		int courseId = 10;

		System.out.println("Deleting course id: " + courseId);

		appDAO.deleteCourseById(courseId);

		System.out.println("Done!");
	}

	public void retrieveCourseAndReview(AppDAO appDAO) {
		// get the course and reviews
		int courseId = 10;
		Course course = appDAO.findCourseAndReviewByCourseId(courseId);

		// print the course
		System.out.println(course);

		// print the reviews
		System.out.println(course.getReviews());

		System.out.println("Done!");
	}

	public void createCourseReviews(AppDAO appDAO) {
		// create a course
		Course course = new Course("Pacman - How to score one millian points");

		// add some review
		course.addReview(new Review("Great course... loved it!"));
		course.addReview(new Review("Cool course, job well done."));
		course.addReview(new Review("What a dump course, you are an idiot!"));

		// save the course and leverage the cascade all
		System.out.println("Saving the course");
		appDAO.save(course);
		System.out.println(course);
		System.out.println(course.getReviews());
	}

	public void deleteCourseById(AppDAO appDAO) {
		int courseId = 12;

		System.out.println("Deleting course id: " + courseId);

		appDAO.deleteCourseById(courseId);

		System.out.println("Done!");
	}

	public void updateCourse(AppDAO appDAO) {
		int id = 12;

		// find the course
		System.out.println("Finding course id: " + id);
		Course course = appDAO.findCourseByid(id);

		// update the course
		System.out.println("Updating course id: " + id);
		course.setTitle("Enjoy the simple thing");

		appDAO.update(course);

		System.out.println("Done!");
	}

	public void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int instructorId = 2;

		// find instructor
		System.out.println("Finding instructor id: " + instructorId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(instructorId);

		System.out.println("instructor: " + instructor);
		System.out.println("instructor detail: " + instructor.getInstructorDetail());
		System.out.println("courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	public void findCoursesForInstructor(AppDAO appDAO) {
		int instructorId = 2;

		// find instructor
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Finding instructor id: " + instructorId);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + instructorId);
		List<Course> courses = appDAO.findCoursesByInstructorId(instructorId);
		
		// set course to instructor
		instructor.setCourses(courses);
		System.out.println("the associated courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	public void findInstructorWithCourses(AppDAO appDAO) {
		int instructorId = 2;
		System.out.println("Finding instructor id: " + instructorId);

		// จะฆลดมาแค่ instructor ไม่โหลด courses มาเพราะ fetch type เป็นแบบ lazy load (default)
		Instructor instructor = appDAO.findInstructorById(instructorId);

		System.out.println("instructor: " + instructor);
		System.out.println("courses: " + instructor.getCourses());
		
		System.out.println("Done");
	}

	public void createInstructorWithCourses(AppDAO appDAO) {
		// create instructor
		Instructor instructor = new Instructor("Chanokchon", "Wongjampa", "bike.chanokchon2001@gmail.com");
		
		// create instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "coding");
	
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course course1 = new Course("Air Guitar - The ultimate guide");
		Course course2 = new Course("The pinball masterclass");

		// add courses to instructor
		instructor.add(course1);
		instructor.add(course2);

		// save instructor
		// NOTE: this will also save the course
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: " + instructor);
		System.out.println("The course : " + instructor.getCourses());
		appDAO.save(instructor);
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
		int id = 2;
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
 