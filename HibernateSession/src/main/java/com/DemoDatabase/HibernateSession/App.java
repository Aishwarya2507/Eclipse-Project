package com.DemoDatabase.HibernateSession;

/**
 * Hello world!
 *
 */
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
    	// Create a new session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // Create an Employee object
        Employee employee = new Employee(1L, "John Doe", "IT");

        // Save the employee
        session.save(employee);

        // Commit the transaction
        transaction.commit();

        // Retrieve the employee
        Employee retrievedEmployee = session.get(Employee.class, 1L);
        System.out.println("Retrieved Employee: " + retrievedEmployee.getName());

        // Close the session
        session.close();
        HibernateUtil.shutdown();
    
    }
}
