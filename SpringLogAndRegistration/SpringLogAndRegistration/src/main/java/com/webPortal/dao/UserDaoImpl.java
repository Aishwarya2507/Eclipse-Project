package com.webPortal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.webPortal.model.UserInfo;
 

@Repository
public class UserDaoImpl implements UserDao {
	
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List list() {
		String sql = "Select username from users";
		
		List list = namedParameterJdbcTemplate.query(sql,  getSqlParameterSource(null, null), new UserMapper());
		return list;
	}
	
	
	private SqlParameterSource getSqlParameterSource(String username, String password) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		if(username !=null) {
			parameterSource.addValue("username", username);
		}
		if(password !=null) {
			parameterSource.addValue("password", password);
		}
		
		return parameterSource;
	}
	
	
	private static final class UserMapper implements RowMapper{
		
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
			UserInfo user = new UserInfo();
			user.setUsername(rs.getString("username"));
			
			return user;
			
		}
	}
	
	
	
	public UserInfo findUserByUsername(String username) {
		String sqlSelect = "Select username frm users where username = :username";
		
		List list = namedParameterJdbcTemplate.query(sqlSelect, getSqlParameterSource(username, null), new UserMapper());
		
		return (UserInfo) list.get(0);
	}
	

	public void update(String username, String password) {
		String sqlUpdate = "Update users set password = :password where username = :username";
		
		namedParameterJdbcTemplate.update(sqlUpdate, getSqlParameterSource(username, password));
		
	}
	

	public void add(String username, String password) {
		String sqlAdd = "Insert int users(username, password) values(:username,password)";
		namedParameterJdbcTemplate.update(sqlAdd, getSqlParameterSource(username, password));
		
		
		String sqlAdds = "Insert into user_roles(username, role) values(:username, 'ROLE_USER')";
		  namedParameterJdbcTemplate.update(sqlAdds, getSqlParameterSource(username, password));
		
	}

	public boolean userExists(String username) {
		String sqlExists = "Select * from users where username = :username";
		
		List list = namedParameterJdbcTemplate.query(sqlExists, getSqlParameterSource(username,null), new UserMapper());
		
		if(list.size() > 0) {
			return true;
		}
		return false;
	}
	

}
