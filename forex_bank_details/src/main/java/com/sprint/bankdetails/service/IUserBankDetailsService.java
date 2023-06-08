package com.sprint.bankdetails.service;

import com.sprint.bankdetails.dto.UserBankDetailsDto;
import com.sprint.bankdetails.entity.UserBankDetails;

import java.util.List;

public interface IUserBankDetailsService
{
	

	public UserBankDetailsDto saveBankDetails(UserBankDetailsDto bankDto) ;
	public UserBankDetailsDto updateBankDetails(UserBankDetailsDto bankDto) ;

	
	public List<UserBankDetails> getAllBankDetails();

	public UserBankDetails findByUserId(int userId);
	public UserBankDetails findByAccountNumber(long accountNumber);

}