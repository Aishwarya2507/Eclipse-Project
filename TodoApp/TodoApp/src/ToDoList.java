import java.util.*;
import java.io.*;

public class ToDoList {
	
	private List<ToDoItem> toDoItem;

    public ToDoList() {
        this.toDoItem = new ArrayList<>();
    }

    // All Methods:
    // Add Task:
    public void addTask(ToDoItem toDoItems) {
    	toDoItem.add(toDoItems);
    }
    
    
    // Update Task:
    public void updateTask(int index, String newDescription) {
    	if(index >= 0 && index < toDoItem.size()) {
    		ToDoItem toDoItems = toDoItem.get(index);
    		toDoItems.setDescription(newDescription);
    		System.out.println("Task Updated Successfully..");
    	} else {
    		System.out.println("Invalid task number.");
    	}
    }

    // Remove Task:
    public void removeTask(int index) {
    	if(index >= 0 && index < toDoItem.size()) {
    		toDoItem.remove(index);
    		System.out.println("Task Removed Successfully..");
    	} else {
    		System.out.println("Invalid task number.");
    	}
    }

    
    // Show Task:
    public void showTasks() {
    	if(toDoItem.isEmpty()) {
    		System.out.println("Your to-do List is empty.");
    	} else {
    		System.out.println("To-Do List:");
    		for(int i = 0; i < toDoItem.size(); i++) {
    			System.out.println((i + 1) + ". " + toDoItem.get(i).getDescription());
    		}
    		
    	}
    }
	
	

}
