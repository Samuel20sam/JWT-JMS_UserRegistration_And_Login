package com.bridgelabz.userregistration.services;

import com.bridgelabz.userregistration.dto.LoginDTO;
import com.bridgelabz.userregistration.dto.RegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationData;

import java.util.List;

public interface UserRegistrationService {
    String loginUser(LoginDTO userLoginDTO);
    List<UserRegistrationData> getUserInfo();
    UserRegistrationData registerUser(RegistrationDTO registrationDTO);
}
