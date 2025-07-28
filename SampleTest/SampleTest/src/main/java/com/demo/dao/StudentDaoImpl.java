package com.demo.dao;

import com.demo.entities.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String query;

	//Insert Query:
	public int insertStud(Student student) {
		query = "Insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
		
	}
	
	  //Update Query:
		public int updateStud(Student student) {
			query = "Update student set name=?, city=? where id=?";
			int r1 = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
			return r1;
		}
		
		//Delete Query:
		public int deleteStud(int studentId) {
			query = "Delete from student where id=?";
			int r2 = this.jdbcTemplate.update(query, studentId);
			return r2;
		}
		
		//Search Query by ID:
		public Student searchStud(int studentId) {
			// Select single student data
			query = "Select * from student where id=?";
			RowMapper<Student> rowMapper = new RowMapperImpl();
			Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
			return student;
		}
		
		//All Search Query:
		public List<Student> searchAllStud() {
			//  Select multiple student data
			query = "Select * from student where id=?";
			List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
			return students;
		}
		

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

}
