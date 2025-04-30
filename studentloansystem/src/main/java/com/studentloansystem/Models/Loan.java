package com.studentloansystem.Models;

import com.studentloansystem.DTO.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private Double interestRate;
    @Enumerated(value = EnumType.STRING)
    private LoanStatus status;
    @CreationTimestamp
    private Date createdAt;
    private int score;
    @ManyToOne
    @JoinColumn
    private User user;

}
