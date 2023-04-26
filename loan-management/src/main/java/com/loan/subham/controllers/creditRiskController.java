package com.loan.subham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.subham.payloads.creditRiskDTO;
import com.loan.subham.payloads.loanAppDTO;
import com.loan.subham.services.creditRiskService;
import com.loan.subham.services.loanApplicationService;

@RestController
@RequestMapping("/api/creditRisk")
public class creditRiskController {
	
	@Autowired
	private creditRiskService creditRiskService;
	
	@PostMapping("new/{loanAppId}")
	public ResponseEntity<creditRiskDTO> createCreditRisk(@RequestBody creditRiskDTO creditRiskDto,@PathVariable("loanAppId") String loanAppId){
		creditRiskDTO creditRisk = this.creditRiskService.createCreditRisk(creditRiskDto, loanAppId);
		return new ResponseEntity<>(creditRisk, HttpStatus.CREATED);
	}

}
