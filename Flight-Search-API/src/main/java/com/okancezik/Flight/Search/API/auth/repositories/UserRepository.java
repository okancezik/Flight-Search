package com.okancezik.Flight.Search.API.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okancezik.Flight.Search.API.auth.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
