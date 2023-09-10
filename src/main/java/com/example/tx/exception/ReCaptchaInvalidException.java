package com.example.tx.exception;

public class ReCaptchaInvalidException extends RuntimeException {
    public ReCaptchaInvalidException(String message) {
        super(message);
    }

    public ReCaptchaInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
