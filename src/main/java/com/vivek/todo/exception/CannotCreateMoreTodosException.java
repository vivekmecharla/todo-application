package com.vivek.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Today's Todo Creation Limit Reached")
public class CannotCreateMoreTodosException extends RuntimeException {
    public CannotCreateMoreTodosException() {
        super("Today's Todo Creation Limit Reached");
    }
}
