package com.vivek.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Todo Already Exists")
public class TodoAlreadyExistsException extends RuntimeException {
    public TodoAlreadyExistsException() {
        super("Todo Already Exists");
    }
}
