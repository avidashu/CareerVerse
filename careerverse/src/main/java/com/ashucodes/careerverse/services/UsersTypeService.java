package com.ashucodes.careerverse.services;

import com.ashucodes.careerverse.entity.UsersType;
import com.ashucodes.careerverse.repository.UsersTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {

    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll() {
        return usersTypeRepository.findAll();
    }
}
