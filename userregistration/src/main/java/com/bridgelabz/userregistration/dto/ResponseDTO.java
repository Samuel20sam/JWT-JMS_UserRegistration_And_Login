package com.bridgelabz.userregistration.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
