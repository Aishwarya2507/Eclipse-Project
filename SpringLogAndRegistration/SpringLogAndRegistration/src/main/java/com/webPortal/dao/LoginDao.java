package com.webPortal.dao;

import java.util.List;

import com.webPortal.model.UserInfo;

public interface LoginDao {
	
	UserInfo findUserInfo(String username);
	List getUserRoles(String username);

}
