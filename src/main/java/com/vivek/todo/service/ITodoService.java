package com.vivek.todo.service;

import com.vivek.todo.model.Priority;
import com.vivek.todo.model.Status;
import com.vivek.todo.model.Todo;

import java.util.List;

public interface ITodoService {
    List<Todo> listAll();

    List<Todo> findByStatus(Status value);

    List<Todo> findByPriority(Priority value);

    Todo create(Todo todo);

    Todo update(Todo todo);

    void delete(Long id);
}
