package com.sampleTest.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.sampleTest.entity.Student;

public class StudentDao {
	

	private HibernateTemplate hibernateTemplate;
	
	// Insert Query:
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	//Get single Data:
	public Student getStudent(int studentId)
	{
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	
	//Get All Students:
	public List<Student> getAllStudents()
	{
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//Delete Student Data:
	@Transactional
	public void deleteStudentId(int studentId) 
	{
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//Update Student Data:
	@Transactional
	public void updateStudent(Student student)
	{
		 this.hibernateTemplate.update(student);
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
