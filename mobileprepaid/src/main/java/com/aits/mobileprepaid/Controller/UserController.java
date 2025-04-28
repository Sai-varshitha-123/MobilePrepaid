package com.aits.mobileprepaid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aits.mobileprepaid.Service.Userservice;
import com.aits.mobileprepaid.entity.User;

@RestController
public class UserController {
	@Autowired
	private Userservice userService;
	
	@PostMapping("/users")
	public User insert(@RequestBody User user) {
		return userService.insert(user);
	}
	
	@GetMapping("/users")
	public List<User> fetchAllUsers(){
		return userService.fetchAll();
	}
	
}
