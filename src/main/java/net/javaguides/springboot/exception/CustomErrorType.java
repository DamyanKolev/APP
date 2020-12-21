package net.javaguides.springboot.exception;

import net.javaguides.springboot.model.User;

public class CustomErrorType extends User{
    /**
     *
     */
    private static final long serialVersionUID = 6372375604851630852L;
    
    private String errorMessage;

    public CustomErrorType(final String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
