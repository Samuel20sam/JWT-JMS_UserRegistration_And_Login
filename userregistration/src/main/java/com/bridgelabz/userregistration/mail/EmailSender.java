package com.bridgelabz.userregistration.mail;

public interface EmailSender {
    void registrationNotification(String fN, String lN, String emailId);
    void loginNotification(String fN, String lN, String emailId);
}
