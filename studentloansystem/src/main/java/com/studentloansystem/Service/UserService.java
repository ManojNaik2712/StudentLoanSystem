package com.studentloansystem.Service;

import com.studentloansystem.Models.User;
import com.studentloansystem.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);

    }
}
