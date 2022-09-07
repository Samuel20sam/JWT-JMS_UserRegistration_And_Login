package com.bridgelabz.userregistration.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;
@Data
@ToString
public class RegistrationDTO {
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid First Name")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid Last Name")
    public String lastName;
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)" +
            "*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "Invalid Email")
    public String emailId;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}",
            message = "Password should be of minimum 8 character with "+
                    "1 Upper case," +
                    "1 Lower case," +
                    "1 Number and" +
                    "1 Special Character ")
    public String password;
}