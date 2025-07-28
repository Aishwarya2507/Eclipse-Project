package com.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.dao.StudentDao;
import com.demo.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started...." );
        ApplicationContext context = new AnnotationConfigApplicationContext("JdbcConfig.class");
        
//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        
//        String query = "Insert into student(id,name,city) values(?,?,?)";
//        
//        // Fire Query :
//        int result = template.update(query,125,"Mack","Delhi");
//        System.out.printf("Number of Records Inserted", + result);
        
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        Student student = new Student();
        
        //Insert Query:
        student.setId(126);
        student.setName("Jassy");
        student.setCity("Nagpur");
        
        int result = studentDao.insertStud(student);
        System.out.printf("Student is added", + result);
        
        //Update Query:
        student.setId(123);
        student.setName("Jassy");
        student.setCity("Nagpur");
        
        int result1 = studentDao.updateStud(student);
        System.out.printf("Student is updated", + result1);
       
       //Delete Query:
       int result2 = studentDao.deleteStud(125);
       System.out.printf("Student is deleted", + result2);
       
     //Search Query:
       Student student1 = studentDao.searchStud(123);
       System.out.println(student1);
       
       
     //All Search Query:
       List<Student> students = studentDao.searchAllStud();
       for(Student s : students)
       System.out.println(s);
        
    }
}
