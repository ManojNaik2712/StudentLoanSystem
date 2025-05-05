package com.studentloansystem.Controller;

import com.studentloansystem.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @Autowired
    LoanService loanService;

    @PostMapping("/applyloan")
    public double getLoan(Authentication authentication) {
        String email = authentication.getName();
        return loanService.processLoan(email);
    }

}
