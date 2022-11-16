package com.vti.slide08.configuration.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String detailMessage;
    private Object error;
    private Integer code;
    private String moreInformation;

    public ErrorResponse(String message, String detailMessage, Object error) {
        this.message = message;
        this.detailMessage = detailMessage;
        this.error = error;
    }

    public ErrorResponse(String message, String detailMessage, Object error, Integer code) {
        this.message = message;
        this.detailMessage = detailMessage;
        this.error = error;
        this.code = code;
    }
}
