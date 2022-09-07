package com.bridgelabz.userregistration.mail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor
@Slf4j
public class EmailService implements EmailSender{
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    @Override
    @Async
    public void registrationNotification(String fN, String lN, String emailId) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(emailId);

            helper.setSubject("Your registration is Successful");

            helper.setText("<h2><b>Dear "+fN +" " +lN +",</b></h2>" +
                    "<h3>Your registration is successful, kindly find the document attached for future reference</h3>" +
                    "<br><img src='cid:Greeting'/><br>" +
                    "<h4><b>With Kind Regards,<br>Samuel Elijah</b></h4>", true);

            FileSystemResource inLineResource = new FileSystemResource
                    (new File("S:\\Bridge-labz\\Bridge_labz_JAVA\\PracticeProblems" +
                            "\\CFP\\SpringEmailClient\\Attachments\\Greeting.jpg"));
            helper.addInline("Greeting", inLineResource);

            FileSystemResource attachmentResource = new FileSystemResource
                    (new File("S:\\Bridge-labz\\Bridge_labz_JAVA\\PracticeProblems" +
                            "\\CFP\\SpringEmailClient\\Attachments\\JavaCodingGuidelines.pdf"));
            helper.addAttachment("Attachment.pdf", attachmentResource);

            mailSender.send(mimeMessage);
            log.info("Mail Sent Successfully to : " +emailId);

        } catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

    @Override
    public void loginNotification(String fN, String lN, String emailId) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(emailId);

            helper.setSubject("Your login is Successful");

            helper.setText("<h2><b>Dear "+fN +" " +lN +",</b></h2>" +
                    "<h3>Your login is successful</h3>" +
                    "<p>Check this link to know some fundamental tips about REST Api</p>"+
                    "<br>https://www.linkedin.com/pulse/15-fundamental-tips-rest-api-design-omar-ismail/<br>" +
                    "<h4><b>With Kind Regards,<br>Samuel Elijah</b></h4>", true);

            FileSystemResource attachmentResource = new FileSystemResource
                    (new File("S:\\Bridge-labz\\Bridge_labz_JAVA\\PracticeProblems" +
                            "\\CFP\\SpringEmailClient\\Attachments\\JavaCodingGuidelines.pdf"));
            helper.addAttachment("Attachment.pdf", attachmentResource);

            mailSender.send(mimeMessage);
            log.info("Mail Sent Successfully to : " +emailId);

        } catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}