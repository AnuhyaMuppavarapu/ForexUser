package com.sprint.bankdetails.dto;



public class UserBankDetailsDto {
	 private int userBankId;
	 private String accountHolderName;
	 private String bankName;
	 private String IfscCode;
	 private Long accountNumber;
	 private String contactNumber;
	 private int userId;
	public int getUserBankId() {
		return userBankId;
	}
	public void setUserBankId(int userBankId) {
		this.userBankId = userBankId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return IfscCode;
	}
	public void setIfscCode(String ifscCode) {
		IfscCode = ifscCode;
	}
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long i) {
		this.accountNumber = i;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	 
	 

}
