package com.studentloansystem.Service;

import com.studentloansystem.DTO.GithubProfile;
import com.studentloansystem.Enums.LoanStatus;
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

    public double processLoan(String email) {
        User user = (User) userRepo.findByEmail(email);
        Double cgpa = user.getCgpa();
        String githubUsername = user.getGithubUsername();
        GithubProfile githubProfile = githubService.getProfile(githubUsername);

        double score = calculate(githubProfile, cgpa);
        double amount = calculateLoan(score);
        double interestRate = calculateInterest(amount);
        Loan loan = Loan.builder().amount(amount).interestRate(interestRate).status(LoanStatus.PENDING).user(user).status(LoanStatus.APPROVED).score(score).build();
        loanRepo.save(loan);
        return amount;
    }

    private double calculateInterest(Double score) {
        return score > 50 ? 5.5 : 8.0;
    }

    private double calculateLoan(double score) {
        return score * 1000;
    }

    private double calculate(GithubProfile githubProfile, Double cgpa) {
        return githubProfile.getPublic_repos() + githubProfile.getFollowers() * cgpa / 10;
    }

}
