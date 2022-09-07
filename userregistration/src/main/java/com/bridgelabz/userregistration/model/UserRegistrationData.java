package com.bridgelabz.userregistration.model;

import com.bridgelabz.userregistration.dto.LoginDTO;
import com.bridgelabz.userregistration.dto.RegistrationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Registration_Details")
@NoArgsConstructor
public class UserRegistrationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private int userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;

    public UserRegistrationData(RegistrationDTO registrationDTO) {
        this.firstName = registrationDTO.firstName;
        this.lastName = registrationDTO.lastName;
        this.emailId = registrationDTO.emailId;
        this.password = registrationDTO.password;
    }

    public UserRegistrationData(LoginDTO userLoginDTO) {
        this.emailId = userLoginDTO.emailId;
        this.password = userLoginDTO.password;
    }
}