package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.AppDAO;
import com.springboot.cruddemo.entity.Instructor;
import com.springboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            // createInstructor(appDAO);

            // findInstructor(appDAO);

            // deleteInstructor(appDAO);

            // findInstructorDetail(appDAO);

            deleteInstructorDetail(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("John", "Doe", "john@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "Fishing");
        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor: " + instructor);
        appDAO.save(instructor);

        System.out.println("Done!");
    }

    public void findInstructor(AppDAO appDAO){
        System.out.println("Instructor: " + appDAO.findInstructorById(1));
    }

    public void deleteInstructor(AppDAO appDAO){
        appDAO.deleteInstructorById(1);
        System.out.println("Deleted");
    }

    public void findInstructorDetail(AppDAO appDAO){
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(1);
        System.out.println("Instructor Detail: " + instructorDetail);
        System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
    }

    public void deleteInstructorDetail(AppDAO appDAO){
        appDAO.deleteInstructorDetailById(2);
        System.out.println("Done!");
    }
}
