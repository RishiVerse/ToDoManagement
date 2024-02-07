package com.ToDoManagement.todomanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDodto {

    private Long id;
    private String title;
    private String description;
    private boolean completed;


}
