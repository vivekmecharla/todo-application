package com.vivek.todo.repository;

import com.vivek.todo.model.Priority;
import com.vivek.todo.model.Status;
import com.vivek.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByStatus(Status status);

    List<Todo> findAllByPriority(Priority priority);

    List<Todo> findAllByName(String name);

    int countAllByCreationTimestampAfter(LocalDateTime timestamp);
}
