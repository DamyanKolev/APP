package net.javaguides.springboot.exception;

import net.javaguides.springboot.dto.request.UserRequest;

public class CustomUserErrorType extends UserRequest {

    private String errorMessage;

    public CustomUserErrorType(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
