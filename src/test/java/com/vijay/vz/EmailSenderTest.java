package com.vijay.vz;

import com.vijay.vz.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailService emailService;
   @Test
    public void emailSendTest(){
       System.out.println("Sending email...");
       emailService.sendEmail("kumar.vijay@publicissapient.com","This is from email sender app","Happy codding");
    }

    @Test
    public void sendHtmlInEmail(){
        System.out.println("Sending email sendHtmlInEmail...");
        String html="<h1 style='color:red;border:1px solid red;' >Welcome to new world </h1>";
        emailService.sendEmail("kumar.vijay@publicissapient.com","This is from email sender app",html);
    }

    @Test
    public void sendEmailWithFile(){
        System.out.println("Sending email with file...");

        emailService.sendEmailWithFile("abc@gmail.com",
                "Email with file",
                "This email contains file",
                new File("filepath")
                );
    }
}
