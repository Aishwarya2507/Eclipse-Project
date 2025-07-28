import java.io.*;
import java.util.*;

public class ToDoAppMain {
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        ToDoList toDoList = new ToDoList();

	        while (true) {
	            System.out.println("\nTo-Do List Application");
	            System.out.println("1. Add Task");
	            System.out.println("2. Remove Task");
	            System.out.println("3. Update Task");
	            System.out.println("4. Show Tasks");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");

	            int option = sc.nextInt();
	            sc.nextLine(); // Consume newline

	            switch (option) {
	                case 1:
	                	System.out.println("Enter Task Description: ");
	                	String description = sc.nextLine();
	                	toDoList.addTask(new ToDoItem(description));
	                	break;
	                case 2:
	                	toDoList.showTasks();
	                	System.out.println("Enter Task Number to remove: ");
	                	int index = sc.nextInt()-1;
	                	toDoList.removeTask(index);
	                	break;
	                case 3:
	                	toDoList.showTasks();
	                    System.out.print("Enter task number to update: ");
	                    int updateIndex = sc.nextInt() - 1;
	                    sc.nextLine(); // Consume newline
	                    System.out.print("Enter new description: ");
	                    String newDescription = sc.nextLine();
	                    toDoList.updateTask(updateIndex, newDescription);
	                    break;
	                case 4:
	                    toDoList.showTasks();
	                    break;
	                case 5:
	                    System.out.println("Exiting application...");
	                    return;
	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	    }

}
