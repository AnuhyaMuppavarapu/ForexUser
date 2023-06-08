package com.sprint.bankdetails;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sprint.bankdetails.controller.UserBankDetailsController;
import com.sprint.bankdetails.dto.UserBankDetailsDto;
import com.sprint.bankdetails.entity.UserBankDetails;
import com.sprint.bankdetails.entity.Users;
import com.sprint.bankdetails.exceptions.AdminAuthenticationFailureException;
import com.sprint.bankdetails.exceptions.AdminEmailNotExisting;
import com.sprint.bankdetails.exceptions.AdminNotFoundException;
import com.sprint.bankdetails.exceptions.EmailNotExistingException;
import com.sprint.bankdetails.exceptions.ExchangeRateNotFoundException;
import com.sprint.bankdetails.exceptions.InvalidAccountException;
import com.sprint.bankdetails.exceptions.TransactionNotFoundException;
import com.sprint.bankdetails.exceptions.UserBankDetailsNotFoundException;
import com.sprint.bankdetails.exceptions.UsersEmailNotExistingException;
import com.sprint.bankdetails.exceptions.UsersNotFoundException;
import com.sprint.bankdetails.repository.IUserBankDetailsRepository;
import com.sprint.bankdetails.service.IUserBankDetailsService;
import com.sprint.bankdetails.service.IUserBankDetailsServiceImpl;

//import com.sprint.forex.dto.ExceptionDTO;
//import com.sprint.forex.dto.UserBankDetailsDto;
//import com.sprint.forex.entity.UserBankDetails;
//import com.sprint.forex.entity.Users;
//import com.sprint.forex.exception.AdminAuthenticationFailureException;
//import com.sprint.forex.exception.AdminEmailNotExisting;
//import com.sprint.forex.exception.AdminNotFoundException;
//import com.sprint.forex.exception.EmailNotExistingException;
//import com.sprint.forex.exception.ExchangeRateNotFoundException;
//import com.sprint.forex.exception.GlobalExceptionHandler;
//import com.sprint.forex.exception.InvalidAccountException;
//import com.sprint.forex.exception.TransactionNotFoundException;
//import com.sprint.forex.exception.UserBankDetailsNotFoundException;
//import com.sprint.forex.exception.UsersEmailNotExistingException;
//import com.sprint.forex.exception.UsersNotFoundException;
//import com.sprint.forex.repository.IUserBankDetailsRepository;
//import com.sprint.forex.repository.UsersRepository;
//import com.sprint.forex.service.IUserBankDetailsServiceImpl;

@SpringBootTest
 class UserBankDetailsTest
{
 
	@InjectMocks
	public IUserBankDetailsServiceImpl userBankDetails;
	
	@Mock
	private IUserBankDetailsRepository iUserBankDetailsRepository;
	
	
	@Test
  void TestGetSaveuserBankDetailsException()
	{
		
		
		when(iUserBankDetailsRepository.findAll()).thenThrow(UserBankDetailsNotFoundException.class);
		assertThrows(UserBankDetailsNotFoundException.class,()->userBankDetails.getAllBankDetails());
		
	}
	
	
//	    @Test
//	     void testSaveBankDetails() {
//	        // add user details
//	        int userId = 1;
//	        Users user = new Users();
//	        user.setUsersId(userId);
//	        UserBankDetailsDto bankDto = new UserBankDetailsDto();
//	        bankDto.setUserId(userId);
//	        bankDto.setAccountHolderName("Anuhya Muppavarapu");
//	        bankDto.setBankName("HDFC");
//	        bankDto.setAccountNumber((long) 1234567890);
//	        bankDto.setIfscCode("HDFC1234");
//	        bankDto.setContactNumber("1234567890");
//	        Mockito.when(usersRepository.findById(userId)).thenReturn(Optional.of(user));
//	        UserBankDetails savedBankDetails = new UserBankDetails();
//	        savedBankDetails.setId(1);
//	        savedBankDetails.setAccountHolderName("Anuhya Muppavarapu");
//	        savedBankDetails.setBankName("HDFC");
//	        savedBankDetails.setAccountNumber(1234567890);
//	        savedBankDetails.setIfscCode("HDFC1234");
//	        savedBankDetails.setContactNumber("1234567890");
//	        savedBankDetails.setUser(user);
//	        Mockito.when(iUserBankDetailsRepository.save(Mockito.any(UserBankDetails.class))).thenReturn(savedBankDetails);
//	    }
	
	    @Test
         void testUsersNotFoundExceptionIsException() {
            UsersNotFoundException exception = new UsersNotFoundException(null);
            assertTrue(exception instanceof Exception);
        }
	    @Test
         void testUsersNotFoundExceptionIsThrowable() {
            UsersNotFoundException exception = new UsersNotFoundException(null);
            assertTrue(exception instanceof Throwable);
        }
	    @Test
        void testUsersNotFoundExceptionIsRuntimeException() {
            UsersNotFoundException exception = new UsersNotFoundException(null);
            assertTrue(exception instanceof RuntimeException);
        }
	    @Test
         void testUsersNotFoundExceptionWithDifferentMessages() {
            String errorMessage1 = "Invalid user ID";
            String errorMessage2 = "User not found in the database";
            UsersNotFoundException exception1 = new UsersNotFoundException(errorMessage1);
            UsersNotFoundException exception2 = new UsersNotFoundException(errorMessage2);
            assertEquals(errorMessage1, exception1.getMessage());
            assertEquals(errorMessage2, exception2.getMessage());
        }



        @Test
         void testUsersNotFoundExceptionWithoutMessage() {
            UsersNotFoundException exception = new UsersNotFoundException(null);
            assertNull(exception.getMessage());
        }
        @Test
         void testUsersEmailNotExistingExceptionIsThrowable() {
            UsersEmailNotExistingException exception = new UsersEmailNotExistingException(null);
            assertTrue(exception instanceof Throwable);
        }

            @Test
             void testUsersNotFoundExceptionWithMessage() {
                String errorMessage = "Users not found";
                UsersNotFoundException exception = new UsersNotFoundException(errorMessage);
                assertEquals(errorMessage, exception.getMessage());
            }
            @Test
             void testUsersEmailNotExistingExceptionIsRuntimeException() {
                UsersEmailNotExistingException exception = new UsersEmailNotExistingException(null);
                assertTrue(exception instanceof RuntimeException);
            }



            @Test
             void testUsersEmailNotExistingExceptionIsException() {
                UsersEmailNotExistingException exception = new UsersEmailNotExistingException(null);
                assertTrue(exception instanceof Exception);
            }
            @Test
             void testUsersEmailNotExistingExceptionWithDifferentMessages() {
                String errorMessage1 = "Invalid email format";
                String errorMessage2 = "Email does not belong to any user";
                UsersEmailNotExistingException exception1 = new UsersEmailNotExistingException(errorMessage1);
                UsersEmailNotExistingException exception2 = new UsersEmailNotExistingException(errorMessage2);
                assertEquals(errorMessage1, exception1.getMessage());
                assertEquals(errorMessage2, exception2.getMessage());
            }



            @Test
             void testUsersEmailNotExistingExceptionWithoutMessage() {
                UsersEmailNotExistingException exception = new UsersEmailNotExistingException(null);
                assertNull(exception.getMessage());
            }



            @Test
             void testUsersEmailNotExistingExceptionIsRuntimeException1() {
                UsersEmailNotExistingException exception = new UsersEmailNotExistingException(null);
                assertTrue(exception instanceof RuntimeException);
            }
            @Test
            void testUserBankDetailsNotFoundExceptionIsThrowable() {
                UserBankDetailsNotFoundException exception = new UserBankDetailsNotFoundException(null);
                assertTrue(exception instanceof Throwable);
            }



                @Test
                 void testUsersEmailNotExistingExceptionWithMessage() {
                    String errorMessage = "User email not existing";
                    UsersEmailNotExistingException exception = new UsersEmailNotExistingException(errorMessage);
                    assertEquals(errorMessage, exception.getMessage());
                }
                @Test
                 void testUserBankDetailsNotFoundExceptionWithDifferentMessages() {
                    String errorMessage1 = "Invalid user ID";
                    String errorMessage2 = "Bank details not available";
                    UserBankDetailsNotFoundException exception1 = new UserBankDetailsNotFoundException(errorMessage1);
                    UserBankDetailsNotFoundException exception2 = new UserBankDetailsNotFoundException(errorMessage2);
                    assertEquals(errorMessage1, exception1.getMessage());
                    assertEquals(errorMessage2, exception2.getMessage());
                }



                @Test
                 void testUserBankDetailsNotFoundExceptionWithoutMessage() {
                    UserBankDetailsNotFoundException exception = new UserBankDetailsNotFoundException(null);
                    assertNull(exception.getMessage());
                }



                @Test
                 void testUserBankDetailsNotFoundExceptionIsRuntimeException() {
                    UserBankDetailsNotFoundException exception = new UserBankDetailsNotFoundException(null);
                    assertTrue(exception instanceof RuntimeException);
                }



                @Test
                 void testUserBankDetailsNotFoundExceptionIsException() {
                    UserBankDetailsNotFoundException exception = new UserBankDetailsNotFoundException(null);
                    assertTrue(exception instanceof Exception);
                }
                @Test
                 void testTransactionNotFoundExceptionIsThrowable() {
                    TransactionNotFoundException exception = new TransactionNotFoundException(null);
                    assertTrue(exception instanceof Throwable);
                }

                @Test
                 void testUserBankDetailsNotFoundExceptionWithMessage() {
                    String errorMessage = "User bank details not found";
                    UserBankDetailsNotFoundException exception = new UserBankDetailsNotFoundException(errorMessage);
                    assertEquals(errorMessage, exception.getMessage());
                    }
                @Test
                 void testTransactionNotFoundExceptionWithDifferentMessages() {
                    String errorMessage1 = "Invalid transaction ID";
                    String errorMessage2 = "Transaction expired";
                    TransactionNotFoundException exception1 = new TransactionNotFoundException(errorMessage1);
                    TransactionNotFoundException exception2 = new TransactionNotFoundException(errorMessage2);
                    assertEquals(errorMessage1, exception1.getMessage());
                    assertEquals(errorMessage2, exception2.getMessage());
                }



                @Test
                 void testTransactionNotFoundExceptionWithoutMessage() {
                    TransactionNotFoundException exception = new TransactionNotFoundException(null);
                    assertNull(exception.getMessage());
                }
                @Test
                 void testTransactionNotFoundExceptionIsRuntimeException() {
                    TransactionNotFoundException exception = new TransactionNotFoundException(null);
                    assertTrue(exception instanceof RuntimeException);
                }
                @Test
                 void testTransactionNotFoundExceptionIsException() {
                    TransactionNotFoundException exception = new TransactionNotFoundException(null);
                    assertTrue(exception instanceof Exception);
                }
                @Test
                 void testInvalidAccountExceptionIsException() {
                    InvalidAccountException exception = new InvalidAccountException(null);
                    assertTrue(exception instanceof Exception);
                }



                @Test
                 void testInvalidAccountExceptionIsThrowable() {
                    InvalidAccountException exception = new InvalidAccountException(null);
                    assertTrue(exception instanceof Throwable);
                }

                @Test
                 void testTransactionNotFoundExceptionWithMessage() {
                     String errorMessage = "Transaction not found";
                     TransactionNotFoundException exception = new TransactionNotFoundException(errorMessage);
                     assertEquals(errorMessage, exception.getMessage());
                    }
                @Test
                 void testInvalidAccountExceptionWithoutMessage() {
                    InvalidAccountException exception = new InvalidAccountException(null);
                    assertNull(exception.getMessage());
                }
                @Test
                 void testInvalidAccountExceptionIsRuntimeException() {
                    InvalidAccountException exception = new InvalidAccountException(null);
                    assertTrue(exception instanceof RuntimeException);
                }
                @Test
                 void testInvalidAccountExceptionWithDifferentMessages() {
                    String errorMessage1 = "Account not found";
                    String errorMessage2 = "Invalid account type";
                    InvalidAccountException exception1 = new InvalidAccountException(errorMessage1);
                    InvalidAccountException exception2 = new InvalidAccountException(errorMessage2);
                    assertEquals(errorMessage1, exception1.getMessage());
                    assertEquals(errorMessage2, exception2.getMessage());
                }
                @Test
                 void testExchangeRateNotFoundExceptionIsThrowable() {
                    ExchangeRateNotFoundException exception = new ExchangeRateNotFoundException(null);
                    assertTrue(exception instanceof Throwable);
                }
                @Test
                 void testInvalidAccountExceptionWithMessage() {
                    String errorMessage = "Invalid account";
                    InvalidAccountException exception = new InvalidAccountException(errorMessage);
                    assertEquals(errorMessage, exception.getMessage());
                    }

                @Test
                 void testExchangeRateNotFoundExceptionWithoutMessage() {
                    ExchangeRateNotFoundException exception = new ExchangeRateNotFoundException(null);
                    assertNull(exception.getMessage());
                }



                @Test
                 void testExchangeRateNotFoundExceptionIsRuntimeException() {
                    ExchangeRateNotFoundException exception = new ExchangeRateNotFoundException(null);
                    assertTrue(exception instanceof RuntimeException);
                }



                @Test
                 void testExchangeRateNotFoundExceptionIsException() {
                    ExchangeRateNotFoundException exception = new ExchangeRateNotFoundException(null);
                    assertTrue(exception instanceof Exception);
                }
                @Test
                 void testExchangeRateNotFoundExceptionWithDifferentMessages() {
                   String errorMessage1 = "Exchange rate not found for currency pair A/B";
                   String errorMessage2 = "Exchange rate not found for currency pair X/Y";
                   ExchangeRateNotFoundException exception1 = new ExchangeRateNotFoundException(errorMessage1);
                   ExchangeRateNotFoundException exception2 = new ExchangeRateNotFoundException(errorMessage2);
                   assertEquals(errorMessage1, exception1.getMessage());
                   assertEquals(errorMessage2, exception2.getMessage());
                }
                @Test
                 void testAdminNotFoundExceptionWithMessage() {
                    String errorMessage = "Admin not found";
                    AdminNotFoundException exception = new AdminNotFoundException(errorMessage);
                    assertEquals(errorMessage, exception.getMessage());
                }

     

                @Test
                 void testAdminNotFoundExceptionWithDifferentMessages() {
                    String errorMessage1 = "Admin not found";
                    String errorMessage2 = "Invalid admin ID";
                    AdminNotFoundException exception1 = new AdminNotFoundException(errorMessage1);
                    AdminNotFoundException exception2 = new AdminNotFoundException(errorMessage2);
                    assertEquals(errorMessage1, exception1.getMessage());
                    assertEquals(errorMessage2, exception2.getMessage());
                }

     

                @Test
                void testAdminNotFoundExceptionWithoutMessage() {
                    AdminNotFoundException exception = new AdminNotFoundException(null);
                    assertNull(exception.getMessage());
                }

     

                @Test
                 void testAdminNotFoundExceptionIsRuntimeException() {
                    AdminNotFoundException exception = new AdminNotFoundException(null);
                    assertTrue(exception instanceof RuntimeException);
                }

     

                @Test
                 void testAdminNotFoundExceptionIsException() {
                    AdminNotFoundException exception = new AdminNotFoundException(null);
                    assertTrue(exception instanceof Exception);
                }

     

                @Test
                 void testAdminNotFoundExceptionIsThrowable() {
                    AdminNotFoundException exception = new AdminNotFoundException(null);
                    assertTrue(exception instanceof Throwable);
                }
                    @Test
                     void testEmailNotExistingExceptionWithMessage() {
                        String errorMessage = "Email does not exist";
                        EmailNotExistingException exception = new EmailNotExistingException(errorMessage);
                        assertEquals(errorMessage, exception.getMessage());
                    }

                    @Test
                     void testEmailNotExistingExceptionWithDifferentMessages() {
                        String errorMessage1 = "Email does not exist";
                        String errorMessage2 = "Invalid email format";
                        EmailNotExistingException exception1 = new EmailNotExistingException(errorMessage1);
                        EmailNotExistingException exception2 = new EmailNotExistingException(errorMessage2);
                        assertEquals(errorMessage1, exception1.getMessage());
                        assertEquals(errorMessage2, exception2.getMessage());
                    }
                    @Test
                     void testEmailNotExistingExceptionWithoutMessage() {
                        EmailNotExistingException exception = new EmailNotExistingException(null);
                        assertNull(exception.getMessage());
                    }

     

                    @Test
                    void testEmailNotExistingExceptionIsRuntimeException() {
                        EmailNotExistingException exception = new EmailNotExistingException(null);
                        assertTrue(exception instanceof RuntimeException);
                    }

     

                    @Test
                     void testEmailNotExistingExceptionIsException() {
                        EmailNotExistingException exception = new EmailNotExistingException(null);
                        assertTrue(exception instanceof Exception);
                    }

     

                    @Test
                     void testEmailNotExistingExceptionIsThrowable() {
                        EmailNotExistingException exception = new EmailNotExistingException(null);
                        assertTrue(exception instanceof Throwable);
                    }
                        @Test
                         void testExchangeRateNotFoundExceptionWithMessage() {
                            String errorMessage = "Exchange rate not found";
                            ExchangeRateNotFoundException exception = new ExchangeRateNotFoundException(errorMessage);
                            assertEquals(errorMessage, exception.getMessage());
                        }
                        @Test
                         void testAdminAuthenticationFailureExceptionWithMessage() {
                            String errorMessage = "Admin authentication failed";
                            AdminAuthenticationFailureException exception = new AdminAuthenticationFailureException(errorMessage);
                            assertEquals(errorMessage, exception.getMessage());
                        }

                     

                        @Test
                         void testAdminAuthenticationFailureExceptionWithDifferentMessages() {
                            String errorMessage1 = "Admin authentication failed";
                            String errorMessage2 = "Invalid admin credentials";
                            AdminAuthenticationFailureException exception1 = new AdminAuthenticationFailureException(errorMessage1);
                            AdminAuthenticationFailureException exception2 = new AdminAuthenticationFailureException(errorMessage2);
                            assertEquals(errorMessage1, exception1.getMessage());
                            assertEquals(errorMessage2, exception2.getMessage());
                        }

                     

                        @Test
                         void testAdminAuthenticationFailureExceptionWithoutMessage() {
                            AdminAuthenticationFailureException exception = new AdminAuthenticationFailureException(null);
                            assertNull(exception.getMessage());
                        }

                     

                        @Test
                        void testAdminAuthenticationFailureExceptionIsRuntimeException() {
                            AdminAuthenticationFailureException exception = new AdminAuthenticationFailureException(null);
                            assertTrue(exception instanceof RuntimeException);
                        }

                     

                        @Test
                         void testAdminAuthenticationFailureExceptionIsException() {
                            AdminAuthenticationFailureException exception = new AdminAuthenticationFailureException(null);
                            assertTrue(exception instanceof Exception);
                        }

                     

                        @Test
                         void testAdminAuthenticationFailureExceptionIsThrowable() {
                            AdminAuthenticationFailureException exception = new AdminAuthenticationFailureException(null);
                            assertTrue(exception instanceof Throwable);
                        }

                            @Test
                             void testAdminEmailNotExistingWithMessage() {
                                String errorMessage = "Admin email does not exist";
                                AdminEmailNotExisting exception = new AdminEmailNotExisting(errorMessage);
                                assertEquals(errorMessage, exception.getMessage());
                            }

                     

                            @Test
                             void testAdminEmailNotExistingWithDifferentMessages() {
                                String errorMessage1 = "Admin email does not exist";
                                String errorMessage2 = "Invalid admin email";
                                AdminEmailNotExisting exception1 = new AdminEmailNotExisting(errorMessage1);
                                AdminEmailNotExisting exception2 = new AdminEmailNotExisting(errorMessage2);
                                assertEquals(errorMessage1, exception1.getMessage());
                                assertEquals(errorMessage2, exception2.getMessage());
                            }

                     

                            @Test
                             void testAdminEmailNotExistingWithoutMessage() {
                                AdminEmailNotExisting exception = new AdminEmailNotExisting(null);
                                assertNull(exception.getMessage());
                            }

                     

                            @Test
                             void testAdminEmailNotExistingIsRuntimeException() {
                                AdminEmailNotExisting exception = new AdminEmailNotExisting(null);
                                assertTrue(exception instanceof RuntimeException);
                            }

                     

                            @Test
                             void testAdminEmailNotExistingIsException() {
                                AdminEmailNotExisting exception = new AdminEmailNotExisting(null);
                                assertTrue(exception instanceof Exception);
                            }

                     

                            @Test
                             void testAdminEmailNotExistingIsThrowable() {
                                AdminEmailNotExisting exception = new AdminEmailNotExisting(null);
                                assertTrue(exception instanceof Throwable);

        
}
}
