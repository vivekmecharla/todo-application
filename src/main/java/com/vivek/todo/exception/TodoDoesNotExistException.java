package com.vivek.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Todo does not Exist")
public class TodoDoesNotExistException extends RuntimeException {
    public TodoDoesNotExistException() {
        super("Todo does not Exist");
    }
}
