package com.aits.mobileprepaid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.mobileprepaid.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
   Optional<User>findByMobile(String mobile);
   Optional<User>findByEmail(String Email);
}
