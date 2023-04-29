package com.example.demo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo02.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}