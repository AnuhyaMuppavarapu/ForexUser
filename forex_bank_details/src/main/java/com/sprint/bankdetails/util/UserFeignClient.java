package com.sprint.bankdetails.util;

import com.sprint.bankdetails.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "users", url = "http://localhost:8082")
public interface UserFeignClient {
    @GetMapping("/user/find/{id}")
     ResponseEntity<Users> fetchUsersDetails(@PathVariable("id") int usersId);
}
