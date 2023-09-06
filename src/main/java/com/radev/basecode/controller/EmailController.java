package com.radev.basecode.controller;

import com.radev.basecode.common.RestResponse;
import com.radev.basecode.dto.EmailRequest;
import com.radev.basecode.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/create-new")
    public RestResponse sendEmail(@RequestBody EmailRequest emailRequest){
        var rest = new RestResponse();
        rest.setSuccess(true);
        rest.setMessage("");
        try {
            rest.setMessage("Email sent successfully!");
            emailService.sendEmail(emailRequest);
        } catch (Exception e){
            rest.setSuccess(false);
            rest.setMessage("Failed to send email: " + e.getMessage());
        }
        return rest;
    }
}
