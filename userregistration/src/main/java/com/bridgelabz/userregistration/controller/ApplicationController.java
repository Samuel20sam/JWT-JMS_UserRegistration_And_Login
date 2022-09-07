package com.bridgelabz.userregistration.controller;

import com.bridgelabz.userregistration.dto.ResponseDTO;
import com.bridgelabz.userregistration.dto.LoginDTO;
import com.bridgelabz.userregistration.dto.RegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationData;
import com.bridgelabz.userregistration.services.UserRegistrationServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/welcome")
@Slf4j
public class ApplicationController {
    @Autowired
    UserRegistrationServiceImplementation userRegistrationServiceImplementation;


    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody RegistrationDTO userDTO) {
        UserRegistrationData userData = userRegistrationServiceImplementation.registerUser(userDTO);
        log.info("Inside registerUser Controller Method");
        ResponseDTO responseDTO = new ResponseDTO("User Added Successfully and notification " +
                "has been sent to the registered mail address.", userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDTO userLoginDTO) {
        log.info("inside userLogin Controller Method");
        ResponseDTO responseDTO = new ResponseDTO("LoginSuccess",
                userRegistrationServiceImplementation.loginUser(userLoginDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<ResponseDTO> getUserInfo() {
        List<UserRegistrationData> userDataList = userRegistrationServiceImplementation.getUserInfo();
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info ", userDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}