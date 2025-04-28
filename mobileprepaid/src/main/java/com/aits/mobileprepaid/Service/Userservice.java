package com.aits.mobileprepaid.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.mobileprepaid.entity.User;
import com.aits.mobileprepaid.repository.UserRepo;

@Service
public class Userservice {
@Autowired
UserRepo repo;
public User insert(User user) {
	return repo.save(user);
}
public List<User> fetchAll(){
	return repo.findAll();
}

}
