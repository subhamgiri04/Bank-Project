package com.loan.subham.services;

import com.loan.subham.entities.loanApplication;

import java.util.*;

import com.loan.subham.payloads.loanAppDTO;

public interface loanApplicationService {
	
	//create new loan Application.
	loanAppDTO createLoanApp(loanAppDTO loanAppDto);
	
	//get list of loanApp based on date.
	List<loanAppDTO> getLoanAppOnDate(String date);
	
	
	//view loanApp on the basis of loanAppId.
	loanAppDTO viewLoanAppDTO(String loanAppId);
	
	
	//update loanApp.
	void updateLoanApp(loanAppDTO loanAppDto);

}
