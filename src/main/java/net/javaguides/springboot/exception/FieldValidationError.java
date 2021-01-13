package net.javaguides.springboot.exception;

import java.awt.TrayIcon.MessageType;

import lombok.Data;

@Data
public class FieldValidationError {
    private String filed;
    private String message;
    private MessageType type;
}
