package com.jwt.example.springback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.example.springback.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}