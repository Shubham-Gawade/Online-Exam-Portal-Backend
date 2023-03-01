package com.onlineexamportal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.onlineexamportal.entity.Role;
import com.onlineexamportal.entity.User;
import com.onlineexamportal.entity.UserRole;
import com.onlineexamportal.services.UserService;
import com.onlineexamportal.services.impl.UserServiceImpl;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EntityScan("com.onlineexamportal.entity")
@EnableJpaRepositories("com.onlineexamportal.repositories")
public class OnlineExamPortalBackendApplication implements CommandLineRunner{

	@Autowired
	private UserServiceImpl userService;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamPortalBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Starting code");
		
		User user = new User();
		user.setFistname("Shubham");
		user.setLastname("Gawade");
		user.setUsername("shubham123");
		user.setPassword("12345678");
		user.setEmail("abc@gmail.com");
		user.setPhone("9545506694");
		
		Role role1=new Role();
		role1.setRoleId(123);
		role1.setRoleName("ADMIN");
		
		List<UserRole> userRoles=new ArrayList<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoles.add(userRole);
		
		User addedUser=userService.createUser(user, userRoles);
		System.out.println(addedUser.getFistname());
		
	}

}
