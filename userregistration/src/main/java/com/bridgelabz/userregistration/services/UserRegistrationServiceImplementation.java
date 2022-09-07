package com.bridgelabz.userregistration.services;

import com.bridgelabz.userregistration.dto.LoginDTO;
import com.bridgelabz.userregistration.dto.RegistrationDTO;
import com.bridgelabz.userregistration.mail.EmailSender;
import com.bridgelabz.userregistration.model.UserRegistrationData;
import com.bridgelabz.userregistration.repository.UserRegistrationRepository;
import com.bridgelabz.userregistration.utility.TokenUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserRegistrationServiceImplementation implements UserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private TokenUtility tokenUtility;
    @Autowired
    private final EmailSender emailSender;

    @Override
    public UserRegistrationData registerUser(RegistrationDTO registrationDTO) {
        String encodedPassword = bCryptPasswordEncoder.encode(registrationDTO.getPassword());
        registrationDTO.setPassword(encodedPassword);
        log.info("registerUser Service Method Successfully executed");
        UserRegistrationData userRegistrationData = new UserRegistrationData(registrationDTO);
        userRegistrationRepository.save(userRegistrationData);
        emailSender.registrationNotification(registrationDTO.getFirstName(),
                registrationDTO.getLastName(), registrationDTO.getEmailId());
        return userRegistrationData;
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        UserRegistrationData userRegistrationData = new UserRegistrationData(loginDTO);
        String token = tokenUtility.createToken(userRegistrationData.getUserId());
        log.info("LoginUser Service Method Successfully executed");
        emailSender.loginNotification(userRegistrationData.getFirstName(),
                userRegistrationData.getLastName(), userRegistrationData.getEmailId());
        return "Login Success, Your token is\n" + token;
    }

    @Override
    public List<UserRegistrationData> getUserInfo() {
        log.info("getUserInfo Service Method Successfully executed");
        return userRegistrationRepository.findAll();
    }
}