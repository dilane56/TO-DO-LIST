package org.kfokam48.todolist.exceptions;

public class UniqueConstraintViolationException extends RuntimeException {
    private String fieldName;

    public UniqueConstraintViolationException(String message) {
        super(message);
    }

    public UniqueConstraintViolationException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}
