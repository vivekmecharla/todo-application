package com.vivek.todo.controller;

import com.vivek.todo.model.Priority;
import com.vivek.todo.model.Status;
import com.vivek.todo.model.Todo;
import com.vivek.todo.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/todo")
@RestController
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @GetMapping("/all")
    public Iterable<Todo> all() {
        return todoService.listAll();
    }

    @GetMapping("/status/{status}")
    public Iterable<Todo> status(@Validated @PathVariable Status status) {
        return todoService.findByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public Iterable<Todo> priority(@Validated @PathVariable Priority priority) {
        return todoService.findByPriority(priority);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@Validated @RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @PutMapping("/update")
    public Todo update(@Validated @RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void remove(@PathVariable Long id) {
        todoService.delete(id);
    }

}
