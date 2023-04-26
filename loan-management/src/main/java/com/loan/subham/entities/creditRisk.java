package com.loan.subham.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class creditRisk {
	
	
	@Id
	private String crId;
	private int creditScore;
	private int emi;
	private String basicCheck;
	
	@OneToOne
	@JoinColumn(name="loanAppId")
	private loanApplication LoanApplication;

	
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

	public loanApplication getLoanApplication() {
		return LoanApplication;
	}

	public void setLoanApplication(loanApplication loanApplication) {
		LoanApplication = loanApplication;
	}
	
	

}
