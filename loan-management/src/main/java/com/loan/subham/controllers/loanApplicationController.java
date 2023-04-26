package com.loan.subham.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.subham.payloads.loanAppDTO;
import com.loan.subham.services.loanApplicationService;

@RestController
@RequestMapping("/api/loanapps")
public class loanApplicationController {
	
	@Autowired
	private loanApplicationService loanAppService;
	
	@PostMapping("new/")
	public ResponseEntity<loanAppDTO> createLoanApp(@RequestBody loanAppDTO loanAppDto){
		loanAppDTO loanApp = this.loanAppService.createLoanApp(loanAppDto);
		return new ResponseEntity<>(loanApp, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/")
	public void updateLoanApp(@RequestBody loanAppDTO loanAppDto) {
		this.loanAppService.updateLoanApp(loanAppDto);
	}
	
	@GetMapping("/pull/{date}")
	public ResponseEntity<List<loanAppDTO>> getLoanAppOnDate(@PathVariable("date") String date){
		return ResponseEntity.ok(this.loanAppService.getLoanAppOnDate(date));
	}
	
	@PostMapping("/view/{loanAppId}")
	public ResponseEntity<loanAppDTO> viewLoanAppDTO(@PathVariable("loanAppId") String loanAppId){
		return ResponseEntity.ok(this.loanAppService.viewLoanAppDTO(loanAppId));
	}
	

}
