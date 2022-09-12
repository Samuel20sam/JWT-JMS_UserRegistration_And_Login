package com.bridgelabz.userregistration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
public class UserRegistrationApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserRegistrationApplication.class, args);

        log.info("User Registration App started");

        System.out.println("\n\n < ------ Welcome To User Registration Project ------ >\n\n");
    }
}