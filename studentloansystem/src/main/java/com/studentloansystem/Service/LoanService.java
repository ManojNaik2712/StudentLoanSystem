package com.studentloansystem.Service;

import com.studentloansystem.DTO.GithubProfile;
import com.studentloansystem.DTO.LoanStatus;
import com.studentloansystem.Models.Loan;
import com.studentloansystem.Models.User;
import com.studentloansystem.Repo.LoanRepo;
import com.studentloansystem.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    GithubService githubService;

    @Autowired
    LoanRepo loanRepo;

    public String processLoan(String email) {
        User user = (User) userRepo.findByEmail(email);
        String githubUsername = user.getGithubUsername();
        GithubProfile githubProfile = githubService.getProfile(githubUsername);

        int score=calculate(githubProfile);
        double amount=calculateLoan(score);
        double interestRate=calculateInterest(amount);
        Loan loan=Loan.builder()
                .amount(amount)
                .interestRate(interestRate).status(LoanStatus.PENDING)
                .user(user)
                .score(score).build();
        loanRepo.save(loan);
        return "Loan is in process";
    }

    private Double calculateInterest(Double score) {
        return score > 50 ? 5.5 : 8.0;
    }

    private double calculateLoan(int score) {
        return  score*1000;
    }

    private int calculate(GithubProfile githubProfile) {
        return githubProfile.getPublic_repos() + githubProfile.getFollowers()*2;
    }


}
