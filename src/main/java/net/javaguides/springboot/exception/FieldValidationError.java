package net.javaguides.springboot.exception;

import java.awt.TrayIcon.MessageType;

public class FieldValidationError {
    private String filed;
    private String message;
    private MessageType type;

    // Getter & Setter
    public String getFiled() {
        return filed;
    }
    public String getMessage() {
        return message;
    }
    public MessageType getType() {
        return type;
    }
    public void setFiled(String filed) {
        this.filed = filed;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setType(MessageType type) {
        this.type = type;
    }
}
