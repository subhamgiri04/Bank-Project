package com.loan.subham.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.subham.entities.loanApplication;

public interface loanApplicationRepo extends JpaRepository<loanApplication, String>{
		List<loanApplication> findByLoanAppDate(Date date);
}
