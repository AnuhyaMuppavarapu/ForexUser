package com.sprint.bankdetails.controller;

import com.sprint.bankdetails.dto.CommonDTO;
import com.sprint.bankdetails.dto.UserBankDetailsDto;
import com.sprint.bankdetails.entity.UserBankDetails;
import com.sprint.bankdetails.exceptions.UserBankDetailsNotFoundException;
import com.sprint.bankdetails.service.IUserBankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class UserBankDetailsController {
	
	@Autowired
	private IUserBankDetailsService iUserBankDetails;
	
	
	@PostMapping("/UserBankDetails/save")
	public ResponseEntity<CommonDTO<UserBankDetailsDto>> addBankDetails(@Valid @RequestBody UserBankDetailsDto userBankDetails )
	{
		 UserBankDetailsDto newUserBankDetails = iUserBankDetails.saveBankDetails(userBankDetails);
		return new ResponseEntity<>(new CommonDTO<>("Bank details successfully added",newUserBankDetails), HttpStatus.CREATED);

	}
	@PutMapping("/UserBankDetails/update")
	public ResponseEntity<CommonDTO<UserBankDetailsDto>> updateBankDetails(@Valid @RequestBody UserBankDetailsDto userBankDetails )
	{
		UserBankDetailsDto newUserBankDetails = iUserBankDetails.updateBankDetails(userBankDetails);
		return new ResponseEntity<>(new CommonDTO<>("Bank details updated successfully",newUserBankDetails), HttpStatus.CREATED);

	}
	@GetMapping("/bank-details/{userId}")
	public ResponseEntity<CommonDTO<UserBankDetails>> fetchMyBank(@PathVariable("userId") int userId )
	{
		UserBankDetails newUserBankDetails = iUserBankDetails.findByUserId(userId);
		if(newUserBankDetails == null) throw new UserBankDetailsNotFoundException("Bank details not found");
		return new ResponseEntity<>(new CommonDTO<>("Bank details successfully fetched",newUserBankDetails), HttpStatus.OK);

	}

	@GetMapping("/bankdetails/findByAccount/{accountNumber}")
	public ResponseEntity<UserBankDetails> findByAccountNumber(@PathVariable("accountNumber") long accountNumber )
	{
		return new ResponseEntity<>(iUserBankDetails.findByAccountNumber(accountNumber), HttpStatus.OK);

	}
}	