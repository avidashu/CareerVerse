package com.ashucodes.careerverse.repository;

import com.ashucodes.careerverse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users,Integer>{

    Optional<Users> findByEmail(String email);
}