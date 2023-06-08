package com.sprint.bankdetails.exceptions;

public class UserBankDetailsNotFoundException extends RuntimeException {
	
	public UserBankDetailsNotFoundException (String msg)
	{
		super(msg);
	}
}
