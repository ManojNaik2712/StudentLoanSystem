package com.studentloansystem.Controller;

import com.studentloansystem.Models.User;
import com.studentloansystem.Repo.UserRepo;
import com.studentloansystem.Service.LoanService;
import com.studentloansystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoanController {
    @Autowired
    LoanService loanService;

    @PostMapping("/applyloan")
    public String getLoan(Authentication authentication){
        String email= authentication.getName();
        return loanService.processLoan(email);
    }

}
