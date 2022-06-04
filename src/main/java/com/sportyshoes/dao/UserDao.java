package com.sportyshoes.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sportyshoes.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	public Optional<User> findByNameAndPassword(String name, String password);
	
	public Optional<User> findByName(String name);

}