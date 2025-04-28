package com.studentloansystem.Controller;

import com.studentloansystem.Models.User;
import com.studentloansystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
         return userService.save(user);
    }


}
