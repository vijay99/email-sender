package com.vijay.vz;

import com.vijay.vz.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailService emailService;
   @Test
    public void emailSendTest(){
       System.out.println("Sending email...");
       emailService.sendEmail("aws.vijay28feb@gmail.com","This is from email sender app","Happy codding");
    }

    @Test
    public void sendHtmlInEmailTest(){
        System.out.println("Sending email sendHtmlInEmail...");
        String html="<h1 style='color:red;border:1px solid red;' >Welcome to new world </h1>";
        emailService.sendEmailWithHtml("aws.vijay28feb@gmail.com","This is from email sender app with html",html);
    }

    @Test
    public void sendEmailWithFile(){
        System.out.println("Sending email with file...");

        emailService.sendEmailWithFile("aws.vijay28feb@gmail.com",
                "Email with file",
                "This email contains file",
                new File("C:\\Users\\kumvijay\\OneDrive - Publicis Groupe\\Desktop\\SKH\\ITR_2023.pdf")
                );
    }

    @Test
    public void sendEmailWithFileStream(){
        System.out.println("Sending email with file...");

        File file = new File("C:\\Users\\kumvijay\\OneDrive - Publicis Groupe\\Desktop\\SKH\\ITR_2023.pdf");

        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile("aws.vijay28feb@gmail.com",
                    "Email with file",
                    "This email contains file",
                    is);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
