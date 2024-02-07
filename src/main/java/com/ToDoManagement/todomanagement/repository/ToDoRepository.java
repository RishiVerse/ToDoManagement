package com.ToDoManagement.todomanagement.repository;
import com.ToDoManagement.todomanagement.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ToDoRepository extends JpaRepository<Todo,Long> {

    @Override
    <S extends Todo> S save(S entity);

    Optional<Todo> findByDescription(String description);
}
