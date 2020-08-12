package com.ocsc.poc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocsc.poc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// @Query("SELECT p FROM User p WHERE p.emailId =?1")
	Optional<User> findByEmailId(String emailId);

	Optional<User> findByEmailIdAndPassword(String emailId, String password);

}
