package com.practice.container.todo_api.service;

import com.practice.container.todo_api.entity.ToDo;
import com.practice.container.todo_api.mapper.ToDoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoMapper toDoMapper;

    public List<ToDo> getAllToDos() {
        return toDoMapper.findAll();
    }

    public ToDo getToDoById(int id) {
        return toDoMapper.findById(id);
    }

    public void createToDo(ToDo todo) {
        toDoMapper.insert(todo);
    }

    public void updateToDoById(ToDo todo) {
        toDoMapper.update(todo);
    }

    public void deleteToDoById(int id) {
        toDoMapper.delete(id);
    }
}
