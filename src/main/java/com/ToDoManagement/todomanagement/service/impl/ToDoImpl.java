package com.ToDoManagement.todomanagement.service.impl;

import com.ToDoManagement.todomanagement.dto.ToDodto;
import com.ToDoManagement.todomanagement.entity.Todo;
import com.ToDoManagement.todomanagement.repository.ToDoRepository;
import com.ToDoManagement.todomanagement.service.ToDoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ToDoImpl implements ToDoService {

    private ToDoRepository toDoRepository;
    private ModelMapper modelMapper;

    @Override
    public ToDodto addToDo(ToDodto tododto) {

        Todo todo=modelMapper.map(tododto,Todo.class);

        Todo savedTodo=toDoRepository.save(todo);

        return modelMapper.map(savedTodo,ToDodto.class);

    }

    @Override
    public List<ToDodto> getAllToDo() {

        List<Todo> t=toDoRepository.findAll();

        return t.stream().map(s->modelMapper.map(s,ToDodto.class)).collect(Collectors.toList());
    }

    @Override
    public ToDodto updateToDo(Long id, ToDodto tododto) {
        Optional<Todo> optionalTodo = toDoRepository.findById(id);

            Todo todo = optionalTodo.get();

            todo.setTitle(tododto.getTitle());
            todo.setDescription(tododto.getDescription());

            toDoRepository.save(todo);
            return modelMapper.map(todo,ToDodto.class);


    }

    @Override
    public ToDodto getToDo(Long id) {


        Optional<Todo> todo=toDoRepository.findById(id);

        return modelMapper.map(todo,ToDodto.class);


    }

    @Override
    public void deleteToDo(Long id) {
        Optional<Todo> todo=toDoRepository.findById(id);

       // ToDodto toDodto=modelMapper.map(todo,ToDodto.class);

        Todo todo1=todo.get();


        toDoRepository.delete(todo1);




    }


}
