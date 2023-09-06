package com.radev.basecode.service.implementation;

import com.radev.basecode.dto.EmailRequest;
import com.radev.basecode.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @SneakyThrows
    public void sendEmail(EmailRequest emailRequest) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Set email properties
        helper.setTo(emailRequest.getRecipient());
        helper.setSubject(emailRequest.getSubject());

        // Load the email template
        Context context = new Context();
        context.setVariables(emailRequest.getModel().toMap());
        String emailContent = templateEngine.process("email/" + emailRequest.getTemplateName(), context);

        helper.setText(emailContent, true);

        // Send email
        javaMailSender.send(message);
    }

    private String generateUniqueFilename() {
        // Generate a unique filename, for example, using a UUID
        return UUID.randomUUID().toString();
    }
}
