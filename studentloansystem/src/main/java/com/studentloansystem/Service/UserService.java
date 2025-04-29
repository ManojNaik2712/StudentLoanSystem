package com.studentloansystem.Service;

import com.studentloansystem.Config.JwtUtil;
import com.studentloansystem.DTO.LoginRequest;
import com.studentloansystem.Models.User;
import com.studentloansystem.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    public User save(User user) {
        return userRepo.save(user);

    }

    public User getUser(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with this id" + id));
    }

    public String login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            if (authentication.isAuthenticated()) {
                //It can also work
                //User user=userRepo.findByEmail(loginDTO.getEmail());
                UserDetails user= userRepo.findByEmail(loginRequest.getEmail());
                String token = jwtUtil.generateToken(loginRequest,user.getAuthorities());
                return token;
            } else {
                System.out.println("Authentication failed!");
                return "fail";
            }
        } catch (Exception e) {
            System.out.println("Authentication error: " + e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}
