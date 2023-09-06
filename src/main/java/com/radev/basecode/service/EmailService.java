package com.radev.basecode.service;

import com.radev.basecode.dto.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest emailRequest);
}
