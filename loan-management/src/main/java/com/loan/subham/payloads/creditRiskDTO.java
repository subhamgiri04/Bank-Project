package com.loan.subham.payloads;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.loan.subham.entities.loanApplication;

public class creditRiskDTO {
	
	private String crId;
	private loanAppDTO LoanAppDto;
	private int creditScore;
	private int emi;
	private String basicCheck;
	

	
	//getter and setters....
	public String getCrId() {
		return crId;
	}

	public void setCrId(String crId) {
		this.crId = crId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public String getBasicCheck() {
		return basicCheck;
	}

	public void setBasicCheck(String basicCheck) {
		this.basicCheck = basicCheck;
	}

	public loanAppDTO getLoanApplicationDto() {
		return LoanAppDto;
	}

	public void setLoanApplicationDto(loanAppDTO loanAppDto) {
		this.LoanAppDto = loanAppDto;
	}

}
