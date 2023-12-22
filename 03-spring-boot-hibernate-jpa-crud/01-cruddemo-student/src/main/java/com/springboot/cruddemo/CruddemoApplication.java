package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
			
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numberRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted row count: " + numberRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting student id: 3");
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Getting student with id: 1");
		Student student = studentDAO.findById(1);

		System.out.println("Updating student...");
		student.setFirstName("John");

		studentDAO.update(student);

		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByLastName("Duck");

		for (Student student: students){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO){

		List<Student> students = studentDAO.findAll();

		for (Student student: students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO){
		// create a student
		System.out.println("Creating student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		// retrieve student based on the id: pk
		System.out.println("Retrieving teh student given id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John","Doe","john@gmail.com");
		Student tempStudent2 = new Student("Mary","Public","mary@gmail.com");
		Student tempStudent3 = new Student("Bonita","Applebum","applebum@gmail.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul","Doe","pauldoe@gmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
