package com.ToDoManagement.todomanagement.repository;

import com.ToDoManagement.todomanagement.entity.Role;
import com.ToDoManagement.todomanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);

}
