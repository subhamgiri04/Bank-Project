package com.loan.subham.services.impl;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.subham.entities.loanApplication;
import com.loan.subham.payloads.loanAppDTO;
import com.loan.subham.repositories.loanApplicationRepo;
import com.loan.subham.services.loanApplicationService;
import com.loan.subham.exceptions.ResourceNotFoundException;

@Service
public class loanApplicationServiceImpl implements loanApplicationService {
	
	@Autowired
	private loanApplicationRepo loanAppRepo;
	
	//for creating new request...
	public loanAppDTO createLoanApp(loanAppDTO loanAppDto) {
		loanApplication loanApp = this.loanAppDtoToLoanApplication(loanAppDto);
		this.loanAppRepo.save(loanApp);
		return loanAppDto;
	}
	
	//for getting list of request on the basis of date...
	public List<loanAppDTO> getLoanAppOnDate(String date){
		// TODO Auto-generated method stub
		Date d1 = null;
		try {
			d1 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<loanApplication> loanApps = this.loanAppRepo.findByLoanAppDate(d1);
		List<loanAppDTO> result = new ArrayList<loanAppDTO>();
		for(int i=0;i<loanApps.size();i++) {
			result.add(this.LoanApplicationToloanAppDto(loanApps.get(i)));
		}
		return result;
	}
	
	//for getting request on the basis of Id...
	public loanAppDTO viewLoanAppDTO(String loanAppId) {
		// TODO Auto-generated method stub
		loanApplication loanApp = this.loanAppRepo.findById(loanAppId).get();
		return this.LoanApplicationToloanAppDto(loanApp);
	}

	//for updating the request...
	public void updateLoanApp(loanAppDTO loanAppDto) {
		// TODO Auto-generated method stub
		String loanAppId = loanAppDto.getLoanAppId();
		//Add Exception here.
		loanApplication loanApp = this.loanAppRepo.findById(loanAppId).get();
		
		loanApp.setLoanAppId(loanAppDto.getLoanAppId());
		loanApp.setCustId(loanAppDto.getCustId());
		loanApp.setLoanAmt(loanAppDto.getLoanAmt());
		loanApp.setNoOfYears(loanAppDto.getNoOfYears());
		loanApp.setPurpose(loanAppDto.getPurpose());
		loanApp.setAppStatus(loanAppDto.getAppStatus());
		loanApp.setTypeOfLoan(loanAppDto.getTypeOfLoan());
		//loanApp.setLoanAppDate(loanAppDto.getLoanAppDate());
		loanApp.setStatus(loanAppDto.getStatus());
		
		this.loanAppRepo.delete(loanApp);
		this.loanAppRepo.save(loanApp);
	}
	
	
	//loanApplication to loanAppDTO converter and viceversa.
	public loanApplication loanAppDtoToLoanApplication(loanAppDTO loanAppDto) {
		
		loanApplication loanApp = new loanApplication();
		loanApp.setLoanAppId(loanAppDto.getLoanAppId());
		loanApp.setCustId(loanAppDto.getCustId());
		loanApp.setLoanAmt(loanAppDto.getLoanAmt());
		loanApp.setNoOfYears(loanAppDto.getNoOfYears());
		loanApp.setPurpose(loanAppDto.getPurpose());
		loanApp.setAppStatus(loanAppDto.getAppStatus());
		loanApp.setTypeOfLoan(loanAppDto.getTypeOfLoan());
		String str = loanAppDto.getDateString();
		Date date=null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loanApp.setLoanAppDate(date);
		loanApp.setStatus(loanAppDto.getStatus());
		return loanApp;
		
	}
	
	public loanAppDTO LoanApplicationToloanAppDto(loanApplication loanApp) {
		
		loanAppDTO loan = new loanAppDTO();
		loan.setLoanAppId(loanApp.getLoanAppId());
		loan.setCustId(loanApp.getCustId());
		loan.setLoanAmt(loanApp.getLoanAmt());
		loan.setNoOfYears(loanApp.getNoOfYears());
		loan.setPurpose(loanApp.getPurpose());
		loan.setAppStatus(loanApp.getAppStatus());
		loan.setTypeOfLoan(loanApp.getTypeOfLoan());
		
		loan.setStatus(loanApp.getAppStatus());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String str = dateFormat.format(loanApp.getLoanAppDate());  
		loan.setDateString(str);
		return loan;
	}

}
