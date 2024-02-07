package com.ToDoManagement.todomanagement.service;

import com.ToDoManagement.todomanagement.dto.ToDodto;

import java.util.List;

public interface ToDoService {

    public ToDodto addToDo(ToDodto tododto);
    public List<ToDodto> getAllToDo();
    public ToDodto updateToDo(Long id,ToDodto tododto);
    public ToDodto getToDo(Long id);
    public void deleteToDo(Long id);

}
