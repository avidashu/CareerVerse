package com.ashucodes.careerverse.services;

import com.ashucodes.careerverse.entity.JobSeekerProfile;
import com.ashucodes.careerverse.entity.RecruiterProfile;
import com.ashucodes.careerverse.entity.Users;
import com.ashucodes.careerverse.repository.JobSeekerProfileRepository;
import com.ashucodes.careerverse.repository.RecruiterProfileRepository;
import com.ashucodes.careerverse.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    @Autowired
    public  UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository){
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();
        if(userTypeId == 1)
        {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        }
        else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }


        return savedUser;

    }

    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);

    }

}
