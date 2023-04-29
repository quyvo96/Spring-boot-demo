package com.example.demo02.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo02.entities.User;

import lombok.NonNull;

public interface UserRepository extends JpaRepository<User, Integer> {

	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = { "authorities" })
	Optional<User> findByUsername(String username);

	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = { "authorities" })
	List<User> findAll();

	@Query("SELECT u FROM User u WHERE u.username = ?#{ principal.username}")
	Optional<User> findLoginUser();

	@Query("SELECT u FROM User u WHERE u.username = ?1")
	Optional<User> getByUsername(@NonNull String username);

}