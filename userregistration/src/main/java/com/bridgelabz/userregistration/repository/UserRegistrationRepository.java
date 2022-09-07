package com.bridgelabz.userregistration.repository;

import com.bridgelabz.userregistration.model.UserRegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationData, Long> {

}

