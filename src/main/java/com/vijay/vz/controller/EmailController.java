package com.vijay.vz.controller;

import com.vijay.vz.helper.CustomResponse;
import com.vijay.vz.helper.EmailRequest;
import com.vijay.vz.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){
        emailService.sendEmail(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage());

        return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully")
                .httpStatus(HttpStatus.OK).success(true));
    }

    @PostMapping("/send-with-file")
    public ResponseEntity<?> sendEmailWithFile(@RequestPart EmailRequest emailRequest, @RequestPart MultipartFile file) throws IOException {
        emailService.sendEmailWithFile(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage(), (File) file);

        return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully")
                .httpStatus(HttpStatus.OK).success(true));
    }


}
