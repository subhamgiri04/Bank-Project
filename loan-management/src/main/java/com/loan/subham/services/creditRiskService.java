package com.loan.subham.services;

import com.loan.subham.payloads.creditRiskDTO;

public interface creditRiskService {
	
	//create new credit Risk field...
	creditRiskDTO createCreditRisk(creditRiskDTO creditRiskDto, String loanAppId);

}
