package com.loan.subham.payloads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class loanAppDTO {
	
	private String loanAppId;
	private String custId;
	private int loanAmt;
	private int noOfYears;
	private String purpose;
	private String appStatus;
	private String typeOfLoan;
	private String status;
	public String DateString;
	
	public String getLoanAppId() {
		return loanAppId;
	}

	public void setLoanAppId(String loanAppId) {
		this.loanAppId = loanAppId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(int loanAmt) {
		this.loanAmt = loanAmt;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getTypeOfLoan() {
		return typeOfLoan;
	}

	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}

	public String getDateString() {
		return DateString;
	}

	public void setDateString(String DateString) {
		this.DateString = DateString;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
