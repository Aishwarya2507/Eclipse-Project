package com.sampleTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sampleTest.dao.StudentDao;
import com.sampleTest.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
  
	public static void main( String[] args )
    {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao =  context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(231, "Johnson", "Mumbai");
//        int r = studentDao.insert(student);
//        System.out.printf("Done", +r);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean go = true;
        while(go) {
        System.out.println("PRESS 1 for Add New Student");
        System.out.println("PRESS 2 for Display All Students");
        System.out.println("PRESS 3 for Get Detail of Single Student");
        System.out.println("PRESS 4 for Delete Student");
        System.out.println("PRESS 5 for Update Student");
        System.out.println("PRESS 6 for Exit");
        
        try {
        	int input = Integer.parseInt(br.readLine());
        	
        	switch (input) {
			case 1:
				//Add a new Student
				//Taking Inputs from users
				System.out.println("Enter user id:");
				int uId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter user name:");
				String uName = br.readLine();
				
				System.out.println("Enter user city:");
				String uCity = br.readLine();
				
				// Creating student object& setting values
				Student s = new Student(uId, uName, uName);
				s.setId(uId);
				s.setName(uName);
				s.setCity(uCity);
				
				//Saving student object to database by calling insert of student dao
				int r = studentDao.insert(s);
				System.out.printf("Student Added", +r);
				System.out.println("**********************************");
				System.out.println();
			
				break;
				
			case 2:
				//Display All Student
				System.out.println("**********************************");
				List<Student> allStudents = studentDao.getAllStudents();
				for (Student st : allStudents) {
					System.out.println("Id:" + st.getId());
					System.out.println("Name:" + st.getName());
					System.out.println("City:" + st.getCity());
					System.out.println("----------------------------------");
					
				}
				
				System.out.println("**********************************");
				
				break;
				
			case 3:
				//Get Single Student Data by Id
				System.out.println("Enter user id:");
				int userId = Integer.parseInt(br.readLine());
				Student student = studentDao.getStudent(userId);
				System.out.println("Id:" + student.getId());
				System.out.println("Name:" + student.getName());
				System.out.println("City:" + student.getCity());
				System.out.println("----------------------------------");
				
				break;
				
			case 4:
				//Delete Student by Id
				System.out.println("Enter user id:");
				int Id = Integer.parseInt(br.readLine());
				studentDao.deleteStudentId(Id);
				System.out.println("Student Deleted....");
				
				break;
				
			case 5:
				//Update Student
				System.out.println("Enter user id:");
				int usersId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter user name:");
				String usersName = br.readLine();
				
				System.out.println("Enter user city:");
				String usersCity = br.readLine();
				
				// Creating student object& setting values
				Student stu = new Student(usersId, usersName, usersName);
				stu.setId(usersId);
				stu.setName(usersName);
				stu.setCity(usersCity);
				
				//Saving student object to database by calling insert of student dao
				int res = studentDao.insert(stu);
				System.out.printf("Student Added", +res);
				System.out.println("**********************************");
				System.out.println();
				
				break;
				
			case 6:
				//Exit
				go = false;
				break;  // Loop
				
				
		
			}
        	
        }catch(Exception e) 
        {
        	System.out.println("Invalid Input try with Another one !!");
            System.out.println(e.getMessage());
        }
        
        }
        System.out.println("Thank You.......");
        System.out.println("See You Soon !!");
    }
}
