package com.sprint.bankdetails.service;

import com.sprint.bankdetails.dto.UserBankDetailsDto;
import com.sprint.bankdetails.entity.UserBankDetails;
import com.sprint.bankdetails.entity.Users;
import com.sprint.bankdetails.exceptions.UserBankDetailsNotFoundException;
import com.sprint.bankdetails.exceptions.UsersNotFoundException;
import com.sprint.bankdetails.repository.IUserBankDetailsRepository;
import com.sprint.bankdetails.util.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;


@Service
public class IUserBankDetailsServiceImpl implements IUserBankDetailsService {
	@Autowired
	private UserFeignClient userFeignClient;
	@Autowired
	private IUserBankDetailsRepository iUserBankDetailsRepository;

	
	@Autowired
	 private MessageSource messageSource;
	

	@Override
	public List<UserBankDetails> getAllBankDetails() {

		List<UserBankDetails> userBankDetailsList = iUserBankDetailsRepository.findAll();

		if (userBankDetailsList.isEmpty()) {
			throw new UserBankDetailsNotFoundException(messageSource.getMessage("bankDetails.not.found ",null,Locale.US));

		}
		return userBankDetailsList;
	}

	@Override
	public UserBankDetails findByUserId(int userId) {
		return iUserBankDetailsRepository.findByUser_UsersId(userId);
	}

	@Override
	public UserBankDetails findByAccountNumber(long accountNumber) {
		return iUserBankDetailsRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new RuntimeException("Bank details not found"));
	}

	@Override
	public UserBankDetailsDto saveBankDetails(UserBankDetailsDto bankDto) {
		ResponseEntity<Users> optionalUsers = userFeignClient.fetchUsersDetails(bankDto.getUserId());
		
		if (optionalUsers.getStatusCode().is4xxClientError()) {
			throw new UsersNotFoundException(messageSource.getMessage("users.not.found",null,Locale.US)+" "+ bankDto.getUserId());
		}

		Users user = optionalUsers.getBody();
		if(iUserBankDetailsRepository.existsByUser(user)){
			throw new RuntimeException("Bank details already exists");
		}
		
		UserBankDetails obj = new UserBankDetails();

		obj.setAccountHolderName(bankDto.getAccountHolderName());
		obj.setBankName(bankDto.getBankName());

		obj.setContactNumber(bankDto.getContactNumber());

		obj.setIfscCode(bankDto.getIfscCode());
		obj.setAccountNumber(bankDto.getAccountNumber());
		obj.setUser(user);
		UserBankDetails newBankDetails = iUserBankDetailsRepository.save(obj);

		UserBankDetailsDto newDto = new UserBankDetailsDto();

		newDto.setUserBankId(newBankDetails.getId());

		newDto.setAccountHolderName(newBankDetails.getAccountHolderName());

		newDto.setAccountNumber(newBankDetails.getAccountNumber());

		newDto.setBankName(newBankDetails.getBankName());

		newDto.setIfscCode(newBankDetails.getIfscCode());

		newDto.setContactNumber(newBankDetails.getContactNumber());

		newDto.setUserId(newBankDetails.getUser().getUsersId());

		return newDto;
		
	}

	@Override
	public UserBankDetailsDto updateBankDetails(UserBankDetailsDto bankDto) {
		ResponseEntity<Users> optionalUsers = userFeignClient.fetchUsersDetails(bankDto.getUserId());

		if (optionalUsers.getStatusCode().is4xxClientError()) {
			throw new UsersNotFoundException(messageSource.getMessage("users.not.found",null,Locale.US)+" "+ bankDto.getUserId());
		}

		Users user = optionalUsers.getBody();
		if(!iUserBankDetailsRepository.existsByUser(user)){
			throw new UserBankDetailsNotFoundException("Bank details not found");
		}

		UserBankDetails obj = iUserBankDetailsRepository.findByUser_UsersId(user.getUsersId());
		obj.setAccountHolderName(bankDto.getAccountHolderName());
		obj.setBankName(bankDto.getBankName());

		obj.setContactNumber(bankDto.getContactNumber());

		obj.setIfscCode(bankDto.getIfscCode());
		obj.setAccountNumber(bankDto.getAccountNumber());
		obj.setUser(user);
		UserBankDetails newBankDetails = iUserBankDetailsRepository.save(obj);

		UserBankDetailsDto newDto = new UserBankDetailsDto();

		newDto.setUserBankId(newBankDetails.getId());

		newDto.setAccountHolderName(newBankDetails.getAccountHolderName());

		newDto.setAccountNumber(newBankDetails.getAccountNumber());

		newDto.setBankName(newBankDetails.getBankName());

		newDto.setIfscCode(newBankDetails.getIfscCode());

		newDto.setContactNumber(newBankDetails.getContactNumber());

		newDto.setUserId(newBankDetails.getUser().getUsersId());

		return newDto;
	}

}