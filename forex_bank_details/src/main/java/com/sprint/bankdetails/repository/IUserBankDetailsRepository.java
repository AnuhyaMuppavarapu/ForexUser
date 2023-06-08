package com.sprint.bankdetails.repository;

import com.sprint.bankdetails.entity.UserBankDetails;
import com.sprint.bankdetails.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserBankDetailsRepository extends JpaRepository<UserBankDetails,Integer> {
    UserBankDetails findByUser_UsersId(int usersId);
    boolean existsByUser(Users user);
	 Optional<UserBankDetails> findByAccountNumber(long accountNumber);
	 
}

