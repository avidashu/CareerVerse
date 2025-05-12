package com.ashucodes.careerverse.repository;

import com.ashucodes.careerverse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ashucodes.careerverse.entity.UsersType;
import com.ashucodes.careerverse.repository.UsersRepository;

public interface UsersTypeRepository extends JpaRepository<UsersType,Integer>{

}