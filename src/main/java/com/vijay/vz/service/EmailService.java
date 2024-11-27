package com.vijay.vz.service;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    //send email to one person

    void sendEmail(String to,String subject,String message);


    //send email to multiple person
    void sendEmail(String to[],String subject,String message);

    //send html email

    void sendEmailWithHtml(String to,String subject,String message);

    //send email with attachment

    void sendEmailWithFile(String to, String subject, String message, File file);

    void sendEmailWithFile(String to, String subject, String message, InputStream is);
}
