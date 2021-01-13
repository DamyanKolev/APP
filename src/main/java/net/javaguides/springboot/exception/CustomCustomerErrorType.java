package net.javaguides.springboot.exception;

import net.javaguides.springboot.dto.request.CustomerRequest;

public class CustomCustomerErrorType  extends CustomerRequest{
    
    private String errorMessage;

    public CustomCustomerErrorType(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
