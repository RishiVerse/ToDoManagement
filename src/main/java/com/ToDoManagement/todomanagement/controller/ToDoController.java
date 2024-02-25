package com.ToDoManagement.todomanagement.controller;


import com.ToDoManagement.todomanagement.dto.ToDodto;
import com.ToDoManagement.todomanagement.service.ToDoService;
import com.ToDoManagement.todomanagement.service.impl.ToDoImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
public class ToDoController {

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    private ToDoService toDoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ToDodto> createToDo(@RequestBody ToDodto toDodto)
    {

        ToDodto todo=toDoService.addToDo(toDodto);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }


    //@PreAuthorize("hasRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<ToDodto>> getAllToDo()
    {
        return new ResponseEntity<>(toDoService.getAllToDo(), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN','USER')")
    public ResponseEntity<ToDodto> getToDo(@PathVariable Long id)
    {
        return new ResponseEntity<>(toDoService.getToDo(id), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN','USER')")
    public ResponseEntity<ToDodto> updateToDo(@PathVariable Long id,@RequestBody ToDodto toDodto)
    {

        return new ResponseEntity<>(toDoService.updateToDo(id,toDodto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN','USER')")
    public void deleteToDo(@PathVariable Long id)
    {

        toDoService.deleteToDo(id);
    }






}
