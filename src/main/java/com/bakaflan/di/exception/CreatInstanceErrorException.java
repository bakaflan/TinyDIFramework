package com.bakaflan.di.exception;

public class CreatInstanceErrorException extends RuntimeException {
    private String message;

    public CreatInstanceErrorException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public CreatInstanceErrorException(String message) {
        super(message);
        this.message = message;
    }
}
