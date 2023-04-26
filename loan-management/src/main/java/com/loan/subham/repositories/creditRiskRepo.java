package com.loan.subham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.subham.entities.creditRisk;
import com.loan.subham.entities.loanApplication;

public interface creditRiskRepo extends JpaRepository<creditRisk, String>{

}
