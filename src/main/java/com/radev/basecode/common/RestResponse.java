package com.radev.basecode.common;

import lombok.Data;

@Data
public class RestResponse {
    private Boolean success;
    private String message="";
    private Object data;
}
