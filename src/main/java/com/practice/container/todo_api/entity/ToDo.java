package com.practice.container.todo_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class ToDo {
    private int id;
    private String task;
    private boolean completed;
}
