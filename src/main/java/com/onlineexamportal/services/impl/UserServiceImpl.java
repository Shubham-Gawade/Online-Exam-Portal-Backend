package com.onlineexamportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexamportal.entity.User;
import com.onlineexamportal.entity.UserRole;
import com.onlineexamportal.repositories.RoleRepository;
import com.onlineexamportal.repositories.UserRepository;
import com.onlineexamportal.services.UserService;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	//Create new user
	public User createUser(User user, List<UserRole> userRoles) throws Exception {
		User existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser != null) {
			throw new Exception("Username already exist.");
		}else {
			for(UserRole userRole:userRoles) {
				roleRepository.save(userRole.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			existingUser = userRepository.save(user);
		}
		return existingUser;
	}

}
