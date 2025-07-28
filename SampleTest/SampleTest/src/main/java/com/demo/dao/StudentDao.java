package com.demo.dao;

import java.util.List;

import com.demo.entities.Student;

public interface StudentDao {
	
	//Insert Query:
	public int insertStud(Student student);
	
	//Update Query:
	public int updateStud(Student student);

	//Delete Query:
	public int deleteStud(int studentId);
	
	//Search Query by ID:
	public Student searchStud(int studentId);
	
	//All Search Query:
	public List<Student> searchAllStud();

}
