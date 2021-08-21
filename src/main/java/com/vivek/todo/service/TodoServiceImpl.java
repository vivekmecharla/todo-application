package com.vivek.todo.service;

import com.vivek.todo.exception.CannotCreateMoreTodosException;
import com.vivek.todo.exception.TodoAlreadyExistsException;
import com.vivek.todo.exception.TodoDoesNotExistException;
import com.vivek.todo.model.Priority;
import com.vivek.todo.model.Status;
import com.vivek.todo.model.Todo;
import com.vivek.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    TodoRepository todoRepository;

    @Value("${todo.maxlimit.perday:2}")
    private int maxLimitPerDay;

    @Override
    public List<Todo> listAll() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todo> findByStatus(Status value) {
        return todoRepository.findAllByStatus(value);
    }

    @Override
    public List<Todo> findByPriority(Priority value) {
        return todoRepository.findAllByPriority(value);
    }

    @Override
    public Todo create(Todo todo) {
        validateCreate(todo);
        validateMaxLimitPerDay();
        return todoRepository.save(todo);
    }

    private void validateCreate(Todo todo) {
        if (!todoRepository.findAllByName(todo.getName()).isEmpty()) {
            throw new TodoAlreadyExistsException();
        }
    }

    private void validateMaxLimitPerDay() {
        if (todoRepository.countAllByCreationTimestampAfter(LocalDateTime.now().minusDays(1)) >= maxLimitPerDay) {
            throw new CannotCreateMoreTodosException();
        }
    }

    @Override
    public Todo update(Todo todo) {
        validateIfTodoIsPresent(todo.getId());
        return todoRepository.save(todo);
    }

    private void validateIfTodoIsPresent(Long id) {
        if (!todoRepository.findById(id).isPresent()) {
            throw new TodoDoesNotExistException();
        }
    }

    @Override
    public void delete(Long id) {
        validateIfTodoIsPresent(id);
        todoRepository.deleteById(id);
    }
}
