package com.onlineexamportal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexamportal.entity.Role;
import com.onlineexamportal.entity.User;
import com.onlineexamportal.entity.UserRole;
import com.onlineexamportal.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("")
	public User createUser(@RequestBody User user) throws Exception {
		
		Role role1=new Role();
		role1.setRoleId(45L);
		role1.setRoleName("NORMAL");
		
		List<UserRole> userRoles=new ArrayList<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoles.add(userRole);
		
		return userService.createUser(user, userRoles);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) throws Exception {
		return userService.getUser(username);
	}
}
