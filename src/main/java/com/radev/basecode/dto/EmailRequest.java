package com.radev.basecode.dto;

import lombok.Data;

@Data
public class EmailRequest {
    private String recipient;
    private String subject;
    private String templateName;
    private EmailModel model;
}
