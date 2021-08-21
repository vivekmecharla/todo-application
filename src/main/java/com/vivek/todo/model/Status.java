package com.vivek.todo.model;

public enum Status {
    YET_TO_START("YET_TO_START"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED");

    final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
