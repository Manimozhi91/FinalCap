package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Login;

public interface LoginRepository extends JpaRepository<Login, String>{

}