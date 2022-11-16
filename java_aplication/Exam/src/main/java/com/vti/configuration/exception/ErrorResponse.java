package com.vti.configuration.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private String deltailMessage;
    private Object error;
    private Integer code;
    private String moreInformation;

    public ErrorResponse(String message, String deltailMessage, Object error, Integer code) {
        this.message = message;
        this.deltailMessage = deltailMessage;
        this.error = error;
        this.code = code;
    }

    public ErrorResponse(String message, String deltailMessage, Object error) {
        this.message = message;
        this.deltailMessage = deltailMessage;
        this.error = error;
    }
}
