package com.loan.subham.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.loan.subham.repositories.creditRiskRepo;
import com.loan.subham.repositories.loanApplicationRepo;
import com.loan.subham.entities.creditRisk;
import com.loan.subham.entities.loanApplication;
import com.loan.subham.payloads.creditRiskDTO;
import com.loan.subham.services.creditRiskService;

@Service
public class creditRiskServiceImpl implements creditRiskService {
	
	@Autowired
	private creditRiskRepo creditRiskRepo;
	@Autowired
	private loanApplicationRepo loanAppRepo;
	@Autowired
	private loanApplicationServiceImpl loanAppServiceImpl;

	@Override
	public creditRiskDTO createCreditRisk(creditRiskDTO creditRiskDto, String loanAppId) {
		// TODO Auto-generated method stub
		creditRisk creditRisk = this.creditRiskDTOToCreditRisk(creditRiskDto);
		loanApplication loanApp = this.loanAppRepo.findById(loanAppId).get();
		creditRisk.setLoanApplication(loanApp);
		this.creditRiskRepo.save(creditRisk);
		
		creditRiskDto.setLoanApplicationDto(this.loanAppServiceImpl.LoanApplicationToloanAppDto(loanApp));
		return creditRiskDto;
	}
	
	
	//converter functions ....
	public creditRiskDTO creditRiskToCreditRiskDTO(creditRisk creditRisk) {
		creditRiskDTO creditRiskDto = new creditRiskDTO();
		creditRiskDto.setBasicCheck(creditRisk.getBasicCheck());
		creditRiskDto.setCreditScore(creditRisk.getCreditScore());
		creditRiskDto.setEmi(creditRisk.getEmi());
		creditRiskDto.setCrId(creditRisk.getCrId());
		//creditRiskDto.setLoanApplicationDto(this.loanAppServiceImpl.LoanApplicationToloanAppDto(creditRisk.getLoanApplication()));
		return creditRiskDto;
	}
	
	public creditRisk creditRiskDTOToCreditRisk(creditRiskDTO creditRiskDto) {
		creditRisk creditRisk = new creditRisk();
		creditRisk.setBasicCheck(creditRiskDto.getBasicCheck());
		creditRisk.setCreditScore(creditRiskDto.getCreditScore());
		creditRisk.setEmi(creditRiskDto.getEmi());
		//creditRisk.setLoanApplication(this.loanAppServiceImpl.loanAppDtoToLoanApplication(creditRiskDto.getLoanApplicationDto()));	
		return creditRisk;
	}

}
