package com.onlineexamportal.services;

import java.util.List;

import com.onlineexamportal.entity.User;
import com.onlineexamportal.entity.UserRole;

public interface UserService {
	
	User createUser(User user, List<UserRole> userRoles) throws Exception;

}
