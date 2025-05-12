package com.ashucodes.careerverse.controller;
import com.ashucodes.careerverse.entity.Users;
import com.ashucodes.careerverse.entity.UsersType;
import com.ashucodes.careerverse.services.UsersService;
import com.ashucodes.careerverse.services.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private  final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired
    public UserController(UsersTypeService userTypeService, UsersService usersService){
        this.usersTypeService = userTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model){
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user",new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users){
//        System.out.println("User ::  " + users);
        usersService.addNew(users);
        return "dashboard";

    }
}