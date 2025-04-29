package com.studentloansystem.Controller;

import com.studentloansystem.DTO.LoginRequest;
import com.studentloansystem.Models.User;
import com.studentloansystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Usercontroller {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user){
         return userService.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }


    @GetMapping("/getuser")
    public User getUser(@RequestParam Long id){
        return userService.getUser(id);
    }




}
